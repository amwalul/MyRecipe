package com.amwa.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.amwa.core.domain.usecase.RecipeUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(recipeUseCase: RecipeUseCase) : ViewModel() {
    val recipeList = recipeUseCase.getFavoriteRecipes().asLiveData()
}