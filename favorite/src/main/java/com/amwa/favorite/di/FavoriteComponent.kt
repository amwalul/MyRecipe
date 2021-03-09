package com.amwa.favorite.di

import com.amwa.favorite.FavoriteFragment
import com.amwa.myrecipe.di.FavoriteModuleDependencies
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(fragment: FavoriteFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FavoriteModuleDependencies): FavoriteComponent
    }
}