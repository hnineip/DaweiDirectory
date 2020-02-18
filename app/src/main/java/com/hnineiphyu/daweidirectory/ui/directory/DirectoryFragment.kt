package com.hnineiphyu.daweidirectory.ui.directory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hnineiphyu.daweidirectory.R

class DirectoryFragment : Fragment() {

    private lateinit var directoryViewModel: DirectoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            directoryViewModel =
                ViewModelProviders.of(this).get(DirectoryViewModel::class.java)

        return inflater.inflate(R.layout.fragment_list, container, false)

    }
}
