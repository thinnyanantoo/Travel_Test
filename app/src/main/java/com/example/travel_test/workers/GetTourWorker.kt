package com.example.travel_test.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetTourWorker (context : Context, workerParams : WorkerParameters) : BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()

        mModel.getAllCountriesFomApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        mModel.getAllToursFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                Result.failure()
            }
        )
return result
    }
}