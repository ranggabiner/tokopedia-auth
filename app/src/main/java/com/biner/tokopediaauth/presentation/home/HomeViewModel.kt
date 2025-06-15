package com.biner.tokopediaauth.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biner.tokopediaauth.data.api.response.ProfileResponse
import com.biner.tokopediaauth.data.remote.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = AuthRepository()

    private val _profile = MutableStateFlow<ProfileResponse?>(null)
    val profile: StateFlow<ProfileResponse?> = _profile

    fun fetchProfile(token: String) {
        viewModelScope.launch {
            val result = repository.getUserProfile(token)
            _profile.value = result
        }
    }

    fun signOut(token: String, onSignedOut: () -> Unit) {
        viewModelScope.launch {
            val success = repository.signOut(token)
            if (success) {
                onSignedOut()
            } else {
                println("Gagal sign out dari server")
            }
        }
    }
}
