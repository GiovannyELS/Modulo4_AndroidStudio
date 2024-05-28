package com.example.alkewalletapp.presentation.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel

class LoginPageViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    private val storedEmail = sharedPreferences.getString("email", null)
    private val storedPassword = sharedPreferences.getString("password", null)

    fun validateCredentials(username: String, password: String): Boolean {
        Log.i("LoginPageViewModel", "Username: $username")
        return username == storedEmail && password == storedPassword
    }
}

