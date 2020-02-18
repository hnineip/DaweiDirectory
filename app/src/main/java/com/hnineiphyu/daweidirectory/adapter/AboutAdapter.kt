package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.About

class AboutViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    var Name = itemView.findViewById<TextView>(R.id.tv_name)
    var Icon = itemView.findViewById<ImageView>(R.id.icon_about)
}

class AboutAdapter(  var aboutList: ArrayList<About> ): RecyclerView.Adapter<AboutViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_about, parent, false)
        return AboutViewHolder(view)
    }

    override fun getItemCount(): Int {
        return aboutList.size
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        holder.Icon.setImageResource(aboutList[position].aboutIcon)
        holder.Name.text = aboutList[position].aboutName
    }

}