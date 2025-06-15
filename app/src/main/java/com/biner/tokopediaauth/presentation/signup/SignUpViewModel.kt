package com.biner.tokopediaauth.presentation.signup

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.biner.tokopediaauth.data.remote.repository.AuthRepository

class SignUpViewModel(
    private val repo: AuthRepository = AuthRepository()
) : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var message by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var isSuccess by mutableStateOf(false)
        private set

    suspend fun signUp(): Boolean {
        if (!validateInputs()) return false

        isLoading = true
        message = ""

        return try {
            val result = repo.signUp(email, password)

            if (result?.error != null) {
                message = result.error ?: "Gagal daftar: unknown error"
                isSuccess = false
                false
            } else {
                message = result?.message ?: "Berhasil daftar!"
                isSuccess = true
                true
            }
        } catch (e: Exception) {
            message = "Terjadi error: ${e.message}"
            println("Exception saat sign up: ${e.message}")
            isSuccess = false
            false
        } finally {
            isLoading = false
        }
    }

    private fun validateInputs(): Boolean {
        return when {
            email.isBlank() || password.isBlank() -> {
                message = "Email dan password wajib diisi"
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                message = "Format email gak valid"
                false
            }
            password.length < 6 -> {
                message = "Password minimal 6 karakter yaa"
                false
            }
            else -> true
        }
    }
}