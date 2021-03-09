package com.amwa.myrecipe.di

import com.amwa.core.domain.usecase.RecipeUseCase
import com.amwa.core.domain.usecase.RecipeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideRecipeUseCase(recipeUseCaseImpl: RecipeUseCaseImpl): RecipeUseCase
}