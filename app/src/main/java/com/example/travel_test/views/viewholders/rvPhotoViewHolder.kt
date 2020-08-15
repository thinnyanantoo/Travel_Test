package com.example.travel_test.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
//import com.example.travel_test.data.vos.photoVO
import kotlinx.android.synthetic.main.photo_item.view.*

class rvPhotoViewHolder(itemView : View) : BaseViewHolder<String>(itemView) {
    override fun bindData(data: String) {
        Glide.with(itemView.context)
            .load(data)
            .into(itemView.ivPhotoItem)
    }

}