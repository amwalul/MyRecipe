package com.amwa.core.data.source.remote

import com.amwa.core.data.source.remote.network.ApiResponse
import com.amwa.core.data.source.remote.network.ApiService
import com.amwa.core.data.source.remote.response.recipe.RecipeResponse
import com.amwa.core.data.source.remote.response.recipe.autocomplete.AutocompleteResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllRecipes(): Flow<ApiResponse<List<RecipeResponse>>> = flow {
        try {
            val response = apiService.getRandomRecipes()
            val data = response.recipes
            val result = ApiResponse.Success(data)
            emit(result)
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun searchRecipes(query: String): Flow<ApiResponse<List<AutocompleteResponse>>> = flow {
        try {
            val data = apiService.searchRecipes(query)
            val result = ApiResponse.Success(data)
            emit(result)
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getRecipes(ids: String): Flow<ApiResponse<List<RecipeResponse>>> = flow {
        try {
            val data = apiService.getRecipes(ids)
            val result = ApiResponse.Success(data)
            emit(result)
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)
}