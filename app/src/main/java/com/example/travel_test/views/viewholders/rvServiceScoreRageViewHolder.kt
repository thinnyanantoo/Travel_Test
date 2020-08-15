package com.example.travel_test.views.viewholders

import android.view.View
import com.example.travel_test.R
import com.example.travel_test.data.vos.ScoreAndReviewsVO
import kotlinx.android.synthetic.main.service_in_detail_activity.view.*

class rvServiceScoreRageViewHolder(itemView: View) : BaseViewHolder<ScoreAndReviewsVO>(itemView) {
    override fun bindData(data: ScoreAndReviewsVO) {
        itemView.tvMaxScore.text = itemView.context.getString(R.string.txt_max_score,data.score,data.maxScore)
        itemView.tvReviewRate.text = itemView.context.getString(R.string.txt_total_review,data.totalReviews)
    }

}
