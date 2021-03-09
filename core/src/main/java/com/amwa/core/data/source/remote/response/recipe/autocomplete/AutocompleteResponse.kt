package com.amwa.core.data.source.remote.response.recipe.autocomplete


import com.google.gson.annotations.SerializedName

data class AutocompleteResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("imageType")
    val imageType: String
)