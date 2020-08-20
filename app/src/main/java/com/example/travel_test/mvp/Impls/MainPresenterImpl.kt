package com.example.travel_test.mvp.Impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.travel_test.data.models.ToursModeImpl
import com.example.travel_test.data.models.ToursModel
import com.example.travel_test.mvp.presenter.AbstractBasePresenter
import com.example.travel_test.mvp.presenter.BasePresenter
import com.example.travel_test.mvp.presenter.MainPresenter
import com.example.travel_test.mvp.view.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {
    var mModel: ToursModel = ToursModeImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestAllCountries(lifecycleOwner)
        requestAllTours(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestAllCountries(lifecycleOwner)
        requestAllTours(lifecycleOwner)
    }

    override fun onTapItem(name: String, key: Int) {
        mView?.navigateToDetail(name, key)
    }

    private fun requestAllCountries(lifecycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mModel.getAllCountries(onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        }).observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
            if (it.isEmpty()) {
                mView?.displayEmptyView()
            } else
                mView?.displayCountryList(it)
        })

    }

    private fun requestAllTours(lifecycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mModel.getAllTours(
            onError = {
                mView?.disableSwipeRefresh()
                mView?.displayEmptyView()
            }).observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
            if (it.isEmpty())
                mView?.disableSwipeRefresh()
            else
                mView?.displayTourList(it)
        })
    }
}