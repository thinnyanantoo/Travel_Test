package com.example.travel_test.mvp.view

import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO

interface DetailView : BaseView{
    fun showCountryDetail(countryVO : CountryVO, name: String)
    fun showToursDetail(tourVO: TourVO, name : String)
}