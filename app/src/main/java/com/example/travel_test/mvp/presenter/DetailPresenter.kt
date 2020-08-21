package com.example.travel_test.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.travel_test.mvp.view.DetailView

interface DetailPresenter : BasePresenter<DetailView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner, name: String, key: Int)
}