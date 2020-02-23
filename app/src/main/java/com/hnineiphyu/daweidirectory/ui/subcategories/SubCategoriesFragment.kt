package com.hnineiphyu.daweidirectory.ui.subcategories


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hnineiphyu.daweidirectory.R

/**
 * A simple [Fragment] subclass.
 */
class SubCategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_categories, container, false)
    }


}
