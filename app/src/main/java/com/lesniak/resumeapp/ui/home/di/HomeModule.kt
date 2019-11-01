package com.lesniak.resumeapp.ui.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lesniak.resumeapp.data.ResumeRepositoryImpl
import com.lesniak.resumeapp.ui.home.HomeFragment
import com.lesniak.resumeapp.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @HomeScope
    @Provides
    fun viewModelFactory(resumeRepository: ResumeRepositoryImpl): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(resumeRepository) as T
            }
        }

    @HomeScope
    @Provides
    fun homeViewModel(
        fragment: HomeFragment,
        viewModelFactory: ViewModelProvider.Factory
    ): HomeViewModel =
        ViewModelProviders.of(
            fragment.requireActivity(),
            viewModelFactory
        ).get(HomeViewModel::class.java)
}