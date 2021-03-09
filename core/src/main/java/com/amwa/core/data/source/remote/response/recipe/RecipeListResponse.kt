package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class RecipeListResponse(
    @SerializedName("recipes")
    val recipes: List<RecipeResponse>
)