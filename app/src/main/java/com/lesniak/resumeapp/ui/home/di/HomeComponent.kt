package com.lesniak.resumeapp.ui.home.di

import com.lesniak.resumeapp.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Subcomponent

@HomeScope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: HomeFragment): HomeComponent
    }

    fun inject(fragment: HomeFragment)
}