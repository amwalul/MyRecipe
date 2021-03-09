package com.amwa.core.data.source.remote.network

import com.amwa.core.BuildConfig
import com.amwa.core.data.source.remote.response.recipe.RecipeListResponse
import com.amwa.core.data.source.remote.response.recipe.RecipeResponse
import com.amwa.core.data.source.remote.response.recipe.autocomplete.AutocompleteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("number") number: Int = 20,
        @Query("apiKey") apiKey: String = BuildConfig.SPOONACULAR_API_KEY
    ): RecipeListResponse

    @GET("recipes/autocomplete")
    suspend fun searchRecipes(
        @Query("query") query: String,
        @Query("number") number: Int = 10,
        @Query("apiKey") apiKey: String = BuildConfig.SPOONACULAR_API_KEY
    ): List<AutocompleteResponse>

    @GET("recipes/informationBulk")
    suspend fun getRecipes(
        @Query("ids") ids: String,
        @Query("apiKey") apiKey: String = BuildConfig.SPOONACULAR_API_KEY
    ): List<RecipeResponse>
}
