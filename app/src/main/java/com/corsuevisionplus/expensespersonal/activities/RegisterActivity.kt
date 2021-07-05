package com.corsuevisionplus.expensespersonal.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.corsuevisionplus.expensespersonal.Models.User
import com.corsuevisionplus.expensespersonal.R
import com.corsuevisionplus.expensespersonal.databinding.ActivityRegisterBinding
import com.corsuevisionplus.expensespersonal.roomdb.db.DatabaseClient

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = registerBinding.root
        setContentView(view)
        registerBinding.registerBtn.setOnClickListener {
            val name = registerBinding.NameEt.text.toString()
            val mobile = registerBinding.mobileRe.text.toString()
            val password = registerBinding.passwordRe.text.toString()
            val cPassword = registerBinding.confirmRe.text.toString()
            when {
                name.isEmpty() -> {
                    registerBinding.NameEt.error=getString(R.string.required)
                }
                mobile.isEmpty() -> {
                    registerBinding.mobileRe.error=getString(R.string.required)
                }
                name.isEmpty() -> {
                    registerBinding.passwordRe.error=getString(R.string.required)
                }
                cPassword.isEmpty() -> {
                    registerBinding.confirmRe.error=getString(R.string.required)
                } else ->{
                    val user = User()
                user.userName = name
                user.mobile = mobile
                user.password = password
                DatabaseClient.getInstance(this).appDataBase.dao().insertUser(user)
                Toast.makeText(this,"User inserted Successfully!!",Toast.LENGTH_LONG).show()
                finish()
                }
            }
        }
        }
    }
