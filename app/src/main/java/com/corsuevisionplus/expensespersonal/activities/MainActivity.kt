package com.corsuevisionplus.expensespersonal.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.corsuevisionplus.expensespersonal.common.Common
import com.corsuevisionplus.expensespersonal.databinding.ActivityMainBinding
import com.corsuevisionplus.expensespersonal.roomdb.db.DatabaseClient

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("SETTING_PREF", MODE_PRIVATE)
        readData()
        binding.logIn.setOnClickListener {
            login()
        }
        binding.register.setOnClickListener {
            val mainIntent = Intent(this, RegisterActivity::class.java)
            startActivity(mainIntent)
        }
    }
    private fun readData(){
        binding.userName.setText(sharedPreferences.getString("USER_NAME",null))
        binding.password.setText(sharedPreferences.getString("PASSWORD",null))
    }
    private fun login(){
        val user = DatabaseClient.getInstance(this)
                .appDataBase
                .dao().login(binding.userName.text.toString(),binding.password.text.toString())
        if (user!= null) {

                Common.user=user
            val mainIntent = Intent(this, ExpensesActivity::class.java)
            startActivity(mainIntent)
            val edit = sharedPreferences.edit()
            edit.putString("USER_NAME", binding.userName.text.toString())
            edit.putString("PASSWORD", binding.password.text.toString())
            edit.apply()
        }else{
            Toast.makeText(this,"UserName or Password incorrect!!",Toast.LENGTH_LONG).show()
        }
    }
}