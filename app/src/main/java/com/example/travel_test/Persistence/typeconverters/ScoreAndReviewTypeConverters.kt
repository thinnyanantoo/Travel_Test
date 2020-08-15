package com.example.travel_test.Persistence.typeconverters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.travel_test.data.vos.ScoreAndReviewsVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoreAndReviewTypeConverters {

    @TypeConverter
    fun toList(jsonString : String) : ArrayList<ScoreAndReviewsVO> {
        return Gson().fromJson(jsonString, object : TypeToken<ArrayList<String>>() {}.type)
    }

    @TypeConverter
    fun toJsonString(list : ArrayList<ScoreAndReviewsVO>) : String {
        return Gson().toJson(list)
    }
}