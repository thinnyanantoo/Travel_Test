package com.example.travel_test.views.viewholders


import android.view.View
import com.bumptech.glide.Glide
import com.example.travel_test.data.vos.CountryVO

import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.delegate.TravelDelegate
import kotlinx.android.synthetic.main.item_country.view.*

class countryItemViewHolder(itemView: View, delegate: TravelDelegate) :
    BaseViewHolder<CountryVO>(itemView) {

    override fun bindData(data: CountryVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.photo?.get(0))
            .into(itemView.ivCountry)

        itemView.countryTitle.text = data.name
        itemView.countryPlace.text = data.location
        itemView.countryRate.text = data.averageRating.toString()

    }

    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapItem(it.name, 1)
            }

        }
    }
}





