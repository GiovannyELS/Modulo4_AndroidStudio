package com.example.alkewalletapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alkewalletapp.R
import com.example.alkewalletapp.data.local.Transaction

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {
    var transactions = mutableListOf<Transaction>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_item, parent, false)
        return TransactionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction: Transaction = transactions[position]

        holder.profileImage.setImageResource(transaction.profileImage)
        holder.transactionType.setImageResource(transaction.transactionType)
        holder.date.text = transaction.date
        holder.name.text = transaction.name
        holder.operator.text = transaction.operator
        holder.amount.text = transaction.amount.toString()
    }

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage = view.findViewById<ImageView>(R.id.imageView7)
        val transactionType = view.findViewById<ImageView>(R.id.imageView11)
        val name = view.findViewById<TextView>(R.id.textView15)
        val date = view.findViewById<TextView>(R.id.textView17)
        val operator = view.findViewById<TextView>(R.id.operadorView)
        val amount = view.findViewById<TextView>(R.id.textView16)
    }
}

