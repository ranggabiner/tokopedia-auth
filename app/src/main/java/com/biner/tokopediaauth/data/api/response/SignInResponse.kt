package com.biner.tokopediaauth.data.api.response

data class SignInResponse(
    val message: String?,
    val token: String? = null,
    val error: String? = null
)