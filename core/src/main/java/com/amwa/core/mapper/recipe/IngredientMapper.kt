package com.amwa.core.mapper.recipe

import com.amwa.core.data.source.local.entity.IngredientEntity
import com.amwa.core.data.source.remote.response.recipe.ExtendedIngredientResponse
import com.amwa.core.domain.model.recipe.Ingredient
import com.amwa.core.mapper.DomainMapper
import com.amwa.core.mapper.EntityMapper

object IngredientResponseMapper : EntityMapper<ExtendedIngredientResponse, IngredientEntity>,
    DomainMapper<ExtendedIngredientResponse, Ingredient> {
    override fun mapToEntity(type: ExtendedIngredientResponse) = with(type) {
        IngredientEntity(name, image, amount, unit)
    }

    override fun mapToDomain(type: ExtendedIngredientResponse) = with(type) {
        Ingredient(name, image, amount, unit)
    }
}

object IngredientEntityMapper : DomainMapper<IngredientEntity, Ingredient> {
    override fun mapToDomain(type: IngredientEntity) = with(type) {
        Ingredient(name, image, amount, unit)
    }
}

object IngredientDomainMapper : EntityMapper<Ingredient, IngredientEntity> {
    override fun mapToEntity(type: Ingredient) = with(type) {
        IngredientEntity(name, image, amount, unit)
    }
}