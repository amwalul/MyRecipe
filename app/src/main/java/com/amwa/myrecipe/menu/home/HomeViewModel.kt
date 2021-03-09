package com.amwa.myrecipe.menu.home

import androidx.lifecycle.*
import com.amwa.core.data.Resource
import com.amwa.core.domain.model.recipe.Recipe
import com.amwa.core.domain.usecase.RecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@FlowPreview
@ExperimentalCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(private val recipeUseCase: RecipeUseCase) : ViewModel() {
    private val _recipeList = MutableLiveData<Resource<List<Recipe>>>()
    val recipeList: LiveData<Resource<List<Recipe>>> = _recipeList

    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    val searchResult = queryChannel.asFlow()
        .debounce(400)
        .distinctUntilChanged()
        .flatMapConcat {
            recipeUseCase.searchRecipes(it)
        }
        .asLiveData()

    init {
        getAllRecipes()
    }

    fun getAllRecipes() {
        viewModelScope.launch {
            recipeUseCase.getAllRecipes().collect {
                _recipeList.postValue(it)
            }
        }
    }

    fun getRecipes(ids: IntArray) {
        viewModelScope.launch {
            recipeUseCase.getRecipes(ids).collect {
                _recipeList.postValue(it)
            }
        }
    }
}