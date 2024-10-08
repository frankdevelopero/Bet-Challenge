package com.apuestatotal.app.data.remote

import com.apuestatotal.app.utils.ErrorGeneric

sealed class ApiResponse<out T> {
    data class Success<T>(val value: T): ApiResponse<T>()
    data class Error(val error: ErrorGeneric? = null) : ApiResponse<Nothing>()
}