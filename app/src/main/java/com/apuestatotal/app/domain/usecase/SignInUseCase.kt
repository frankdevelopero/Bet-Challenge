package com.apuestatotal.app.domain.usecase

import com.apuestatotal.app.data.model.request.SignInRequest
import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.UserEntity
import com.apuestatotal.app.domain.repository.UserRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(signInRequest: SignInRequest): ApiResponse<UserEntity> {
        return userRepository.signIn(signInRequest)
    }
}
