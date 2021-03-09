package com.amwa.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amwa.core.data.source.local.converter.IngredientTypeConverter
import com.amwa.core.data.source.local.converter.InstructionTypeConverter
import com.amwa.core.data.source.local.entity.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1, exportSchema = false)
@TypeConverters(IngredientTypeConverter::class, InstructionTypeConverter::class)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        fun create(context: Context) = Room.databaseBuilder(
            context,
            RecipeDatabase::class.java,
            "Recipe.db"
        ).fallbackToDestructiveMigration().build()
    }
}