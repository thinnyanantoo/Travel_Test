package com.example.travel_test.data.vos

import com.google.gson.annotations.SerializedName


class ScoreAndReviewsVO (
    @SerializedName("name") var name : String ,
    @SerializedName("score") var score : Double,
    @SerializedName("max_score") var maxScore : Int,
    @SerializedName("total_reviews") var totalReviews : Int
)