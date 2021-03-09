package com.amwa.core.domain.model.recipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Instruction(
    val number: Int,
    val step: String
) : Parcelable