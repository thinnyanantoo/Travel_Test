package com.example.travel_test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travel_test.R
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.delegate.TravelDelegate
import com.example.travel_test.views.viewholders.countryItemViewHolder


class countryItemAdapter(delegate: TravelDelegate) :
    BaseRecyclerAdapter<countryItemViewHolder, CountryVO>() {

    val delegate: TravelDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): countryItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return countryItemViewHolder(view, delegate)
    }

}