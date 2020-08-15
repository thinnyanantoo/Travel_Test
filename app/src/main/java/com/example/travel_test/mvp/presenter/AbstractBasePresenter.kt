package com.example.travel_test.mvp.presenter

import androidx.lifecycle.ViewModel
import com.example.travel_test.mvp.view.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}