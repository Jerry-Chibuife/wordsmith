package com.thejerryuc.wordsmith.dtos.requests

data class AccountCreationRequest(
    val email: String,
    val userName: String,
    val password: String
)
