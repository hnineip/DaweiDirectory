package com.hnineiphyu.daweidirectory.ui.health


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.HealthAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.SelectedCategoryViewModel
import com.hnineiphyu.daweidirectory.viewmodel.SelectedDetailViewModel
import kotlinx.android.synthetic.main.fragment_recycler_health.*

/**
 * A simple [Fragment] subclass.
 */
class HealthFragment : Fragment(), HealthAdapter.ClickListenter {

    private lateinit var healthAdapter: HealthAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var healthViewModel: HealthViewModel
    private lateinit var selectedCategoryViewModel: SelectedCategoryViewModel
    lateinit var categoryKey: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        healthAdapter = HealthAdapter()
        recyclerHealth.adapter = healthAdapter
        recyclerHealth.layoutManager = viewManager
        healthAdapter.setOnClickListener(this)
        observeViewModelHealth()
    }

    fun observeViewModelHealth() {

        healthViewModel = ViewModelProviders.of(this)
            .get(HealthViewModel::class.java)

        healthViewModel.loadResults()

        healthViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerHealth.visibility = View.VISIBLE
                healthAdapter.updateList(result.infos as List<InfosItem>)

            }
        )

        healthViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if (isError) {
                    txtErrorHealth.visibility = View.VISIBLE
                    recyclerHealth.visibility = View.GONE
                } else {
                    txtErrorHealth.visibility = View.GONE
                }
            }
        )

        healthViewModel.getLoading()
            .observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->

                loadingViewHealth.visibility = if (isLoading)
                    View.VISIBLE else View.INVISIBLE

                if (isLoading) {
                    txtErrorHealth.visibility = View.GONE
                    recyclerHealth.visibility = View.GONE
            }
        })
    }

    override fun OnClick(infosItem: InfosItem) {

        if (!TextUtils.isEmpty(infosItem.photo)) {
            val selectedDetailViewModel: SelectedDetailViewModel =
                ViewModelProviders.of(activity!!).get(SelectedDetailViewModel::class.java)

            selectedDetailViewModel.selectedDetail(infosItem)

            view!!.findNavController()
                .navigate(R.id.action_navigation_health_to_navigation_health_detail)
        }
    }
}
