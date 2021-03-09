package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class EquipmentResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("localizedName")
    val localizedName: String,
    @SerializedName("image")
    val image: String
)