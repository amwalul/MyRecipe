package com.amwa.core.data

import com.amwa.core.data.source.NetworkResource
import com.amwa.core.data.source.local.LocalDataSource
import com.amwa.core.data.source.remote.RemoteDataSource
import com.amwa.core.data.source.remote.network.ApiResponse
import com.amwa.core.data.source.remote.response.recipe.RecipeResponse
import com.amwa.core.data.source.remote.response.recipe.autocomplete.AutocompleteResponse
import com.amwa.core.domain.model.recipe.Recipe
import com.amwa.core.domain.model.recipe.autocomplete.Autocomplete
import com.amwa.core.domain.repository.RecipeRepository
import com.amwa.core.mapper.recipe.RecipeDomainMapper
import com.amwa.core.mapper.recipe.RecipeEntityMapper
import com.amwa.core.mapper.recipe.RecipeResponseMapper
import com.amwa.core.mapper.recipe.autocomplete.AutocompleteResponseMapper
import com.amwa.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : RecipeRepository {
    override fun getAllRecipes(): Flow<Resource<List<Recipe>>> =
        object : NetworkBoundResource<List<Recipe>, List<RecipeResponse>>() {
            override fun loadFromDB(): Flow<List<Recipe>> {
                return localDataSource.getAllRecipes().map { entityList ->
                    entityList.map { RecipeEntityMapper.mapToDomain(it) }
                }
            }

            override fun shouldFetch(data: List<Recipe>?): Boolean = data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<RecipeResponse>>> =
                remoteDataSource.getAllRecipes()

            override suspend fun saveCallResult(data: List<RecipeResponse>) {
                val recipeList = data.map { RecipeResponseMapper.mapToEntity(it) }
                localDataSource.insertRecipes(recipeList)
            }

        }.asFlow()

    override fun getFavoriteRecipes(): Flow<List<Recipe>> =
        localDataSource.getFavoriteRecipes().map { entityList ->
            entityList.map { RecipeEntityMapper.mapToDomain(it) }
        }

    override fun setFavoriteRecipe(recipe: Recipe, state: Boolean) {
        val recipeEntity = RecipeDomainMapper.mapToEntity(recipe)
        appExecutors.diskIO().execute { localDataSource.setFavoriteRecipe(recipeEntity, state) }
    }

    override fun searchRecipes(query: String): Flow<Resource<List<Autocomplete>>> =
        object : NetworkResource<List<Autocomplete>, List<AutocompleteResponse>>() {
            override suspend fun createCall(): Flow<ApiResponse<List<AutocompleteResponse>>> =
                remoteDataSource.searchRecipes(query)

            override fun mapCallResult(data: List<AutocompleteResponse>): List<Autocomplete> =
                data.map { AutocompleteResponseMapper.mapToDomain(it) }
        }.asFlow()

    override fun getRecipes(ids: IntArray): Flow<Resource<List<Recipe>>> =
        object : NetworkResource<List<Recipe>, List<RecipeResponse>>() {
            override suspend fun createCall(): Flow<ApiResponse<List<RecipeResponse>>> =
                remoteDataSource.getRecipes(ids.joinToString(","))

            override fun mapCallResult(data: List<RecipeResponse>): List<Recipe> =
                data.map { RecipeResponseMapper.mapToDomain(it) }

        }.asFlow()

    override fun getSavedRecipe(id: Int): Flow<Recipe?> = localDataSource.getSavedRecipe(id).map {
        it?.let { entity -> RecipeEntityMapper.mapToDomain(entity) }
    }
}