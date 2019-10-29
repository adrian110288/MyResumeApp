package com.lesniak.resumeapp.data

sealed class ResourceState<out T> {
    class Loading<out T> : ResourceState<T>()
    data class Success<out T>(val data: T) : ResourceState<T>()
    data class Failure<out T>(val throwable: Throwable) : ResourceState<T>()
}