package com.example.travel_test.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel_test.adapters.populatToursAdapter
import com.example.travel_test.data.vos.TourVO
import kotlinx.android.synthetic.main.tour_recycler_view_pod.view.*

class TourRecyclerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(
    context, attrs, defStyleAttr
) {
    fun onbindTourAdapter(toursAdapter: populatToursAdapter, toursList: MutableList<TourVO>) {
        val linearLayoutManagerTour =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvPopularTours.layoutManager = linearLayoutManagerTour
        rvPopularTours.adapter = toursAdapter
        toursAdapter.setNewData(toursList)
    }
}