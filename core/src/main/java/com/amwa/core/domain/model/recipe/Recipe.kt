package com.amwa.core.domain.model.recipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: Int,
    val title: String,
    val image: String,
    val ingredients: List<Ingredient>,
    val instructions: List<Instruction>,
    var isFavorite: Boolean
) : Parcelable
