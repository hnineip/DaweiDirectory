package com.hnineiphyu.daweidirectory.ui.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.EducationAdapter
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.model.ResponseInfos
import com.hnineiphyu.daweidirectory.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_education_recycler.*

class EducationFragment : Fragment(), EducationAdapter.ClickListenter {

    private lateinit var educationAdapter: EducationAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var educationViewModel: EducationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        educationAdapter = EducationAdapter()
        recyclerEducation.adapter = educationAdapter
        recyclerEducation.layoutManager = viewManager
        educationAdapter.msetOnClickListener(this)
        observeViewModelEducation()
    }

    fun observeViewModelEducation() {

        educationViewModel = ViewModelProviders.of(this)
            .get(EducationViewModel::class.java)

//        educationViewModel.loadResults()

        educationViewModel.getResult().observe(
            viewLifecycleOwner, Observer<ResponseInfos> { result ->

                recyclerEducation.visibility = View.VISIBLE
                educationAdapter.updateList(result.infos as List<InfosItem>)

            }
        )

        educationViewModel.getErrors().observe(
            viewLifecycleOwner, Observer<Boolean> { isError ->

                if(isError){
                    txtErrorEducation.visibility = View.VISIBLE
                    recyclerEducation.visibility = View.GONE
                }
                else{
                    txtErrorEducation.visibility = View.GONE
                }
            }
        )

        educationViewModel.getLoading().observe(viewLifecycleOwner, Observer<Boolean> { isLoading ->
            if(isLoading){
                loadingViewEducation.visibility = if(isLoading)
                    View.VISIBLE else View.INVISIBLE

                if(isLoading){
                    txtErrorEducation.visibility = View.GONE
                    recyclerEducation.visibility = View.GONE
                }
            }
        })
    }
    override fun OnClick(infosItem: InfosItem) {

    }
}
