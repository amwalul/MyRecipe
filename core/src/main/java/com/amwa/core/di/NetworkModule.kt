package com.amwa.core.di

import com.amwa.core.data.source.remote.network.ApiService
import com.amwa.core.data.source.remote.network.ServiceFactory
import com.amwa.core.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(Constants.BASE_URL)
}