package com.example.travel_test.data.models

import androidx.lifecycle.LiveData
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import io.reactivex.Observable

interface ToursModel {
    fun getAllTours(onError: (String) -> Unit) : LiveData<List<TourVO>>

    fun getAllToursFromApiAndSaveToDatabase(onSuccess : () -> Unit, onError: (String) -> Unit)

    fun getAllCountriesByName (name : String) : LiveData<CountryVO>

    fun getAllCountries (onError: (String) -> Unit) :LiveData<List<CountryVO>>

    fun getAllCountriesFomApiAndSaveToDatabase(onSuccess: () -> Unit,onError: (String) -> Unit)

    fun getAllToursByName(name : String) : LiveData<TourVO>

//    fun getCountryDetail( countryName : String, onSuccess: (countries : CountryVO) -> Unit , onError: (String) -> Unit)
//
//    fun getTourDetail( TourName : String, onSuccess: (tours : TourVO) -> Unit , onError: (String) -> Unit)
}