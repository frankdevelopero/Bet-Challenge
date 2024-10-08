package com.apuestatotal.app.data.repository

import com.apuestatotal.app.data.datasource.RemoteDataSource
import com.apuestatotal.app.domain.entity.BetHistoryEntity
import com.apuestatotal.app.domain.repository.BetRepository
import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity
import javax.inject.Inject

class BetRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BetRepository {

    override suspend fun getBets(): ApiResponse<List<BetHistoryEntity>> {
        return remoteDataSource.getBets()
    }

    override suspend fun getDetailBets(betId: String): ApiResponse<List<BetHistoryDetailEntity>> {
        return remoteDataSource.getDetailBets(betId)
    }
}
