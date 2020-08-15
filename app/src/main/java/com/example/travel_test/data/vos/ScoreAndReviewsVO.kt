package com.example.travel_test.data.vos

import com.google.gson.annotations.SerializedName


class ScoreAndReviewsVO (
    @SerializedName("name") var name : String = "",
    @SerializedName("score") var score : Double = 0.00,
    @SerializedName("max_score") var maxScore : Int = 0,
    @SerializedName("total_reviews") var totalReviews : Int
)