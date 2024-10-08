package com.apuestatotal.app.domain.usecase

import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity
import com.apuestatotal.app.domain.entity.BetHistoryEntity
import com.apuestatotal.app.domain.repository.BetRepository
import javax.inject.Inject

class GetBetHistoryUseCase @Inject constructor(
    private val betRepository: BetRepository
) {
    suspend operator fun invoke(): ApiResponse<List<BetHistoryEntity>> {
        return betRepository.getBets()
    }

    suspend fun getBetDetail(betId: String): ApiResponse<List<BetHistoryDetailEntity>> {
        return betRepository.getDetailBets(betId)
    }
}
