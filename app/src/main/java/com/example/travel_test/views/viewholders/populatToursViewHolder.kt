package com.example.travel_test.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.delegate.TravelDelegate
import kotlinx.android.synthetic.main.item_popular_tours.view.*
import kotlinx.android.synthetic.main.service_in_detail_activity.view.*

class populatToursViewHolder(itemView: View, delegate: TravelDelegate) : BaseViewHolder<TourVO>(itemView){
    override fun bindData(data: TourVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.photo?.get(0))
            .into(itemView.ivBgPopular)

        itemView.tvPopularCountry.text = data.name
        itemView.tvPopularLocation.text = data.location
        itemView.tvPopularRate.text = data.averageRating.toString()


    }
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapItem(it.name,0)
            }

        }
    }
}