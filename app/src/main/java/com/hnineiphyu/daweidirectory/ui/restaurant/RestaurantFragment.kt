package com.hnineiphyu.daweidirectory.ui.restaurant

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.RestaurantAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel
import com.hnineiphyu.daweidirectory.viewmodel.SelectedDetailViewModel
import kotlinx.android.synthetic.main.fragment_restruant_recycler.*

class RestaurantFragment : Fragment(), RestaurantAdapter.ClickListenter {


    private lateinit var restaurantAdapter: RestaurantAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var restaurantViewModel: RestaurantViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel

    lateinit var categoryKey: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//
        val root = inflater.inflate(R.layout.fragment_restaurants, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        restaurantAdapter = RestaurantAdapter()
        recyclerRestruant.adapter = restaurantAdapter
        recyclerRestruant.layoutManager = viewManager
        restaurantAdapter.setOnClickListener(this)
        observeViewModel()
    }

    fun observeViewModel() {

        restaurantViewModel = ViewModelProviders.of(this)
            .get(RestaurantViewModel::class.java)

//        restaurantViewModel.loadResults()

        restaurantViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerRestruant.visibility = View.VISIBLE
                restaurantAdapter.updateList(result.infos as List<InfosItem>)
                loadingView.visibility = View.INVISIBLE

            }
        )

        restaurantViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if (isError) {
                    txtError.visibility = View.VISIBLE
                    recyclerRestruant.visibility = View.GONE
                } else {
                    txtError.visibility = View.GONE
                }
            }
        )

        restaurantViewModel.getLoading()
            .observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->
                loadingView.visibility = if (isLoading)
                    View.VISIBLE else View.GONE

                if (isLoading) {
                    txtError.visibility = View.GONE
                    recyclerRestruant.visibility = View.GONE
                }

            })
        }

    override fun onResume() {
        super.onResume()
        restaurantViewModel.loadResults()
    }

    override fun onClick(infosItem: InfosItem) {

        if (!TextUtils.isEmpty(infosItem.photo)) {
            val selectedDetailViewModel: SelectedDetailViewModel =
                ViewModelProviders.of(activity!!).get(SelectedDetailViewModel::class.java)

            selectedDetailViewModel.selectedDetail(infosItem)
            view!!.findNavController()
                .navigate(R.id.action_navigation_restruant_to_navigation_detail_restruant)
        }
    }
}

//    override fun onResume() {
//        super.onResume()
//        restruantViewModel.loadResults()
//    }
