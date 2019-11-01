package com.lesniak.resumeapp.data

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure<out T>(val throwable: Throwable) : Result<T>()
}