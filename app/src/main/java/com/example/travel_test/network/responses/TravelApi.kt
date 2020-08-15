package com.example.travel_test.network.responses

import com.example.travel_test.utils.GET_COUNTRIES
import com.example.travel_test.utils.GET_TOURS
import com.example.travel_test.utils.PARAM_ACCESS_TOKEN
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TravelApi {

    @GET(GET_COUNTRIES)
    fun getAllCountries(@Query(PARAM_ACCESS_TOKEN) accessToken: String): Observable<GetAllCountryResponses>

    @GET(GET_TOURS)
    fun getAllTours(@Query(PARAM_ACCESS_TOKEN) accessToken : String) : Observable<getAllTourResponses>


}