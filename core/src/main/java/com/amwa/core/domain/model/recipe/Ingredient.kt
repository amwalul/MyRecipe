package com.amwa.core.domain.model.recipe

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Ingredient(
    val name: String,
    val image: String?,
    val amount: Double,
    val unit: String
) : Parcelable