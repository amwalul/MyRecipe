package com.amwa.core.data.source.local

import com.amwa.core.data.source.local.entity.RecipeEntity
import com.amwa.core.data.source.local.room.RecipeDao
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val recipeDao: RecipeDao) {

    fun getAllRecipes(): Flow<List<RecipeEntity>> = recipeDao.getAllRecipes()

    fun getFavoriteRecipes(): Flow<List<RecipeEntity>> = recipeDao.getFavoriteRecipes()

    suspend fun insertRecipes(recipeList: List<RecipeEntity>) = recipeDao.insertRecipes(recipeList)

    fun setFavoriteRecipe(recipe: RecipeEntity, newState: Boolean) {
        Timber.d("set favorite '${recipe.title}': $newState")
        recipe.isFavorite = newState
        recipeDao.insertRecipe(recipe)
    }

    fun getSavedRecipe(id: Int): Flow<RecipeEntity?> = recipeDao.getRecipe(id)
}