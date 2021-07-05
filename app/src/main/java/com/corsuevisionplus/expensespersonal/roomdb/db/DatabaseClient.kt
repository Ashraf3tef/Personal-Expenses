package com.corsuevisionplus.expensespersonal.roomdb.db

import android.content.Context
import androidx.room.Room


class DatabaseClient(mContext: Context) {
    private val mContext :Context = mContext
    var appDataBase:AppDataBase =Room.databaseBuilder(mContext,AppDataBase::class.java,"EXPENSES_APP")
            .allowMainThreadQueries().build()

    companion object{
        private var mInstatance: DatabaseClient?=null
        @Synchronized
        fun getInstance(context: Context?): DatabaseClient {
            if (mInstatance == null){
                mInstatance = DatabaseClient(context!!)
        }
            return mInstatance!!
    }
}}