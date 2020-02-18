package com.hnineiphyu.daweidirectory.ui.health


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.HealthAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.viewmodel.CategoryViewModel

/**
 * A simple [Fragment] subclass.
 */
class HealthFragment : Fragment(), HealthAdapter.ClickListenter {

    private lateinit var healthAdapter: HealthAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health, container, false)
    }



    override fun OnClick(infosItem: InfosItem) {
    }


}
