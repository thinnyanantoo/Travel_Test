package com.example.travel_test.data.vos

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity(tableName = "tourTable")
data class TourVO(
    @SerializedName("name") var name : String  = "",
    @SerializedName("description") var description : String = "",
    @SerializedName("location") var location : String = "",
    @SerializedName("average_rating") var averageRating : Float = 1F,
    @SerializedName("scores_and_reviews") var scoresAndReviews: ArrayList<ScoreAndReviewsVO> = arrayListOf() ,
    @SerializedName("photos") var photo: ArrayList<String> ? = null
)