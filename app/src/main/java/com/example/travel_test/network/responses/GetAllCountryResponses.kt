package com.example.travel_test.network.responses

import com.example.travel_test.data.vos.CountryVO
import com.google.gson.annotations.SerializedName

data class GetAllCountryResponses (
    @SerializedName("code")
    var code: Int,
    @SerializedName("message")
    var message: String,
    @SerializedName("data")
    var Countrydata: List<CountryVO> ?= null
)