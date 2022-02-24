package com.codingwithmitch.daggerhiltplayground.util

import java.lang.Exception

sealed class DataState<out R> {
    data class OnSuccess<out T>(val data: T) : DataState<T>()
    data class onFailure(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}