package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class ExtendedIngredientResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("image")
    val image: String?
)