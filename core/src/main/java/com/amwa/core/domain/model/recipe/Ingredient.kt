package com.amwa.core.domain.model.recipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingredient(
    val name: String,
    val image: String?,
    val amount: Double,
    val unit: String
) : Parcelable