package com.biner.tokopediaauth.data.api

import com.biner.tokopediaauth.BuildConfig
import com.biner.tokopediaauth.data.api.request.SignInRequest
import com.biner.tokopediaauth.data.api.request.SignUpRequest
import com.biner.tokopediaauth.data.api.request.VerifyRequest
import com.biner.tokopediaauth.data.api.response.ProfileResponse
import com.biner.tokopediaauth.data.api.response.SignInResponse
import com.biner.tokopediaauth.data.api.response.SignUpResponse
import com.biner.tokopediaauth.data.api.response.VerifyResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface SupabaseApi {
    @POST("functions/v1/signup")
    suspend fun signUp(
        @Body request: SignUpRequest,
        @Header("Authorization") token: String = BuildConfig.BEARER_TOKEN
    ): Response<SignUpResponse>
    @POST("functions/v1/signin")
    suspend fun signIn(
        @Body request: SignInRequest,
        @Header("Authorization") token: String = BuildConfig.BEARER_TOKEN
    ): Response<SignInResponse>

    @POST("functions/v1/verify")
    suspend fun verify(
        @Body request: VerifyRequest,
        @Header("Authorization") token: String = BuildConfig.BEARER_TOKEN
    ): Response<VerifyResponse>
    @GET("functions/v1/user-profile")
    suspend fun getUserProfile(
        @Header("Authorization") token: String
    ): Response<ProfileResponse>
    @POST("functions/v1/signout")
    suspend fun signOut(
        @Header("Authorization") token: String
    ): Response<Unit>
}
