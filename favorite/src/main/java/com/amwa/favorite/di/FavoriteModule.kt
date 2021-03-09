package com.amwa.favorite.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.amwa.favorite.FavoriteViewModel
import com.amwa.favorite.FavoriteViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class FavoriteModule {

    @Provides
    fun provideFavoriteViewModel(fragment: Fragment, factory: FavoriteViewModelFactory) =
        ViewModelProvider(fragment, factory).get(FavoriteViewModel::class.java)
}