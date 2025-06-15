package com.biner.tokopediaauth.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biner.tokopediaauth.repository.AuthRepository
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    private val repo = AuthRepository()

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var message by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun signUp() {
        if (email.isBlank() || password.isBlank()) {
            message = "Email and password cannot be empty"
            println(message)
            return
        }
        viewModelScope.launch {
            isLoading = true
            try {
                val result = repo.signUp(email, password)
                message = result?.message ?: result?.error.orEmpty()
                println("Supabase response: $result") // Add logging
            } catch (e: Exception) {
                message = "Error: ${e.message}"
                println("Exception: ${e.message}") // Log exceptions
            } finally {
                isLoading = false
            }
        }
    }}