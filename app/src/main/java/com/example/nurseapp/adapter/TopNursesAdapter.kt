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
import com.example.nurseapp.model.Nurse

class TopNursesAdapter(var fragment: Fragment, private var showFilmDetails: showInsideOfItem) :
    ListAdapter<NurseEntity, TopNursesAdapter.ViewHolder>(DiffCallback) {


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageViewItemCategory: ImageView = view.findViewById<ImageView>(R.id.rounded_image)
        val education = view.findViewById<TextView>(R.id.education_name)
        val name: TextView = view.findViewById<TextView>(R.id.person_name)
        val rate: RatingBar = view.findViewById(R.id.rating)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_nurses_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = getItem(position).fname
        holder.education.text = getItem(position).education
        holder.rate.rating = getItem(position).average_rate
        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(20))
        Glide.with(fragment)
            .load(getItem(position).image)
            .placeholder(android.R.drawable.ic_dialog_info)
            .error(android.R.drawable.ic_dialog_alert)
            .transform(transformation)
            .into(holder.imageViewItemCategory)


        holder.itemView.setOnClickListener {
            showFilmDetails(getItem(position).nurseID)
        }

        holder.itemView.onFocusChangeListener

    }

    companion object DiffCallback : DiffUtil.ItemCallback<NurseEntity>() {
        override fun areItemsTheSame(oldItem: NurseEntity, newItem: NurseEntity): Boolean {
            return oldItem.nurseID == newItem.nurseID
        }

        override fun areContentsTheSame(oldItem: NurseEntity, newItem: NurseEntity): Boolean {
            return oldItem.nurseID == newItem.nurseID
        }
    }

}