package com.example.travel_test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travel_test.R
import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.delegate.TravelDelegate
import com.example.travel_test.views.viewholders.populatToursViewHolder

class populatToursAdapter(delegate: TravelDelegate): BaseRecyclerAdapter<populatToursViewHolder,TourVO>(){
    val delegate:TravelDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): populatToursViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_tours,parent,false)
        return populatToursViewHolder(view,delegate)
    }

}