package com.amwa.core.domain.model.recipe

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

// Parcelable dipakai di dalam file graph_main.xml sebagai argument
@Keep
@Parcelize
data class Recipe(
    val id: Int,
    val title: String,
    val image: String?,
    val ingredients: List<Ingredient>,
    val instructions: List<Instruction>,
    var isFavorite: Boolean
) : Parcelable
