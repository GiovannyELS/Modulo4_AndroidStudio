package com.example.alkewalletapp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentLoginsignupBinding

class Loginsignup : Fragment() {

    lateinit var binding: FragmentLoginsignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginsignupBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)
        val botoncrearcuenta = binding.botoncrearcuenta
        val yatienescuenta = binding.tienescuentatext

        botoncrearcuenta.setOnClickListener { navController.navigate(R.id.action_loginsignup_to_signupPage) }
        yatienescuenta.setOnClickListener { navController.navigate(R.id.action_loginsignup_to_loginPage) }
    }
}
