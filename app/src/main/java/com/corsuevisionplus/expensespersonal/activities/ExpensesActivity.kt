package com.corsuevisionplus.expensespersonal.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.corsuevisionplus.expensespersonal.Adapters.ExpensesAdapter
import com.corsuevisionplus.expensespersonal.Models.Expenses
import com.corsuevisionplus.expensespersonal.common.Common
import com.corsuevisionplus.expensespersonal.databinding.ActivityExpensesBinding
import com.corsuevisionplus.expensespersonal.roomdb.db.DatabaseClient
import java.util.ArrayList

class ExpensesActivity : AppCompatActivity() {
    private lateinit var expensesBinding: ActivityExpensesBinding
    private lateinit var adapter:ExpensesAdapter
    private var list : MutableList<Expenses>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        expensesBinding = ActivityExpensesBinding.inflate(layoutInflater)
        val view = expensesBinding.root
        setContentView(view)
        Log.d("USER_ID",""+ Common.user!!.uid)
        list = DatabaseClient.getInstance(this).appDataBase.dao().getAllExpenses(Common.user!!.uid)
        val lm = LinearLayoutManager(this)
        expensesBinding.recyclerExpenses.layoutManager = lm

         adapter=ExpensesAdapter(this,list!!)

        checkEmpty()
        expensesBinding.recyclerExpenses.adapter=adapter
        expensesBinding.floatingAddBtn.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment(object :
                BottomSheetFragment.ExpensesCallBack {
                override fun onExpensesAdded(e: Expenses?) {
                    addExpensesDateBase(e!!)
                }

            })
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
    }

private fun checkEmpty(){
    if (list!!.isEmpty()){
        expensesBinding.linearEmpty.visibility = View.VISIBLE
        expensesBinding.recyclerExpenses.visibility = View.GONE
    }else{
        expensesBinding.linearEmpty.visibility = View.GONE
        expensesBinding.recyclerExpenses.visibility = View.VISIBLE
    }
}
        private fun addExpensesDateBase(expenses: Expenses){
            DatabaseClient.getInstance(this).appDataBase.dao()

            list!!.add(expenses)
            adapter.notifyDataSetChanged()
            checkEmpty()
        }
}