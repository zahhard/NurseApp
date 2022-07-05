package com.example.nurseapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.nurseapp.R
import com.example.nurseapp.data.database.a
import com.example.nurseapp.model.Category


typealias showInsideOfItem = (Int) -> Unit
typealias showInsideOfCategory = (String) -> Unit


class CategoryAdapter(var fragment: Fragment, private var showFilmDetails: showInsideOfCategory) :
    ListAdapter<Category, CategoryAdapter.ViewHolder>(DiffCallback) {


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val  imageViewItemCategory: ImageView = view.findViewById<ImageView>(R.id.rounded_image)
//        val  cardView = view.findViewById<CardView>(R.id.cardView)
        val title: TextView = view.findViewById<TextView>(R.id.category_name)
        var card : CardView = view.findViewById(R.id.card)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ccategory_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = getItem(position).name
        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(20))
        Glide.with(fragment)
            .load(getItem(position).src)
            .placeholder(android.R.drawable.ic_dialog_info)
            .error(android.R.drawable.ic_dialog_alert)
//            .apply(RequestOptions.circleCropTransform())
            .transform(transformation)
            .into(holder.imageViewItemCategory)

        val  colorList = arrayListOf("#F6DAE4", "#D4F0F7", "#D0D5F7", "#B8CFEC", "#FFEC94")


        if (a.colorId < 4){
            holder.card.setCardBackgroundColor(Color.parseColor(colorList[a.colorId]));
            a.colorId ++
        }
        else
            a.colorId = 0



        holder.itemView.setOnClickListener {
            showFilmDetails(getItem(position).name)
        }

        holder.itemView.onFocusChangeListener

    }

    companion object DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.name == newItem.name
        }
    }
}