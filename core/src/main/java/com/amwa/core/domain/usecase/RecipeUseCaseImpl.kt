package com.amwa.core.domain.usecase

import com.amwa.core.domain.model.recipe.Recipe
import com.amwa.core.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeUseCaseImpl @Inject constructor(private val recipeRepository: RecipeRepository) :
    RecipeUseCase {
    override fun getAllRecipes() = recipeRepository.getAllRecipes()

    override fun getFavoriteRecipes() = recipeRepository.getFavoriteRecipes()

    override fun setFavoriteRecipe(recipe: Recipe, state: Boolean) =
        recipeRepository.setFavoriteRecipe(recipe, state)

    override fun searchRecipes(query: String) = recipeRepository.searchRecipes(query)

    override fun getRecipes(ids: IntArray) = recipeRepository.getRecipes(ids)

    override fun getSavedRecipe(id: Int) = recipeRepository.getSavedRecipe(id)
}