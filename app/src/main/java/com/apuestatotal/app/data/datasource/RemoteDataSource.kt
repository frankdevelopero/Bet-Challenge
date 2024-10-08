package com.apuestatotal.app.data.datasource

import com.apuestatotal.app.data.model.request.SignInRequest
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity
import com.apuestatotal.app.domain.entity.BetHistoryEntity
import com.apuestatotal.app.domain.entity.UserEntity
import com.apuestatotal.app.data.remote.ApiResponse

interface RemoteDataSource {

    suspend fun getBets(): ApiResponse<List<BetHistoryEntity>>
    suspend fun getDetailBets(betId: String): ApiResponse<List<BetHistoryDetailEntity>>

    suspend fun signIn(signInRequest: SignInRequest): ApiResponse<UserEntity>



}