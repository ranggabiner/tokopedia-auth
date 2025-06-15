package com.biner.tokopediaauth.presentation.verify

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biner.tokopediaauth.data.remote.repository.AuthRepository
import com.biner.tokopediaauth.utils.SessionManager
import kotlinx.coroutines.launch

class VerifyViewModel : ViewModel() {
    private val repo = AuthRepository()

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var otp by mutableStateOf("")
    var message by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var isVerified by mutableStateOf(false)
        private set

    fun verifyOtp(sessionManager: SessionManager) {
        if (otp.isBlank()) {
            message = "Kode OTP tidak boleh kosong"
            return
        }

        viewModelScope.launch {
            isLoading = true
            try {
                val result = repo.verify(email, otp)
                println("DEBUG: result = $result")

                if (result?.success == true) {
                    val token = result.token ?: ""
                    println("OTP berhasil! Token: $token")

                    sessionManager.setLoggedIn(true, email, token)

                    isVerified = true
                } else {
                    message = result?.message ?: "Verifikasi gagal"
                }
            } catch (e: Exception) {
                message = "Gagal verifikasi: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}