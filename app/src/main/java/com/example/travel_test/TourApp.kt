package com.example.travel_test

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.work.*
import com.example.travel_test.data.models.ToursModeImpl
import com.example.travel_test.workers.GetTourWorker
import java.util.concurrent.TimeUnit

class TourApp : Application(){

    override fun onCreate() {
        super.onCreate()
        ToursModeImpl.initDatabase(applicationContext)

        getToursOneTime()
        getMoviePeriodically()
        getToursWhileInDozeModel()
    }

    private fun getToursOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetTourWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun getMoviePeriodically(){
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getEventsPeriodicallyWorkRequest = PeriodicWorkRequest
            .Builder(GetTourWorker::class.java,30, TimeUnit.SECONDS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext).enqueue(getEventsPeriodicallyWorkRequest)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getToursWhileInDozeModel(){
        val constraints = Constraints.Builder()
            .setRequiresDeviceIdle(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getEventsWhileInDozeModeWorkRequest = PeriodicWorkRequest
            .Builder(GetTourWorker::class.java, 1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWhileInDozeModeWorkRequest)
    }
}