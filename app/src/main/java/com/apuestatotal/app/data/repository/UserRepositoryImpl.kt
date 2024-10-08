package com.apuestatotal.app.data.repository

import com.apuestatotal.app.data.datasource.RemoteDataSource
import com.apuestatotal.app.data.model.request.SignInRequest
import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.UserEntity
import com.apuestatotal.app.domain.repository.UserRepository
import com.apuestatotal.app.utils.safeApiCall
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : UserRepository{

    override suspend fun signIn(signInRequest: SignInRequest): ApiResponse<UserEntity> {
        return remoteDataSource.signIn(signInRequest)
    }

}