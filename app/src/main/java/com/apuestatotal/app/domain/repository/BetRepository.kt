package com.apuestatotal.app.domain.repository

import com.apuestatotal.app.domain.entity.BetHistoryEntity
import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity

interface BetRepository {
    suspend fun getBets(): ApiResponse<List<BetHistoryEntity>>
    suspend fun getDetailBets(betId: String): ApiResponse<List<BetHistoryDetailEntity>>
}