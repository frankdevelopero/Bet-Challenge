package com.apuestatotal.app.data.model

import com.google.gson.annotations.SerializedName

data class BetHistoryModel(
    @SerializedName("event_name") val eventName: String,
    @SerializedName("market_name") val marketName: String,
    @SerializedName("db") val db: Int,
    @SerializedName("operation") val operation: Long,
    @SerializedName("game") val game: String,
    @SerializedName("created_date") val createdDate: String,
    @SerializedName("status") val status: String,
    @SerializedName("wager") val wager: Int,
    @SerializedName("winning") val winning: Double?,
    @SerializedName("odds") val odds: Double,
    @SerializedName("type") val type: String,
    @SerializedName("account") val account: String
)
