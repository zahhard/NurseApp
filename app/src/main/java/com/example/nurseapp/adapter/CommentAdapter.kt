package com.example.nurseapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.nurseapp.R
import com.example.nurseapp.data.database.CommentEntity

class CommentAdapter(var fragment: Fragment, private var showFilmDetails: showInsideOfItem) :
    ListAdapter<CommentEntity, CommentAdapter.ViewHolder>(DiffCallback) {


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById<TextView>(R.id.reviewer_name)
        val text: TextView = view.findViewById<TextView>(R.id.comment_text)
        val date: TextView = view.findViewById<TextView>(R.id.comment_date)

    }

//    override fun onCurrentListChanged(
//        previousList: MutableList<CommentEntity>,
//        currentList: MutableList<CommentEntity>
//    ) {
//        super.onCurrentListChanged(previousList, currentList)
//        for (i in previousList.size..currentList.size-1){
//            previousList.add(currentList[i])
//        }
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = getItem(position).title
        holder.text.text = getItem(position).massage
        holder.date.text = getItem(position).date
        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(20))

        holder.itemView.setOnClickListener {
            showFilmDetails(getItem(position).id)
        }

        holder.itemView.onFocusChangeListener

    }

    companion object DiffCallback : DiffUtil.ItemCallback<CommentEntity>() {
        override fun areItemsTheSame(oldItem: CommentEntity, newItem: CommentEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CommentEntity, newItem: CommentEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
