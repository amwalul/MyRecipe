package com.amwa.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey
    @NonNull
    val id: Int,
    val title: String,
    val image: String,
    val ingredients: List<IngredientEntity>,
    val instructions: List<InstructionEntity>,
    var isFavorite: Boolean = false
)
