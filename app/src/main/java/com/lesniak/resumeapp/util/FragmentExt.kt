package com.lesniak.resumeapp.util

import androidx.fragment.app.Fragment
import com.lesniak.resumeapp.ResumeApp
import com.lesniak.resumeapp.di.AppComponent

val Fragment.appComponent: AppComponent
    get() = (requireContext().applicationContext as ResumeApp).appComponent