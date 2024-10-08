package com.apuestatotal.app.data.model

import com.google.gson.annotations.SerializedName

data class BetDetailResponse(
    @SerializedName("BetNivel") val betNivel: String,
    @SerializedName("BetStarts") val betStarts: Int,
    @SerializedName("BetStatusName") val betStatusName: String,
    @SerializedName("BetTypeName") val betTypeName: String,
    @SerializedName("BgSrc") val bgSrc: String,
    @SerializedName("CashoutOdds") val cashoutOdds: String,
    @SerializedName("TotalOdds") val totalOdds: String,
    @SerializedName("TotalStake") val totalStake: String,
    @SerializedName("TotalWin") val totalWin: String,
    @SerializedName("CashoutValue") val cashoutValue: String,
    @SerializedName("CreatedDate") val createdDate: String,
    @SerializedName("BetSelections") val betSelections: List<BetHistoryDetailModel>
)


data class BetHistoryDetailModel(
    @SerializedName("SelectionId") val selectionId: Long,
    @SerializedName("SelectionStatus") val selectionStatus: Int,
    @SerializedName("Price") val price: String,
    @SerializedName("Name") val name: String,
    @SerializedName("Spec") val spec: String,
    @SerializedName("MarketTypeId") val marketTypeId: Int,
    @SerializedName("MarketId") val marketId: Long,
    @SerializedName("MarketName") val marketName: String,
    @SerializedName("IsLive") val isLive: Boolean,
    @SerializedName("IsBetBuilder") val isBetBuilder: Boolean,
    @SerializedName("IsBanker") val isBanker: Boolean,
    @SerializedName("IsVirtual") val isVirtual: Boolean,
    @SerializedName("BBSelections") val bbSelections: Any?,
    @SerializedName("EventId") val eventId: Long,
    @SerializedName("EventCode") val eventCode: String?,
    @SerializedName("FeedEventId") val feedEventId: Long,
    @SerializedName("EventName") val eventName: String,
    @SerializedName("SportTypeId") val sportTypeId: Int,
    @SerializedName("CategoryId") val categoryId: Int,
    @SerializedName("CategoryName") val categoryName: String?,
    @SerializedName("ChampId") val champId: Int,
    @SerializedName("ChampName") val champName: String?,
    @SerializedName("EventScore") val eventScore: String?,
    @SerializedName("GameTime") val gameTime: String?,
    @SerializedName("EventDate") val eventDate: String,
    @SerializedName("PitcherInfo") val pitcherInfo: String?,
    @SerializedName("Runners") val runners: String?,
    @SerializedName("ExtraEventInfo") val extraEventInfo: String?,
    @SerializedName("RC") val rc: Boolean,
    @SerializedName("LiveInfoAtEventMinute") val liveInfoAtEventMinute: String?,
    @SerializedName("IsLiveOrVirtual") val isLiveOrVirtual: Boolean,
    @SerializedName("EarlyPayout") val earlyPayout: Boolean,
    @SerializedName("BoreDraw") val boreDraw: Boolean,
    @SerializedName("DeadHeatFactor") val deadHeatFactor: String?,
    @SerializedName("DbId") val dbId: Int
)
