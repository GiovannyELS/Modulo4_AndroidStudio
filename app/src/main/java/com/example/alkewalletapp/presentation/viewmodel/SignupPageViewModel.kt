package com.example.alkewalletapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.alkewalletapp.R

class SignupPageViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferences: SharedPreferences =
        application.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    val toastMessage = MutableLiveData<String>()

    fun registerUser(
        name: String,
        apellido: String,
        email: String,
        password: String,
        rePassword: String,
        navController: NavController
    ) {
        if (name.isEmpty() || apellido.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            toastMessage.value = "Por favor, complete todos los campos."
            return
        }

        if (!validateName(name)) {
            toastMessage.value = "Nombre no válido"
            return
        }

        if (!validatePassword(password)) {
            toastMessage.value = "La contraseña debe tener al menos 8 caracteres"
            return
        }

        if (password != rePassword) {
            toastMessage.value = "Las contraseñas no coinciden."
            return
        }

        with(sharedPreferences.edit()) {
            putString("name", name)
            putString("apellido", apellido)
            putString("email", email)
            putString("password", password)
            apply()
        }

        toastMessage.value = "Registro exitoso."
        navController.navigate(R.id.action_signupPage_to_loginsignup)
    }


    private fun validateName(name: String): Boolean {
        return name.length >= 4 && name.matches(Regex("^[a-zA-Z\\s]+$"))
    }

    private fun validatePassword(password: String): Boolean {
        return password.length >= 8
    }


}