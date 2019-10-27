package com.lesniak.resumeapp

import android.app.Application
import com.lesniak.resumeapp.di.AppComponent
import com.lesniak.resumeapp.di.DaggerAppComponent

class ResumeApp : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}