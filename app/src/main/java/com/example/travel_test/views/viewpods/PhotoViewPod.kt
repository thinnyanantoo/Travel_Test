package com.example.travel_test.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel_test.adapters.rvPhotoAdatper
import kotlinx.android.synthetic.main.photo_view_pod.view.*

class PhotoViewPod @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attr, defStyleAttr) {
    fun onbindPhoto(photoAdatper: rvPhotoAdatper) {
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvPhoto.layoutManager = linearLayoutManager
        rvPhoto.adapter = photoAdatper
    }

}