package com.example.travel_test.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel_test.adapters.rvServiceScoreRageAdapter
import kotlinx.android.synthetic.main.service_score_view_pod.view.*

class ScoreAndReviewAndapterViewPod @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attr, defStyleAttr) {

    fun bindScoreAdatper(scoreRageAdapter: rvServiceScoreRageAdapter) {
        val linearLayoutManagerService =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvServiceScoreRage.layoutManager = linearLayoutManagerService
        rvServiceScoreRage.adapter = scoreRageAdapter
    }
}