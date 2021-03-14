package com.amwa.core.data.source.remote.response.recipe

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredientResponse>,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: List<AnalyzedInstructionResponse>,
)