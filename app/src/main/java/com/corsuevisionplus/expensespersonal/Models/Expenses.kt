package com.corsuevisionplus.expensespersonal.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Expenses {
    @PrimaryKey(autoGenerate = true)
    var txId = 0
    @ColumnInfo(name = "Place")
    var placeShop: String? = null
    @ColumnInfo(name = "Date")
    var dateShop: String? = null
    @ColumnInfo(name = "Salary")
    var salaryShop = 0.0
    @ColumnInfo(name = "uid")
    var uid = 0
}
