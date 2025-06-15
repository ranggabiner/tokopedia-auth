package com.biner.tokopediaauth.data.api.response

data class VerifyResponse(
    val success: Boolean,
    val token: String? = null,
    val message: String?
)