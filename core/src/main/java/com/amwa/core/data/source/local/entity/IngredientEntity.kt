package com.amwa.core.data.source.local.entity

data class IngredientEntity(
    val name: String,
    val image: String?,
    val amount: Double,
    val unit: String
)