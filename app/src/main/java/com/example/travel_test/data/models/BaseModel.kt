package com.example.travel_test.data.models

import android.content.Context
import com.example.travel_test.Persistence.db.TourDB
import com.example.travel_test.network.responses.TravelApi
import com.example.travel_test.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Time
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mTravelApi : TravelApi
    protected lateinit var mTheDB : TourDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mTravelApi = retrofit.create(TravelApi::class.java)

    }

    fun initDatabase(context : Context) {
        mTheDB = TourDB.getDBInstance(context)
    }

}