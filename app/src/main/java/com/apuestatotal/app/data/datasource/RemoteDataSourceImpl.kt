package com.apuestatotal.app.data.datasource

import com.apuestatotal.app.data.mappers.toDomain
import com.apuestatotal.app.data.model.request.SignInRequest
import com.apuestatotal.app.data.remote.BetApiClient
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity
import com.apuestatotal.app.domain.entity.BetHistoryEntity
import com.apuestatotal.app.domain.entity.UserEntity
import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.utils.safeApiCall
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: BetApiClient
) : RemoteDataSource {
    override suspend fun getBets(): ApiResponse<List<BetHistoryEntity>> {
        return safeApiCall {
            apiService.getBetHistory().map { it.toDomain() }
        }
    }

    override suspend fun getDetailBets(betId: String): ApiResponse<List<BetHistoryDetailEntity>> {
        return safeApiCall {
            val response = apiService.getBetDetailHistory(betId)
            response.betSelections.map { it.toDomain() }
        }
    }


    override suspend fun signIn(signInRequest: SignInRequest): ApiResponse<UserEntity> {
        return safeApiCall {
            apiService.signIn(signInRequest).toDomain()
        }
    }
}