package com.example.travel_test.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.travel_test.R
import com.example.travel_test.adapters.rvPhotoAdatper
import com.example.travel_test.adapters.rvServiceScoreRageAdapter
import com.example.travel_test.data.models.ToursModeImpl
import com.example.travel_test.data.models.ToursModel
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.mvp.Impls.DetailPresenterImpl
import com.example.travel_test.mvp.presenter.DetailPresenter
import com.example.travel_test.mvp.view.DetailView
import com.example.travel_test.views.viewpods.PhotoViewPod
import com.example.travel_test.views.viewpods.ScoreAndReviewAndapterViewPod
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.swipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.photo_item.*

class DetailActivity : AppCompatActivity(), DetailView {

    private lateinit var mTourModel: ToursModeImpl
    private lateinit var photoAdatper: rvPhotoAdatper
    private lateinit var serviceScoreRageAdapter: rvServiceScoreRageAdapter
    private lateinit var mPresenter: DetailPresenter

    private lateinit var mPhotoViewPod: PhotoViewPod
    private lateinit var mScoreViewPod: ScoreAndReviewAndapterViewPod

    companion object {
        const val IE_NAME = "IE_Name"
        const val IE_KEY = "Key"
        fun newIntent(context: Context, name: String, key: Int): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(IE_NAME, name)
            intent.putExtra(IE_KEY, key)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mPhotoViewPod = vpPhoto as PhotoViewPod
        mScoreViewPod = vpScoreAndReview as ScoreAndReviewAndapterViewPod

        setUpPresenter()

        val name = intent.getStringExtra(IE_NAME)
        val key = intent.getIntExtra(IE_KEY, 0)
        setUpRecycler()

        mPresenter.onUiReady(this, name, key)
        ivBack.setOnClickListener { finish() }
    }

    private fun setUpRecycler() {
        photoAdatper = rvPhotoAdatper()
        mPhotoViewPod.onbindPhoto(photoAdatper)
        serviceScoreRageAdapter = rvServiceScoreRageAdapter()
        mScoreViewPod.bindScoreAdatper(serviceScoreRageAdapter)
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun displayEmptyView() {
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun showCountryDetail(countryVO: CountryVO, name: String) {
        tvDetail.text = countryVO.description
        resourceName.text = countryVO.name
        resourceLocation.text = countryVO.location
        Glide.with(this)
            .load(countryVO.photo?.get(0))
            .into(ivMain)
        tvDetailRate.text = countryVO.averageRating.toString()

        photoAdatper.setNewData(countryVO.photo!!.toMutableList())
        serviceScoreRageAdapter.setNewData(countryVO.scoresAndReviews.toMutableList())

    }

    override fun showToursDetail(tourVO: TourVO, name: String) {
        tvDetail.text = tourVO.description
        resourceName.text = tourVO.name
        resourceLocation.text = tourVO.location
        Glide.with(this)
            .load(tourVO.photo?.get(0))
            .into(ivMain)
        tvDetailRate.text = tourVO.averageRating.toString()

        photoAdatper.setNewData(tourVO.photo!!.toMutableList())
        serviceScoreRageAdapter.setNewData(tourVO.scoresAndReviews.toMutableList())

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

}
