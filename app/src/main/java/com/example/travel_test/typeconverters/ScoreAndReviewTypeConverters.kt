package com.example.travel_test.typeconverters

import androidx.room.TypeConverter
import com.example.travel_test.data.vos.ScoreAndReviewsVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoreAndReviewTypeConverters {

    @TypeConverter
    fun toScoreAndReview(scoreAndReviewJsonstr : String) : ArrayList<ScoreAndReviewsVO> {
        return Gson().fromJson(scoreAndReviewJsonstr, object : TypeToken<ArrayList<ScoreAndReviewsVO>>() {}.type)
    }

    @TypeConverter
    fun toJsonString(scoreList : ArrayList<ScoreAndReviewsVO>) : String{
        return Gson().toJson(scoreList)
    }
}