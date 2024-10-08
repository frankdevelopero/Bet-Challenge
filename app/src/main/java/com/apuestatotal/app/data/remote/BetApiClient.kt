package com.apuestatotal.app.data.remote

import com.apuestatotal.app.data.model.BetDetailResponse
import com.apuestatotal.app.data.model.BetHistoryModel
import com.apuestatotal.app.data.model.UserModel
import com.apuestatotal.app.data.model.request.SignInRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BetApiClient {

    @GET("users/bet-history")
    suspend fun getBetHistory(): List<BetHistoryModel>

    @GET("users/bet-history/{id}/")
    suspend fun getBetDetailHistory(@Path("id") id: String): BetDetailResponse

    @POST("users/auth/signin")
    suspend fun signIn(@Body signInRequest: SignInRequest): UserModel

}