package com.example.travel_test.data.vos

import androidx.room.Entity
import com.example.travel_test.adapters.populatToursAdapter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "countryTable")
class CountryVO (
    @SerializedName("name") var name : String  = "",
    @SerializedName("description") var description : String = "",
    @SerializedName("location") var location : String = "",
    @SerializedName("average_rating") var averageRating : Float = 1F,
    @SerializedName("scores_and_reviews") var scoresAndReviews: List<ScoreAndReviewsVO> = listOf() ,
    @SerializedName("photos") var photo: List<String> = emptyList()
)