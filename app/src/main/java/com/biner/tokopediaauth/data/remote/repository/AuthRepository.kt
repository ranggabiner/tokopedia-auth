package com.biner.tokopediaauth.data.remote.repository

import com.biner.tokopediaauth.data.api.RetrofitInstance
import com.biner.tokopediaauth.data.api.request.SignInRequest
import com.biner.tokopediaauth.data.api.request.SignUpRequest
import com.biner.tokopediaauth.data.api.request.VerifyRequest
import com.biner.tokopediaauth.data.api.response.ProfileResponse
import com.biner.tokopediaauth.data.api.response.SignInResponse
import com.biner.tokopediaauth.data.api.response.SignUpResponse
import com.biner.tokopediaauth.data.api.response.VerifyResponse

class AuthRepository {

    suspend fun signUp(email: String, password: String): SignUpResponse? {
        return try {
            val request = SignUpRequest(email, password)
            val response = RetrofitInstance.api.signUp(request)
            response.body()
        } catch (e: Exception) {
            SignUpResponse(message = null, error = e.message)
        }
    }

    suspend fun signIn(email: String, password: String): SignInResponse? {
        return try {
            val request = SignInRequest(email, password)
            val response = RetrofitInstance.api.signIn(request)
            response.body()
        } catch (e: Exception) {
            SignInResponse(message = null, error = e.message)
        }
    }

    suspend fun verify(email: String, token: String): VerifyResponse? {
        return try {
            val request = VerifyRequest(email = email, token = token)
            val response = RetrofitInstance.api.verify(request)
            response.body()
        } catch (e: Exception) {
            VerifyResponse(success = false, message = e.message)
        }
    }

    suspend fun getUserProfile(token: String): ProfileResponse? {
        return try {
            val response = RetrofitInstance.api.getUserProfile("Bearer $token")
            response.body()
        } catch (e: Exception) {
            null
        }
    }

    suspend fun signOut(token: String): Boolean {
        return try {
            val response = RetrofitInstance.api.signOut("Bearer $token")
            response.isSuccessful
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}