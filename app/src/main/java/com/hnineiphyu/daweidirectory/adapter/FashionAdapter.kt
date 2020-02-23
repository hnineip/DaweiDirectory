package com.hnineiphyu.daweidirectory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.daweidirectory.R
import com.hnineiphyu.daweidirectory.model.InfosItem
import com.hnineiphyu.daweidirectory.ui.fashion.FashionFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_fashion.view.*

class FashionAdapter(var fashionList: ArrayList<InfosItem> = ArrayList()) :
    RecyclerView.Adapter<FashionAdapter.FashionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FashionViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_fashion, parent, false)
        return FashionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fashionList.size
    }

    override fun onBindViewHolder(holder: FashionViewHolder, position: Int) {
        holder.bindFashion(fashionList.get(position))
    }

    var nClickListenter: ClickListenter? = null

    fun setOnClickListener(clickListenter: FashionFragment) {
        this.nClickListenter = clickListenter
    }

    fun updateList(infosItem: List<InfosItem>) {
        this.fashionList = infosItem as ArrayList<InfosItem>
        notifyDataSetChanged()
    }

    inner class FashionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var view: View = itemView
        private lateinit var infosItem: InfosItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindFashion(infosItem: InfosItem){
            this.infosItem = infosItem
            Picasso.get()
                .load(infosItem.photo)
                .into(view.fashion_image)
            view.fashion_name.text = infosItem.title
        }

        override fun onClick(v: View?) {
            nClickListenter?.OnClick(infosItem)
        }
    }
    interface ClickListenter {
        fun OnClick(infosItem: InfosItem)
    }

}
