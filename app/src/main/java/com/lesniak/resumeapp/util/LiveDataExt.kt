package com.lesniak.resumeapp.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeValue(lifecycleOwner: LifecycleOwner, observer: ((T) -> Unit)) {
    this.observe(lifecycleOwner, Observer { observer.invoke(it) })
}