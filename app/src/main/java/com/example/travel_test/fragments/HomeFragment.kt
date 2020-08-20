package com.example.travel_test.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.travel_test.R
import com.example.travel_test.activities.DetailActivity
import com.example.travel_test.adapters.countryItemAdapter
import com.example.travel_test.adapters.populatToursAdapter
import com.example.travel_test.data.models.ToursModeImpl
import com.example.travel_test.data.models.ToursModel
import com.example.travel_test.data.vos.CountryVO
import com.example.travel_test.data.vos.TourVO
import com.example.travel_test.delegate.TravelDelegate
import com.example.travel_test.mvp.Impls.MainPresenterImpl
import com.example.travel_test.mvp.presenter.MainPresenter
import com.example.travel_test.mvp.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.swipeRefreshLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), MainView {

    private val mTourModel: ToursModel = ToursModeImpl
    private lateinit var mPresenter: MainPresenter
    private lateinit var countryAdapter: countryItemAdapter
    private lateinit var toursAdapter: populatToursAdapter


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
//        var countryAdapter : countryItemAdapter= countryItemAdapter(this)
//        view.rvCountry.adapter = countryAdapter
//
//        val toursAdapter : populatToursAdapter = populatToursAdapter(this)
//        view.rvPopularTours.adapter = toursAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setUpPresenter()
        hideEmptyView()
        setUpSwipeRefresh()
        setUpRecycler()
        mPresenter.onUiReady(this)
        //setUpViewPod()
    }

    //    private fun setUpViewPod() {
//        viewPodEmpty = vpEmpty as EmptyViewPod
//        viewPodEmpty.setEmptyData(
//            "There are no data available",
//            "https://point-broadband.com/wp-content/uploads/2017/06/No-data-caps-graphic-e1497904686711.png"
//        )
//    }
    override fun navigateToDetail(name: String, key: Int) {
        context?.let {
            startActivity(DetailActivity.newIntent(it, name, key))
        }
    }

    override fun displayCountryList(countryList: List<CountryVO>) {
        countryAdapter.setNewData(countryList.toMutableList())
    }

    override fun displayTourList(tourList: List<TourVO>) {
        toursAdapter.setNewData(tourList.toMutableList())
    }

    override fun displayEmptyView() {
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    private fun setUpRecycler() {
        countryAdapter = countryItemAdapter(mPresenter)
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvCountry.layoutManager = linearLayoutManager
        rvCountry.adapter = countryAdapter
        toursAdapter = populatToursAdapter(mPresenter)
        val linearLayoutManagerTour =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvPopularTours.layoutManager = linearLayoutManagerTour
        rvPopularTours.adapter = toursAdapter
    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    fun showEmptyView() {
        ivEmpty.visibility = View.VISIBLE
    }

    fun hideEmptyView() {
        ivEmpty.visibility = View.GONE
    }
//    private fun requestData(){
//        enableSwipeRefresh()
//
//        mTourModel.getAllTours()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                disableSwipeRefresh()
//                if (it.isNotEmpty()) {
//                    hideEmptyView()
//                    toursAdapter.setNewData(it.toMutableList())
//                } else {
//                    showEmptyView()
//                }
//            },{
//                enableSwipeRefresh()
//                showEmptyView()
//            }
//            ).addTo(compositeDisposable)
//
//        mTourModel.getAllCountries()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//                    disableSwipeRefresh()
//                    if(it.isNotEmpty()) {
//                        hideEmptyView()
//                        countryAdapter.setNewData(it.toMutableList())
//                    } else {
//                        showEmptyView()
//                    }
//                },{
//                    enableSwipeRefresh()
//                    showEmptyView()
//                }
//            )
//            .addTo(compositeDisposable)
//
//    }


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
            //   } else {
            //    throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
