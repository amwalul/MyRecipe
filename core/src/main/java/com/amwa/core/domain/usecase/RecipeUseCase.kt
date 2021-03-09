package com.amwa.core.domain.usecase

import com.amwa.core.data.Resource
import com.amwa.core.domain.model.recipe.Recipe
import com.amwa.core.domain.model.recipe.autocomplete.Autocomplete
import kotlinx.coroutines.flow.Flow

interface RecipeUseCase {
    fun getAllRecipes(): Flow<Resource<List<Recipe>>>

    fun getFavoriteRecipes(): Flow<List<Recipe>>

    fun setFavoriteRecipe(recipe: Recipe, state: Boolean)

    fun searchRecipes(query: String): Flow<Resource<List<Autocomplete>>>

    fun getRecipes(ids: IntArray): Flow<Resource<List<Recipe>>>

    fun getSavedRecipe(id: Int): Flow<Recipe?>
}