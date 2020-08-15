package com.example.travel_test.Persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.travel_test.Persistence.daos.CountryDao
import com.example.travel_test.Persistence.daos.TourDao
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO

@Database(entities = [CountryVO::class,TourVO::class],version = 1, exportSchema = false)
abstract class TourDB : RoomDatabase() {
    companion object{
        val DB_NAME = "TourDB"
        var dbInstance : TourDB? = null

        fun getDBInstance(context: Context) : TourDB {
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(
                        context, TourDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun CountryDao() : CountryDao
    abstract fun TourDao() : TourDao
}