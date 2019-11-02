package com.lesniak.resumeapp.ui.home.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.lesniak.resumeapp.data.ResumeRepositoryImpl
import com.lesniak.resumeapp.ui.home.HomeFragment
import com.lesniak.resumeapp.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

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

    @HomeScope
    @Named("spanCount")
    @Provides
    fun skillListSpanCount(): Int = 3

    @HomeScope
    @Provides
    fun skillListLayoutManager(context: Context, @Named("spanCount") spanCount: Int) =
        GridLayoutManager(context, spanCount)
}