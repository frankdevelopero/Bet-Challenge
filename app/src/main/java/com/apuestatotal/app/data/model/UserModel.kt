package com.apuestatotal.app.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("refresh") val refreshToken: String,
    @SerializedName("access") val accessToken: String,
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("role") val role: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String
)
