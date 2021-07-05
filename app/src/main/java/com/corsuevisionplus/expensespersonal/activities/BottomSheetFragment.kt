package com.corsuevisionplus.expensespersonal.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.corsuevisionplus.expensespersonal.Models.Expenses
import com.corsuevisionplus.expensespersonal.R
import com.corsuevisionplus.expensespersonal.common.Common
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.math.log

class BottomSheetFragment(expensesCallBack: ExpensesCallBack) :
    BottomSheetDialogFragment() {
    interface ExpensesCallBack {
        fun onExpensesAdded(e: Expenses?)
    }

    private val expensesCallBack: ExpensesCallBack = expensesCallBack
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        val place = v.findViewById<EditText>(R.id.enterPlace)
        val date = v.findViewById<EditText>(R.id.dateEt)
        val amountEt = v.findViewById<EditText>(R.id.salaryEt)
        val saveExpenses = v.findViewById<Button>(R.id.saveBtn)
        saveExpenses.setOnClickListener {
            val placeSt = place.text.toString()
            val date1 = date.text.toString()
            val amount = amountEt.text.toString()

            val e = Expenses()
            e.dateShop = date1
            e.salaryShop = amount.toDouble()
            e.placeShop = placeSt
            e.uid = Common.user!!.uid

            expensesCallBack.onExpensesAdded(e)

            dismiss()
        }
        return v
    }

}