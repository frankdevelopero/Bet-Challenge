package com.apuestatotal.app.data.mappers

import com.apuestatotal.app.data.model.BetHistoryDetailModel
import com.apuestatotal.app.data.model.BetHistoryModel
import com.apuestatotal.app.data.model.UserModel
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity
import com.apuestatotal.app.domain.entity.BetHistoryEntity
import com.apuestatotal.app.domain.entity.UserEntity

fun BetHistoryModel.toDomain(): BetHistoryEntity {
    return BetHistoryEntity(
        eventName = this.eventName,
        marketName = this.marketName,
        db = this.db,
        operation = this.operation,
        game = this.game,
        createdDate = this.createdDate,
        status = this.status,
        wager = this.wager,
        winning = this.winning,
        odds = this.odds,
        type = this.type,
        account = this.account
    )
}

fun BetHistoryEntity.toData(): BetHistoryModel {
    return BetHistoryModel(
        eventName = this.eventName,
        marketName = this.marketName,
        db = this.db,
        operation = this.operation,
        game = this.game,
        createdDate = this.createdDate,
        status = this.status,
        wager = this.wager,
        winning = this.winning,
        odds = this.odds,
        type = this.type,
        account = this.account
    )
}

fun BetHistoryDetailModel.toDomain(): BetHistoryDetailEntity {
    return BetHistoryDetailEntity(
        selectionId = this.selectionId,
        selectionStatus = this.selectionStatus,
        price = this.price,
        name = this.name,
        spec = this.spec,
        marketTypeId = this.marketTypeId,
        marketId = this.marketId,
        marketName = this.marketName,
        isLive = this.isLive,
        isBetBuilder = this.isBetBuilder,
        isBanker = this.isBanker,
        isVirtual = this.isVirtual,
        bbSelections = this.bbSelections,
        eventId = this.eventId,
        eventCode = this.eventCode,
        feedEventId = this.feedEventId,
        eventName = this.eventName,
        sportTypeId = this.sportTypeId,
        categoryId = this.categoryId,
        categoryName = this.categoryName,
        champId = this.champId,
        champName = this.champName,
        eventScore = this.eventScore,
        gameTime = this.gameTime,
        eventDate = this.eventDate,
        pitcherInfo = this.pitcherInfo,
        runners = this.runners,
        extraEventInfo = this.extraEventInfo,
        rc = this.rc,
        liveInfoAtEventMinute = this.liveInfoAtEventMinute,
        isLiveOrVirtual = this.isLiveOrVirtual,
        earlyPayout = this.earlyPayout,
        boreDraw = this.boreDraw,
        deadHeatFactor = this.deadHeatFactor,
        dbId = this.dbId
    )
}

fun BetHistoryDetailEntity.toModel(): BetHistoryDetailModel {
    return BetHistoryDetailModel(
        selectionId = this.selectionId,
        selectionStatus = this.selectionStatus,
        price = this.price,
        name = this.name,
        spec = this.spec,
        marketTypeId = this.marketTypeId,
        marketId = this.marketId,
        marketName = this.marketName,
        isLive = this.isLive,
        isBetBuilder = this.isBetBuilder,
        isBanker = this.isBanker,
        isVirtual = this.isVirtual,
        bbSelections = this.bbSelections,
        eventId = this.eventId,
        eventCode = this.eventCode,
        feedEventId = this.feedEventId,
        eventName = this.eventName,
        sportTypeId = this.sportTypeId,
        categoryId = this.categoryId,
        categoryName = this.categoryName,
        champId = this.champId,
        champName = this.champName,
        eventScore = this.eventScore,
        gameTime = this.gameTime,
        eventDate = this.eventDate,
        pitcherInfo = this.pitcherInfo,
        runners = this.runners,
        extraEventInfo = this.extraEventInfo,
        rc = this.rc,
        liveInfoAtEventMinute = this.liveInfoAtEventMinute,
        isLiveOrVirtual = this.isLiveOrVirtual,
        earlyPayout = this.earlyPayout,
        boreDraw = this.boreDraw,
        deadHeatFactor = this.deadHeatFactor,
        dbId = this.dbId
    )
}

fun UserModel.toDomain(): UserEntity {
    return UserEntity(
        id = this.id,
        email = this.email,
        role = this.role,
        firstName = this.firstName,
        lastName = this.lastName
    )
}



