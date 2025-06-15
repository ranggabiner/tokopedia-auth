package com.biner.tokopediaauth.presentation.signin

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biner.tokopediaauth.data.remote.repository.AuthRepository
import com.biner.tokopediaauth.utils.SessionManager
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var message by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var isLoggedIn by mutableStateOf(false)
        private set

    fun signIn(sessionManager: SessionManager) {
        if (!validateInputs()) return

        viewModelScope.launch {
            isLoading = true
            message = ""

            val response = authRepository.signIn(email, password)

            if (response?.token != null) {
                sessionManager.setLoggedIn(true, email, response.token!!)
                isLoggedIn = true
                println("Login berhasil. Token: ${response.token}")
            } else {
                message = response?.message ?: response?.error ?: "Unknown error"
            }

            isLoading = false
        }
    }

    private fun validateInputs(): Boolean {
        return when {
            email.isBlank() || password.isBlank() -> {
                message = "Email dan password wajib diisi!"
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                message = "Format email gak valid"
                false
            }
            password.length < 6 -> {
                message = "Password minimal 6 karakter"
                false
            }
            else -> true
        }
    }
}