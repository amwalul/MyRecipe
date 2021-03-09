package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class LengthResponse(
    @SerializedName("number")
    val number: Int,
    @SerializedName("unit")
    val unit: String
)