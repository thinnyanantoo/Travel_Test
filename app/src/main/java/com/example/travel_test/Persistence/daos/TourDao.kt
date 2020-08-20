package com.example.travel_test.Persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import retrofit2.http.DELETE

@Dao
interface TourDao {

    @Query("SELECT * FROM tourTable")
    fun getAllTours(): LiveData<List<TourVO>>

    @Query("SELECT * FROM tourTable WHERE name = :tourName")
    fun getTourByName(tourName: String): LiveData<TourVO>

    @Query("DELETE FROM tourTable")
    fun deleteAll()
    @Delete
    fun deleteTours(tours: TourVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTour(tourVO: TourVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTours(tours: List<TourVO>)

}