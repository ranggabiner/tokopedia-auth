package com.biner.tokopediaauth.data.api.request

data class VerifyRequest(
    val email: String,
    val token: String,
    val type: String = "email"
)
