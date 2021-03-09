package com.amwa.core.data.source.remote.response.recipe

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("vegetarian")
    val vegetarian: Boolean,
    @SerializedName("vegan")
    val vegan: Boolean,
    @SerializedName("glutenFree")
    val glutenFree: Boolean,
    @SerializedName("dairyFree")
    val dairyFree: Boolean,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean,
    @SerializedName("cheap")
    val cheap: Boolean,
    @SerializedName("veryPopular")
    val veryPopular: Boolean,
    @SerializedName("sustainable")
    val sustainable: Boolean,
    @SerializedName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int,
    @SerializedName("gaps")
    val gaps: String,
    @SerializedName("lowFodmap")
    val lowFodmap: Boolean,
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int,
    @SerializedName("spoonacularScore")
    val spoonacularScore: Double,
    @SerializedName("healthScore")
    val healthScore: Double,
    @SerializedName("creditsText")
    val creditsText: String,
    @SerializedName("license")
    val license: String,
    @SerializedName("sourceName")
    val sourceName: String,
    @SerializedName("pricePerServing")
    val pricePerServing: Double,
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredientResponse>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("sourceUrl")
    val sourceUrl: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("cuisines")
    val cuisines: List<String>,
    @SerializedName("dishTypes")
    val dishTypes: List<String>,
    @SerializedName("diets")
    val diets: List<String>,
    @SerializedName("occasions")
    val occasions: List<Any>,
    @SerializedName("instructions")
    val instructions: String,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: List<AnalyzedInstructionResponse>,
    @SerializedName("originalId")
    val originalId: Any?,
    @SerializedName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String
)