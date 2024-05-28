package com.example.alkewalletapp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentSendMoneyBinding

class SendMoney : Fragment() {

    lateinit var binding: FragmentSendMoneyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSendMoneyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)

        val botonback = binding.include2.botonBack
        val botonhome = binding.botonverdeenviar


        botonback.setOnClickListener { navController.navigate(R.id.action_sendMoney_to_homePage) }

        botonhome.setOnClickListener { navController.navigate(R.id.action_sendMoney_to_loginsignup) }
    }
}


