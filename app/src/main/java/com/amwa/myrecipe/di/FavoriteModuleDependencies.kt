package com.amwa.myrecipe.di

import com.amwa.core.domain.usecase.RecipeUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface FavoriteModuleDependencies {

    fun recipeUseCase(): RecipeUseCase
}