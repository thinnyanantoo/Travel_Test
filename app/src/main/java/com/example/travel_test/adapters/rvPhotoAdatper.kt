package com.example.travel_test.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travel_test.R
import com.example.travel_test.views.viewholders.rvPhotoViewHolder

class rvPhotoAdatper : BaseRecyclerAdapter<rvPhotoViewHolder, String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvPhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return rvPhotoViewHolder(view)
    }
}