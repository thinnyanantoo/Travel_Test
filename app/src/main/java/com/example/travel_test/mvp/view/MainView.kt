package com.example.travel_test.mvp.view

import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO

interface MainView : BaseView {

    fun navigateToDetail(name : String)
    fun displayCountryList(countryList : List<CountryVO>)
    fun displayTourList(tourList : List<TourVO>)

}