package com.mexingsoft.kosmosapp.domain

import android.os.Bundle

sealed class ResponseState<out T> {
    data class Success<T>(val result: T) : ResponseState<T>()
    data object Loading : ResponseState<Nothing>()
    data class Error(val errorType: DataResultError) : ResponseState<Nothing>()
}

sealed class DataResultError {
    data object NoError : DataResultError()
    data object EmptyResult : DataResultError()
    data object NoInternet : DataResultError()
}