package com.apuestatotal.app.data.model.request

data class SignInRequest(
    val email: String,
    val password: String,
    val fcmToken: String
)

