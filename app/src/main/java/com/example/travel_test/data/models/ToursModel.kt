package com.example.travel_test.data.models

import androidx.lifecycle.LiveData
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import io.reactivex.Observable

interface ToursModel {
    fun getAllTours() : Observable<List<TourVO>>

    fun getAllToursFromApiAndSaveToDatabase(onSuccess : () -> Unit, onError: (String) -> Unit)

    fun getAllToursByName ( TourName : String?, TourType : Int) : TourVO

    fun getAllCountries () : Observable<List<CountryVO>>

    fun getAllCountriesFomApiAndSaveToDatabase(onSuccess: () -> Unit,onError: (String) -> Unit)

    fun getAllCountriesByName( CountryName : String?, CountryType : Int) : CountryVO
}