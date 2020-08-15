package com.example.travel_test.Persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

    @DELETE
    fun deleteTours(tourVO: TourVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTour(tourVO: TourVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTours(tours: List<TourVO>)

}