package com.example.travel_test.data.models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.utils.DUMMY_ACCESS_TOKEN
import com.example.travel_test.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ToursModeImpl : ToursModel,BaseModel() {

    override fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        return mTheDB.CountryDao().getAllCountries()
    }

    override fun getAllCountriesByName(name: String): LiveData<CountryVO> {
        return mTheDB.CountryDao().getCountryByName(name)
    }

    @SuppressLint("CheckResult")
    override fun getAllCountriesFomApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mTravelApi
            .getAllCountries(DUMMY_ACCESS_TOKEN)
            .map {
                it.Countrydata?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.CountryDao().insertAllCountries(it)
            }, {
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }
    override fun getAllTours(onError: (String) -> Unit): LiveData<List<TourVO>> {
        return mTheDB.TourDao().getAllTours()
    }

    override fun getAllToursByName(name: String): LiveData<TourVO> {
        return mTheDB.TourDao().getTourByName(name)
    }

    @SuppressLint("CheckResult")
    override fun getAllToursFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mTravelApi
            .getAllTours(DUMMY_ACCESS_TOKEN)
            .map {
                it.TourData?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.TourDao().insertAllTours(it)
            }, {
                Log.e("Error", it.localizedMessage)
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

//    @SuppressLint("CheckResult")
//    override fun getCountryDetail(
//        countryName: String,
//        onSuccess: (countries: CountryVO) -> Unit,
//        onError: (String) -> Unit
//    ) {
//      mTravelApi.getAllCountries(countryName,DUMMY_ACCESS_TOKEN)
//          .subscribeOn(Schedulers.io())
//          .observeOn(AndroidSchedulers.mainThread())
//          .subscribe({     onSuccess(c)}
//          ,{
//                  onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
//              }
//          )
//    }
//
//    override fun getTourDetail(
//        TourName: String,
//        onSuccess: (tours: TourVO) -> Unit,
//        onError: (String) -> Unit
//    ) {
//        TODO("Not yet implemented")
//    }


}



