package com.amwa.myrecipe.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.amwa.core.domain.model.recipe.Recipe
import com.amwa.core.domain.usecase.RecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val recipeUseCase: RecipeUseCase) : ViewModel() {

    fun getSavedRecipe(id: Int) = recipeUseCase.getSavedRecipe(id).asLiveData()

    fun setFavoriteRecipe(recipe: Recipe, state: Boolean) =
        recipeUseCase.setFavoriteRecipe(recipe, state)
}