package com.amwa.core.data.source.local.converter

import androidx.room.TypeConverter
import com.amwa.core.data.source.local.entity.InstructionEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class InstructionTypeConverter {

    @TypeConverter
    fun fromInstructionList(value: List<InstructionEntity>): String = with(Gson()) {
        val type = object : TypeToken<List<InstructionEntity>>() {}.type
        toJson(value, type)
    }

    @TypeConverter
    fun toInstructionList(value: String): List<InstructionEntity> = with(Gson()) {
        val type = object : TypeToken<List<InstructionEntity>>() {}.type
        fromJson(value, type)
    }
}