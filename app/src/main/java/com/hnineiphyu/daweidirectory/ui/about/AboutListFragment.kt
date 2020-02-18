package com.hnineiphyu.daweidirectory.ui.about


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.AboutAdapter
import com.hnineiphyu.daweidirectory.model.About

/**
 * A simple [Fragment] subclass.
 */
class AboutListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_about_list, container, false)

        var view = inflater.inflate(R.layout.fragment_about_list, container, false)

        var AboutRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_about)

        var AboutList = ArrayList<About>()

        AboutList.add(About(R.drawable.ic_favourite, "Favourite"))
        AboutList.add(About(R.drawable.ic_email, "Contact Us"))
        AboutList.add(About(R.drawable.ic_exit, "Log Out"))

        var aboutAdapter = AboutAdapter(AboutList)

        AboutRecyclerView.layoutManager = LinearLayoutManager(context)

        AboutRecyclerView.adapter = aboutAdapter

        return view

    }

}
