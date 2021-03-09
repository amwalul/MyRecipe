package com.amwa.core.mapper.recipe

import com.amwa.core.data.source.local.entity.RecipeEntity
import com.amwa.core.data.source.remote.response.recipe.RecipeResponse
import com.amwa.core.domain.model.recipe.Recipe
import com.amwa.core.mapper.DomainMapper
import com.amwa.core.mapper.EntityMapper

object RecipeResponseMapper : EntityMapper<RecipeResponse, RecipeEntity>,
    DomainMapper<RecipeResponse, Recipe> {
    override fun mapToEntity(type: RecipeResponse) = with(type) {
        val instructions =
            if (analyzedInstructions.isNotEmpty()) analyzedInstructions[0].steps.map {
                InstructionResponseMapper.mapToEntity(it)
            } else emptyList()
        RecipeEntity(
            id,
            title,
            image,
            extendedIngredients.map { IngredientResponseMapper.mapToEntity(it) },
            instructions
        )
    }

    override fun mapToDomain(type: RecipeResponse) = with(type) {
        val instructions =
            if (analyzedInstructions.isNotEmpty()) analyzedInstructions[0].steps.map {
                InstructionResponseMapper.mapToDomain(it)
            } else emptyList()
        Recipe(
            id,
            title,
            image,
            extendedIngredients.map { IngredientResponseMapper.mapToDomain(it) },
            instructions,
            false
        )
    }
}

object RecipeEntityMapper : DomainMapper<RecipeEntity, Recipe> {
    override fun mapToDomain(type: RecipeEntity) = with(type) {
        Recipe(
            id,
            title,
            image,
            ingredients.map { IngredientEntityMapper.mapToDomain(it) },
            instructions.map { InstructionEntityMapper.mapToDomain(it) },
            isFavorite
        )
    }
}

object RecipeDomainMapper : EntityMapper<Recipe, RecipeEntity> {
    override fun mapToEntity(type: Recipe) = with(type) {
        RecipeEntity(
            id,
            title,
            image,
            ingredients.map { IngredientDomainMapper.mapToEntity(it) },
            instructions.map { InstructionDomainMapper.mapToEntity(it) },
            isFavorite
        )
    }
}