package com.biner.tokopediaauth.repository

import com.biner.tokopediaauth.data.remote.api.RetrofitInstance
import com.biner.tokopediaauth.data.remote.api.SignUpResponse
import com.biner.tokopediaauth.data.remote.api.SignUpRequest

class AuthRepository {
    suspend fun signUp(email: String, password: String): SignUpResponse? {
        return try {
            val request = SignUpRequest(email, password)
            println("Request: $request")

            val response = RetrofitInstance.api.signUp(request)
            println("Response code: ${response.code()}")
            println("Response body: ${response.errorBody()?.string()}")

            response.body()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            SignUpResponse(message = null, error = e.message)
        }
    }
}