package com.example.travel_test.data.models

import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.utils.DUMMY_ACCESS_TOKEN
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object ToursModeImpl : ToursModel,BaseModel() {

    val mCountryRepository : HashMap<String,CountryVO> = hashMapOf()
    override fun getAllCountries(): Observable<List<CountryVO>> {
       return mTravelApi
           .getAllCountries(DUMMY_ACCESS_TOKEN)
           .map { it.Countrydata?.toList() ?: listOf()}
           .doOnNext {
               it.forEach { countries ->
                   mCountryRepository[countries.name] = countries

               }
           }
           .subscribeOn(Schedulers.io())
    }

    override fun getAllCountriesFomApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllCountriesByName(CountryName: String?, CountryType: Int): CountryVO {
        mCountryRepository[CountryName]?.let {
            return it
        }
        return CountryVO()
    }

    val mToursRepository: HashMap<String, TourVO> = hashMapOf()
    override fun getAllTours(): Observable<List<TourVO>> {
       return mTravelApi
            .getAllTours(DUMMY_ACCESS_TOKEN)
            .map { it.TourData?.toList() ?: listOf() }
            .doOnNext {
                it.forEach { tours ->
                    mToursRepository[tours.name] = tours
                }
            }
            .subscribeOn(Schedulers.io())
    }

    override fun getAllToursFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
    }

    override fun getAllToursByName(TourName: String?, TourType : Int): TourVO {
        mToursRepository[TourName]?.let {
            return it
        }
        return TourVO()
    }
}



