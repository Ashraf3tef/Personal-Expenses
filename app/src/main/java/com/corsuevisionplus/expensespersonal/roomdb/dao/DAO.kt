package com.corsuevisionplus.expensespersonal.roomdb.dao

import androidx.room.*
import com.corsuevisionplus.expensespersonal.Models.Expenses
import com.corsuevisionplus.expensespersonal.Models.User
@Dao

interface DAO {
    @Insert
    fun insertUser(user: User)
    @Update
    fun updateUser(user: User)
    @Query("select * from User where user_Name=:userName and password=:password ")
    fun login(userName:String,password:String):User?

    @Insert
    fun insertExpenses(expenses: Expenses)
    @Update
    fun updateExpenses(expenses: Expenses)
    @Delete
    fun deleteExpenses(expenses: Expenses)
    @Query("select * from Expenses where uid=:uid")
    fun getAllExpenses(uid:Int):MutableList<Expenses>

}