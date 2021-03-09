package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class MetricResponse(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("unitShort")
    val unitShort: String,
    @SerializedName("unitLong")
    val unitLong: String
)