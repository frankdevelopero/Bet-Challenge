package com.apuestatotal.app.utils

import com.apuestatotal.app.data.remote.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher = Dispatchers.IO, apiCall: suspend () -> T): ApiResponse<T> {

    return withContext(dispatcher) {
        try {
            ApiResponse.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            ApiResponse.Error(throwable.toError())
        }
    }
}

fun Throwable.toError(): ErrorGeneric = when (this) {
    is IOException -> ErrorGeneric(
        code = 0,
        message = "Lo sentimos, no pudimos conectarnos al servidor.",
        error = stackTraceToString()
    )
    is HttpException -> ErrorGeneric(
        code = code(),
        message = message,
        error = stackTraceToString()
    )
    else -> ErrorGeneric(code = 0, message = message ?: "", error = stackTraceToString())
}