package com.hnineiphyu.daweidirectory.ui.subcategory
//

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.SubCategoryAdapter
import com.hnineiphyu.daweidirectory.model.SubCategory
import com.hnineiphyu.daweidirectory.viewmodel.SelectedSubCategoryViewModel

/**
 * A simple [Fragment] subclass.
 */
class RecyclerSubCategoryFragment : Fragment(), SubCategoryAdapter.ClickListenter {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

    var root = inflater.inflate(R.layout.fragment_recycler_sub_category, container, false)

    var SubCategoryRecyclerView = root.findViewById<RecyclerView>(R.id.recycler_sub_category)

    var SubCategoryList = ArrayList<SubCategory>()

    SubCategoryList.add(SubCategory(R.drawable.ic_iconfinder_categories, "Category", 14))
    SubCategoryList.add(SubCategory(R.drawable.ic_location_place, "Well Known Places", 4))
    SubCategoryList.add(SubCategory(R.drawable.ic_emergency, "Emergency", 13))

    var subCategoryAdapter = SubCategoryAdapter(SubCategoryList)

    SubCategoryRecyclerView.layoutManager = GridLayoutManager(context, 3)

    SubCategoryRecyclerView.adapter = subCategoryAdapter

    subCategoryAdapter.setOnClickListener(this)

    return root
}

    override fun onClick(subCategory: SubCategory) {

        if (subCategory.key == 4) {

            val selectedSubCategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedSubCategoryViewModel::class.java)

            selectedSubCategoryViewModel.selectedSubCategory(subCategory)

            view!!.findNavController()
                .navigate(R.id.action_navigation_directory_to_navigation_place)
        }

        if (subCategory.key == 14) {

            val selectedSubCategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedSubCategoryViewModel::class.java)

            selectedSubCategoryViewModel.selectedSubCategory(subCategory)

            view!!.findNavController()
                .navigate(R.id.action_navigation_directory_to_navigation_sub_categories)
        }

        if (subCategory.key == 13) {

            val selectedSubCategoryViewModel =
                ViewModelProviders.of(activity!!).get(SelectedSubCategoryViewModel::class.java)

            selectedSubCategoryViewModel.selectedSubCategory(subCategory)

            view!!.findNavController()
               .navigate(R.id.action_navigation_directory_to_navigation_emergency)
        }


    }
}
