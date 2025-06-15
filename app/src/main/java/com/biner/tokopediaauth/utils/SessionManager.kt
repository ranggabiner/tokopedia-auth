package com.biner.tokopediaauth.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("TokopediaAuthPrefs", Context.MODE_PRIVATE)

    fun setLoggedIn(isLoggedIn: Boolean, email: String = "") {
        sharedPreferences.edit().apply {
            putBoolean("IS_LOGGED_IN", isLoggedIn)
            putString("USER_EMAIL", email)
            apply()
        }
    }

    fun isLoggedIn(): Boolean = sharedPreferences.getBoolean("IS_LOGGED_IN", false)

    fun getUserEmail(): String = sharedPreferences.getString("USER_EMAIL", "") ?: ""

    fun logout() {
        sharedPreferences.edit().clear().apply()
    }
}