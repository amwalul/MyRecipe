package com.amwa.core.data.source.local.converter

import androidx.room.TypeConverter
import com.amwa.core.data.source.local.entity.IngredientEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IngredientTypeConverter {

    @TypeConverter
    fun fromIngredientList(value: List<IngredientEntity>): String = with(Gson()) {
        val type = object : TypeToken<List<IngredientEntity>>() {}.type
        toJson(value, type)
    }

    @TypeConverter
    fun toIngredientList(value: String): List<IngredientEntity> = with(Gson()) {
        val type = object : TypeToken<List<IngredientEntity>>() {}.type
        fromJson(value, type)
    }
}