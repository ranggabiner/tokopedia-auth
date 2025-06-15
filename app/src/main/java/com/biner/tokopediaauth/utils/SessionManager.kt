package com.biner.tokopediaauth.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("TokopediaAuthPrefs", Context.MODE_PRIVATE)

    fun setLoggedIn(isLoggedIn: Boolean, email: String = "", token: String = "") {
        sharedPreferences.edit().apply {
            putBoolean("IS_LOGGED_IN", isLoggedIn)
            putString("USER_EMAIL", email)
            putString("USER_TOKEN", token)
            apply()
        }
    }

    fun isLoggedIn(): Boolean = sharedPreferences.getBoolean("IS_LOGGED_IN", false)

    fun getUserToken(): String = sharedPreferences.getString("USER_TOKEN", "") ?: ""

    fun logout() {
        sharedPreferences.edit().clear().apply()
    }
}