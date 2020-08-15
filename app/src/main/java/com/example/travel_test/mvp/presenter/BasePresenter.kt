package com.example.travel_test.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.travel_test.mvp.view.BaseView

interface BasePresenter<T: BaseView>{
    fun initPresenter(view : T)
}