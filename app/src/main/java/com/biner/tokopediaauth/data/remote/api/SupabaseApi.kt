package com.biner.tokopediaauth.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SupabaseApi {
    @POST("functions/v1/signup")
    suspend fun signUp(
        @Body request: SignUpRequest
    ): Response<SignUpResponse>

//    @POST("functions/v1/signin")
//    suspend fun signIn(
//        @Body request: SignInRequest
//    ): Response<SignInResponse>
}