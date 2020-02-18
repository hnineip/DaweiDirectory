package com.hnineiphyu.daweidirectory.ui.entertainment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.adapter.EntertainmentAdapter
import com.hnineiphyu.daweidirectory.model.Entertainment

/**
 * A simple [Fragment] subclass.
 */
class EntertainmentRecyclerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recyclerList, container, false)

        var view = inflater.inflate(R.layout.fragment_recycler_entertainment, container, false)

        var EntertainmentRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_entertainment)

        var EntertainmentList = ArrayList<Entertainment>()

        EntertainmentList.add(Entertainment(R.drawable.ic_promotion, "Promotions"))
        EntertainmentList.add(Entertainment(R.drawable.ic_iconfinder_video, "Movies"))
        EntertainmentList.add(Entertainment(R.drawable.ic_stars, "Reviews"))
        EntertainmentList.add(Entertainment(R.drawable.ic_events, "Events"))

        var entertainmentAdapter = EntertainmentAdapter(EntertainmentList)

        EntertainmentRecyclerView.layoutManager = GridLayoutManager( context, 2)

        EntertainmentRecyclerView.adapter = entertainmentAdapter

        return view
    }
}


