package com.example.alkewalletapp.presentation.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentLoginPageBinding
import com.example.alkewalletapp.presentation.viewmodel.LoginPageViewModel
import com.example.alkewalletapp.presentation.viewmodel.LoginPageViewModelFactory

class LoginPage : Fragment() {

    private var _binding: FragmentLoginPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var validator: LoginPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences =
            requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        validator = ViewModelProvider(this, LoginPageViewModelFactory(sharedPreferences)).get(
            LoginPageViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val botonlogin = binding.botonlogin
        val crearnuevacuenta = binding.textcrearnuevacuenta

        botonlogin.setOnClickListener {
            val inputUsername = binding.editTextUsername?.text.toString()
            val inputPassword = binding.editTextPassword?.text.toString()
            val isValid = validator.validateCredentials(inputUsername, inputPassword)
            Log.i("LoginPage", "Credentials valid: $isValid")

            if (isValid) {
                navController.navigate(R.id.action_loginPage_to_homePage)
            } else {
                Toast.makeText(
                    requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT
                ).show()
            }
        }

        crearnuevacuenta.setOnClickListener {
            navController.navigate(R.id.action_loginPage_to_signupPage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



