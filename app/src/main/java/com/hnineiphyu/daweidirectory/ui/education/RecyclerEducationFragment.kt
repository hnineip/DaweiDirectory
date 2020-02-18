package com.hnineiphyu.daweidirectory.ui.education


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hnineiphyu.daweidirectory.R

/**
 * A simple [Fragment] subclass.
 */
class RecyclerEducationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education_recycler, container, false)
    }


}
