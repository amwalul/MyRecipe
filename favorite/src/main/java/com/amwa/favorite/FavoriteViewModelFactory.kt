package com.amwa.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amwa.core.domain.usecase.RecipeUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class FavoriteViewModelFactory @Inject constructor(
    private val recipeUseCase: RecipeUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != FavoriteViewModel::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return FavoriteViewModel(recipeUseCase) as T
    }
}