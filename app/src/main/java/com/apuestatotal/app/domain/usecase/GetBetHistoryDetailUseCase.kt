package com.apuestatotal.app.domain.usecase

import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity
import com.apuestatotal.app.domain.repository.BetRepository
import javax.inject.Inject

class GetBetHistoryDetailUseCase @Inject constructor(
    private val betRepository: BetRepository
) {
    suspend operator fun invoke(betId: String): ApiResponse<List<BetHistoryDetailEntity>> {
        return betRepository.getDetailBets(betId)
    }
}
