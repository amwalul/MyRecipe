package com.amwa.core.data.source.local.room

import androidx.room.*
import com.amwa.core.data.source.local.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe WHERE isFavorite = 1")
    fun getFavoriteRecipes(): Flow<List<RecipeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipeList: List<RecipeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(recipe: RecipeEntity)

    @Query("SELECT * FROM recipe WHERE id = :id")
    fun getRecipe(id: Int): Flow<RecipeEntity?>

    @Query("SELECT EXISTS(SELECT * FROM recipe WHERE id = :id)")
    fun checkRecipeExist(id : Int) : Boolean

}