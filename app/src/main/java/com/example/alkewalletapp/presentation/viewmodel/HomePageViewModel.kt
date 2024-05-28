package com.example.alkewalletapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletapp.R
import com.example.alkewalletapp.data.local.Transaction

class HomePageViewModel : ViewModel() {

    private val _transaction = MutableLiveData<MutableList<Transaction>>()
    val transaction: LiveData<MutableList<Transaction>> get() = _transaction


    init {
        loadTransaction()
    }


    private fun loadTransaction() {
        val exampleTransaction = mutableListOf(
            Transaction(
                R.drawable.profilepicture1, R.drawable.send_iconamarillo, "Juan",
                "Oct 14,10:24", "-$", 100.0
            ),
            Transaction(
                R.drawable.profilepicture2, R.drawable.request_iconazul, "Giovanny",
                "Oct 16,01:10", "+$", 120.0
            ),
            Transaction(
                R.drawable.profilepicture3, R.drawable.send_iconamarillo, "Maria",
                "Oct 14,10:24", "-$", 200.0
            ),
            Transaction(
                R.drawable.profilepicture4, R.drawable.send_iconamarillo, "Petra",
                "Oct 20,11:25", "-$", 130.0
            ),
            Transaction(
                R.drawable.profilepicture5, R.drawable.request_iconazul, "Marta",
                "Oct 01,05:00", "+$", 300.0
            ),
            Transaction(
                R.drawable.profilepicture6, R.drawable.request_iconazul, "Petronila",
                "Oct 12,10:24", "+$", 600.0
            ),
            Transaction(
                R.drawable.profilepicture1, R.drawable.send_iconamarillo, "Juan",
                "Oct 14,10:24", "-$", 100.0
            )

        )
        _transaction.value = exampleTransaction
    }
}


