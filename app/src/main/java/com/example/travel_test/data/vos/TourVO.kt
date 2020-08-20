package com.example.travel_test.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.travel_test.typeconverters.PhotoTypeConverters
import com.example.travel_test.typeconverters.ScoreAndReviewTypeConverters
import com.google.gson.annotations.SerializedName


@Entity(tableName = "tourTable")
@TypeConverters(ScoreAndReviewTypeConverters::class,PhotoTypeConverters::class)
data class TourVO(
    @PrimaryKey
    @SerializedName("name") var name : String  = "",
    @SerializedName("description") var description : String = "",
    @SerializedName("location") var location : String = "",
    @SerializedName("average_rating") var averageRating : Double,

    @SerializedName("scores_and_reviews") var scoresAndReviews: ArrayList<ScoreAndReviewsVO> = arrayListOf() ,
    @SerializedName("photos") var photo: ArrayList<String> ? = null
)