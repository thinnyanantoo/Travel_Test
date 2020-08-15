package com.example.travel_test.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.travel_test.R
import com.example.travel_test.adapters.rvPhotoAdatper
import com.example.travel_test.adapters.rvServiceScoreRageAdapter
import com.example.travel_test.data.models.ToursModeImpl
import com.example.travel_test.data.models.ToursModel
//import com.example.travel_test.data.vos.photoVO
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    var photoAdatper:rvPhotoAdatper = rvPhotoAdatper()
    var serviceScoreRageAdapter: rvServiceScoreRageAdapter = rvServiceScoreRageAdapter()
     val  num : Int = 0
   companion object{
       const val IE_NAME = "Name"
       val IE_TYPE = "Type"
       fun newIntent(context: Context,name : String, type : Int) : Intent {
           val intent = Intent(context,DetailActivity::class.java)
           intent.putExtra(IE_NAME,name)
           intent.putExtra(IE_TYPE,type)
           return intent
       }
   }

    private var mTourModel : ToursModel = ToursModeImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpRecycler()


        //country start
        val countryName = intent.getStringExtra(IE_NAME)
        val countryId = intent.getIntExtra(IE_TYPE,0)
        val countries = mTourModel.getAllCountriesByName(countryName, countryId)


        resourceName.text = countries.name

        resourceLocation.text = countries.location


        this.let {
            Glide.with (this)
                .load(countries.photo)
                .into(ivMain)
        }
        tvDetail.text = countries.description

        tvDetailRate.text = countries.averageRating.toString()


        serviceScoreRageAdapter.setNewData(countries.scoresAndReviews.toMutableList())

        photoAdatper.setNewData(countries.photo!!.toMutableList())



        //tours start
        val tourName = intent.getStringExtra(IE_NAME)
        val tourId = intent.getIntExtra(IE_TYPE,1)
        val tours = mTourModel.getAllToursByName(tourName, tourId)


        resourceName.text = tours.name

        resourceLocation.text = tours.location

        this.let {
            Glide.with (this)
                .load(countries.photo)
                .into(ivMain)
        }


        tvDetail.text = tours.description

        tvDetailRate.text = tours.averageRating.toString()


        serviceScoreRageAdapter.setNewData(tours.scoresAndReviews.toMutableList())

        photoAdatper.setNewData(tours.photo!!.toMutableList())
        ivBack.setOnClickListener { finish() }

    }

    private fun  setUpRecycler(){
        rvPhoto.adapter  = photoAdatper
        rvServiceScoreRage.adapter = serviceScoreRageAdapter
    }
}
