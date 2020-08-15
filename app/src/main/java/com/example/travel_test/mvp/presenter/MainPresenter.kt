package com.example.travel_test.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.travel_test.delegate.TravelDelegate
import com.example.travel_test.mvp.view.MainView

interface MainPresenter : BasePresenter<MainView>,TravelDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)


}