package com.amwa.core.di

import com.amwa.core.data.RecipeRepositoryImpl
import com.amwa.core.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository
}