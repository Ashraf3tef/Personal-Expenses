package com.corsuevisionplus.expensespersonal.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity

class User{
    @PrimaryKey(autoGenerate = true)
    var uid= 0
    @ColumnInfo(name = "User_Name")
    var userName:String?=null
    @ColumnInfo(name = "Mobile")
    var mobile:String?=null
    @ColumnInfo(name = "Password")
    var password:String?=null
}