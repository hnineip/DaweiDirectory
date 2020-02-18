package com.hnineiphyu.daweidirectory.adapter
import com.hnineiphyu.daweidirectory.model.Entertainment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R

class EntertainmentViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    var Name = itemView.findViewById<TextView>(R.id.category_names)
    var Icon = itemView.findViewById<ImageView>(R.id.icon_promotion)
}

class EntertainmentAdapter(  var entertainmentList: ArrayList<Entertainment> ): RecyclerView.Adapter<EntertainmentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntertainmentViewHolder {
      var view = LayoutInflater.from(parent.context).inflate(R.layout.item_entertainment, parent, false)
      return EntertainmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return entertainmentList.size
    }

    override fun onBindViewHolder(holder: EntertainmentViewHolder, position: Int) {
        holder.Name.text = entertainmentList[position].names
        holder.Icon.setImageResource(entertainmentList[position].icons)
    }

}

