package com.apuestatotal.app.domain.entity

data class UserEntity(
    val id: Int,
    val email: String,
    val role: String,
    val firstName: String,
    val lastName: String
)