package com.example.travel_test.mvp.Impls

import androidx.lifecycle.LifecycleOwner
import com.example.travel_test.data.models.ToursModeImpl
import com.example.travel_test.data.models.ToursModel
import com.example.travel_test.mvp.presenter.AbstractBasePresenter
import com.example.travel_test.mvp.presenter.DetailPresenter
import com.example.travel_test.mvp.view.DetailView
import java.util.*

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {
    var mModel: ToursModel = ToursModeImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner, name: String, key: Int) {
        if (key == 1) {
            mModel.getAllCountriesByName(name).observe(lifecycleOwner, androidx.lifecycle.Observer {
                mView?.showCountryDetail(it, name)
            })
        }
        if (key == 2) {
            mModel.getAllToursByName(name).observe(lifecycleOwner, androidx.lifecycle.Observer {
                mView?.showToursDetail(it, name)
            })
        }
    }
}


