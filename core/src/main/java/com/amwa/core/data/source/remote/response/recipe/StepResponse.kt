package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class StepResponse(
    @SerializedName("number")
    val number: Int,
    @SerializedName("step")
    val step: String,
    @SerializedName("ingredients")
    val ingredients: List<IngredientResponse>,
    @SerializedName("equipment")
    val equipment: List<EquipmentResponse>,
    @SerializedName("length")
    val length: LengthResponse
)