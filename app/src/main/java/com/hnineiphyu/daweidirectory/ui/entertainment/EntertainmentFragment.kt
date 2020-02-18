package com.hnineiphyu.daweidirectory.ui.entertainment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hnineiphyu.daweidirectory.R

class EntertainmentFragment : Fragment() {

    private lateinit var entertainmentViewModel: EntertainmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        entertainmentViewModel =
                ViewModelProviders.of(this).get(EntertainmentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_entertainment, container, false)

        return root
    }
}