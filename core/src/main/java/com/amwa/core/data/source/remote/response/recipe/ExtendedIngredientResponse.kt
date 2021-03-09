package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class ExtendedIngredientResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("aisle")
    val aisle: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("consistency")
    val consistency: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("originalString")
    val originalString: String,
    @SerializedName("originalName")
    val originalName: String,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("meta")
    val meta: List<String>,
    @SerializedName("metaInformation")
    val metaInformation: List<String>,
    @SerializedName("measures")
    val measures: MeasuresResponse
)