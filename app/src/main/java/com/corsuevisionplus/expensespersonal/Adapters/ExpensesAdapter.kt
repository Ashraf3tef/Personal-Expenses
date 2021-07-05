package com.corsuevisionplus.expensespersonal.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.corsuevisionplus.expensespersonal.Models.Expenses
import com.corsuevisionplus.expensespersonal.R
import java.lang.String
import java.util.ArrayList

class ExpensesAdapter(private val context: Context, arrayList: MutableList<Expenses>) :
    RecyclerView.Adapter<ExpensesAdapter.ExpensesViewHolder>() {
    private val arrayList: MutableList<Expenses>
    private var isOpen = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.rv_expenses_cell, parent, false)
        return ExpensesViewHolder(v)
    }

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        holder.place.text = arrayList[position].placeShop
        holder.date.text = arrayList[position].dateShop
        holder.money.text = String.valueOf(arrayList[position].salaryShop)
        holder.remove.setOnClickListener { view: View? ->
            val alertDialog =
                AlertDialog.Builder(
                    context
                ).create()
            alertDialog.setTitle(context.getString(R.string.confirm_text))
            alertDialog.setMessage(context.getString(R.string.dialog_msg))
            alertDialog.setButton(
                AlertDialog.BUTTON_POSITIVE,
                "Yes"
            ) { dialogInterface, i ->
                arrayList.removeAt(position)
                notifyDataSetChanged()
            }
            alertDialog.setButton(
                AlertDialog.BUTTON_NEGATIVE,
                "No"
            ) { dialogInterface, i -> alertDialog.dismiss() }
            alertDialog.show()
        }
        holder.check.setOnClickListener { view: View? ->
            isOpen = if (isOpen) {
                holder.check.setImageResource(R.drawable.ic_baseline_check_box_24)
                false
            } else {
                holder.check.setImageResource(R.drawable.ic_baseline_check_box_24)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ExpensesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var place: TextView
        var money: TextView
        var date: TextView
        var remove: ImageView
        var check: ImageView

        init {
            place = itemView.findViewById(R.id.placeShop)
            money = itemView.findViewById(R.id.salaryShop)
            date = itemView.findViewById(R.id.dateShop)
            remove = itemView.findViewById(R.id.removeBtn)
            check = itemView.findViewById(R.id.checkBtn)
        }
    }

    init {
        this.arrayList = arrayList
    }
}
