package com.apuestatotal.app.domain.repository

import com.apuestatotal.app.data.model.request.SignInRequest
import com.apuestatotal.app.domain.entity.UserEntity
import com.apuestatotal.app.data.remote.ApiResponse

interface UserRepository {
    suspend fun signIn(signInRequest: SignInRequest): ApiResponse<UserEntity>
}