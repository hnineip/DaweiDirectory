package com.hnineiphyu.daweidirectory.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.hnineiphyu.daweidirectory.R
//import com.hnineiphyu.daweidirectory.model.InfosItem
//import com.hnineiphyu.daweidirectory.ui.restruantdetail.RestruantDetailFragment
//import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.main.item_detail_restruant.view.*
//import kotlinx.android.synthetic.main.item_restaurant.view.*
//
//class RestruantDetailAdapter(var restruantDetailList: ArrayList<InfosItem> = ArrayList()) :
//    RecyclerView.Adapter<RestruantDetailAdapter.RestrauantDetailViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestrauantDetailViewHolder {
//        var view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_detail_restruant, parent, false)
//        return RestrauantDetailViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return restruantDetailList.size
//    }
//
//    override fun onBindViewHolder(holder: RestrauantDetailViewHolder, position: Int) {
//        holder.bindRestruantDetail(restruantDetailList.get(position))
//    }
//
//
//    var mClickListenter: ClickListenter? = null
//
//    fun setOnClickListener(clickListenter: RestruantDetailFragment) {
//        this.mClickListenter = clickListenter
//    }
//
//    fun updateList(infosItem: List<InfosItem>) {
//        this.restruantDetailList = infosItem as ArrayList<InfosItem>
//        notifyDataSetChanged()
//    }
//
//    inner class RestrauantDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
//        View.OnClickListener {
//
//        private var view: View = itemView
//        private lateinit var infosItem: InfosItem
//
//        init {
//            itemView.setOnClickListener(this)
//        }
//
//        fun bindRestruantDetail(infosItem: InfosItem) {
//            this.infosItem = infosItem
//            Picasso.get()
//                .load(infosItem.photo)
//                .placeholder(R.drawable.loading)
//                .into(view.restruant_detail_image)
//            view.restruant_phoneno.text = infosItem.phoneno
//            view.restruant_address.text = infosItem.address
//            view.restruant_map.text = infosItem.location
//        }
//
//        override fun onClick(v: View?) {
//            mClickListenter?.onClick(infosItem)
//        }
//    }
//
//    interface ClickListenter {
//        fun onClick(infosItem: InfosItem)
//    }
//}
//
