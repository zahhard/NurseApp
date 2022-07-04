package com.example.nurseapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.nurseapp.R
import com.example.nurseapp.data.database.OrderEntity
import com.example.nurseapp.model.Category

class OrderAdapter(var fragment: Fragment, private var showFilmDetails: showInsideOfItem) :
    ListAdapter<OrderEntity, OrderAdapter.ViewHolder>(DiffCallback) {


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val nurseName: TextView = view.findViewById<TextView>(R.id.nurseName)
        val order: TextView = view.findViewById<TextView>(R.id.orderName)
        val date: TextView = view.findViewById<TextView>(R.id.date)
        val imageView: ImageView = view.findViewById(R.id.image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        holder.nurseName.text = getItem(position).start_time
        holder.order.text = getItem(position).start_time
        holder.date.text = getItem(position).day_count.toString() + " day"

//        if (getItem(position).education == "baby care"){
//            Glide.with(fragment)
//                .load("https://img.icons8.com/fluency/344/mother-room.png")
//                .placeholder(android.R.drawable.ic_dialog_info)
//                .error(android.R.drawable.ic_dialog_alert)
//                .into(holder.imageView)
//        }
//        if (getItem(position).userId == "elderly care"){
//            Glide.with(fragment)
//                .load("https://img.icons8.com/color/344/elderly-person.png")
//                .placeholder(android.R.drawable.ic_dialog_info)
//                .error(android.R.drawable.ic_dialog_alert)
//                .into(holder.imageView)
//        }
//        if (getItem(position).education == "general care"){
//            Glide.with(fragment)
//                .load("https://img.icons8.com/color/2x/examination.png")
//                .placeholder(android.R.drawable.ic_dialog_info)
//                .error(android.R.drawable.ic_dialog_alert)
//                .into(holder.imageView)
//        }
//        if (getItem(position).education == "bandage"){
//            Glide.with(fragment)
//                .load("https://img.icons8.com/color/2x/cast.png")
//                .placeholder(android.R.drawable.ic_dialog_info)
//                .error(android.R.drawable.ic_dialog_alert)
//                .into(holder.imageView)
//        }


        holder.itemView.setOnClickListener {
            showFilmDetails(getItem(position).id)
        }

        holder.itemView.onFocusChangeListener

    }

    companion object DiffCallback : DiffUtil.ItemCallback<OrderEntity>() {
        override fun areItemsTheSame(oldItem: OrderEntity, newItem: OrderEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OrderEntity, newItem: OrderEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }
}