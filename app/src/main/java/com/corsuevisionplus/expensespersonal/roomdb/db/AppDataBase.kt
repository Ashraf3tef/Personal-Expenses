package com.corsuevisionplus.expensespersonal.roomdb.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.corsuevisionplus.expensespersonal.Models.Expenses
import com.corsuevisionplus.expensespersonal.Models.User
import com.corsuevisionplus.expensespersonal.roomdb.dao.DAO
@Database(entities = [User::class,Expenses::class],version = 2)
abstract class AppDataBase:RoomDatabase() {
    abstract fun dao():DAO

}