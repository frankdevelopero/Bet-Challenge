package com.apuestatotal.app.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class BetHistoryEntity(
    val eventName: String,
    val marketName: String,
    val db: Int,
    val operation: Long,
    val game: String,
    val createdDate: String,
    val status: String,
    val wager: Int,
    val winning: Double?,
    val odds: Double,
    val type: String,
    val account: String
) : Parcelable
