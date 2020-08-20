package com.example.travel_test.Persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.travel_test.data.vos.CountryVO

@Dao
interface CountryDao {
    @Query("SELECT * FROM countryTable")
    fun getAllCountries(): LiveData<List<CountryVO>>

    @Query("SELECT * FROM countryTable WHERE name = :countryName")
    fun getCountryByName(countryName: String): LiveData<CountryVO>

    @Query("DELETE FROM countryTable")
    fun deleteAll()

    @Delete
    fun deleteCountry(country: CountryVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(countryVO: CountryVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountries(country: List<CountryVO>)
}