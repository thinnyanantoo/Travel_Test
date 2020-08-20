package com.example.travel_test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.travel_test.R
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.fragments.HomeFragment
import com.example.travel_test.mvp.view.MainView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private fun replaceFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.fLBottomNavigationContainer,
            HomeFragment.newInstance("", "")).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      replaceFragment()

//        bottomNavigation.setOnNavigationItemSelectedListener(object :
//        BottomNavigationView.OnNavigationItemSelectedListener{
//            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                when (item.itemId) {
//                    R.id.bottomNavigation_home_menu -> {
//                        supportFragmentManager.beginTransaction().replace(
//                            R.id.fLBottomNavigationContainer,
//                            HomeFragment.newInstance("A","B")
//                        )
//                            .commit()
//                        return true
//                    }
//                }
//                return false
//
//            }

      //  })
    }
}
