package com.example.travel_test.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel_test.adapters.countryItemAdapter
import com.example.travel_test.data.vos.CountryVO
import kotlinx.android.synthetic.main.country_recycler_view_pod.view.*

class CountryRecyclerAdapterViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    fun onbindCountryAdatper(
        countryAdapter: countryItemAdapter,
        countryList: MutableList<CountryVO>
    ) {
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvCountry.layoutManager = linearLayoutManager
        rvCountry.adapter = countryAdapter
        countryAdapter.setNewData(countryList)
    }
}