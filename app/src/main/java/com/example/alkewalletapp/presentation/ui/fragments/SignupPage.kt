package com.example.alkewalletapp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentSignupPageBinding
import com.example.alkewalletapp.presentation.viewmodel.SignupPageViewModel

class SignupPage : Fragment() {

    private var _binding: FragmentSignupPageBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignupPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botoncrearcuenta2.setOnClickListener {
            registerUser()
        }

        binding.textyatienesuna.setOnClickListener {
            findNavController().navigate(R.id.action_signupPage_to_loginPage)
        }

        viewModel.toastMessage.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun registerUser() {
        val name = binding.editTextname.text.toString()
        val apellido = binding.editTextApellido.text.toString()
        val email = binding.editTextmail.text.toString()
        val password = binding.editTextContra.text.toString()
        val rePassword = binding.editTextRePassword.text.toString()

        viewModel.registerUser(name, apellido, email, password, rePassword, findNavController())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


