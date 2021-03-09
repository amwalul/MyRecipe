package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class MeasuresResponse(
    @SerializedName("us")
    val us: UsResponse,
    @SerializedName("metric")
    val metric: MetricResponse
)