package com.example.alkewalletapp.presentation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentHomePageBinding
import com.example.alkewalletapp.presentation.adapter.TransactionAdapter
import com.example.alkewalletapp.presentation.viewmodel.HomePageViewModel

class HomePage : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private val viewModel: HomePageViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)

        binding.botonVerde1.setOnClickListener {
            navController.navigate(R.id.action_homePage_to_sendMoney)
        }

        binding.botonIngresar1.setOnClickListener {
            navController.navigate(R.id.action_homePage_to_requestMoney)
        }

        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        val adapter = TransactionAdapter()
        binding.recyclerUser.adapter = adapter


        viewModel.transaction.observe(viewLifecycleOwner) { transaction ->
            (binding.recyclerUser.adapter as TransactionAdapter).transactions = transaction
        }

        val sharedPrefs = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val userName = sharedPrefs.getString("name", "Usuario")
        val userBalance = sharedPrefs.getString("balance", "25000.00")

        binding.textView8.text = "Hola, $userName!"
        binding.transactionAmount.text = "$ $userBalance"
    }
}
