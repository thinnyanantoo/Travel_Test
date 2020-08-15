package com.example.travel_test.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.travel_test.data.models.ToursModeImpl
import com.example.travel_test.data.models.ToursModel

abstract class BaseWorker (context: Context, workerParams : WorkerParameters) : Worker(context,workerParams){
    val mModel : ToursModel = ToursModeImpl

}