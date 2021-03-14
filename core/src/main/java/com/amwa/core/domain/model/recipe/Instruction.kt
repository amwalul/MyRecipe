package com.amwa.core.domain.model.recipe

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Instruction(
    val number: Int,
    val step: String
) : Parcelable