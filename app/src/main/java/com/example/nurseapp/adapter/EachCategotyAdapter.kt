package com.example.nurseapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
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
import com.example.nurseapp.data.database.NurseEntity
import com.example.nurseapp.model.Category
import com.example.nurseapp.model.Nurse

class EachCategotyAdapter(var fragment: Fragment, private var showFilmDetails: showInsideOfItem) :
    ListAdapter<NurseEntity, EachCategotyAdapter.ViewHolder>(DiffCallback) {


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val imageViewItemCategory: ImageView = view.findViewById<ImageView>(R.id.item_category)
        //        val  cardView = view.findViewById<CardView>(R.id.cardView)
        val title: TextView = view.findViewById<TextView>(R.id.item_name)
        val education: TextView = view.findViewById<TextView>(R.id.education)
        val rating : RatingBar = view.findViewById(R.id.rating_bar)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.each_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = getItem(position).fname
        holder.education.text = getItem(position).education
        holder.rating.rating = getItem(position).average_rate
        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(20))
        Glide.with(fragment)
            .load(getItem(position).image)
            .placeholder(android.R.drawable.ic_dialog_info)
            .error(android.R.drawable.ic_dialog_alert)
//            .apply(RequestOptions.circleCropTransform())
            .transform(transformation)
            .into(holder.imageViewItemCategory)


        holder.itemView.setOnClickListener {
            showFilmDetails(getItem(position).id)
        }

        holder.itemView.onFocusChangeListener

    }

    companion object DiffCallback : DiffUtil.ItemCallback<NurseEntity>() {
        override fun areItemsTheSame(oldItem: NurseEntity, newItem: NurseEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NurseEntity, newItem: NurseEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
