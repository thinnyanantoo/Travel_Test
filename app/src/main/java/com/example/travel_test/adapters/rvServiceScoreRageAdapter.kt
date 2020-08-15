package com.example.travel_test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travel_test.R
import com.example.travel_test.data.vos.ScoreAndReviewsVO
import com.example.travel_test.views.viewholders.rvServiceScoreRageViewHolder

class rvServiceScoreRageAdapter : BaseRecyclerAdapter<rvServiceScoreRageViewHolder,ScoreAndReviewsVO>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): rvServiceScoreRageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_in_detail_activity,parent,false)
        return rvServiceScoreRageViewHolder(view)
    }


}