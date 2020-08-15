package com.example.travel_test.network.responses

import com.example.travel_test.data.vos.TourVO
import com.google.gson.annotations.SerializedName

data class getAllTourResponses(
@SerializedName("code")
var code: Int = 0,
@SerializedName("message")
var message: String= "",
@SerializedName("data")
var TourData: List<TourVO>? = null
)