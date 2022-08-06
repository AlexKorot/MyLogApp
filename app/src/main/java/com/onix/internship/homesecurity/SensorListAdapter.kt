package com.onix.internship.homesecurity

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.onix.internship.R
import com.onix.internship.R.drawable.no_image
import com.onix.internship.databinding.ActivityMainBinding.bind
import com.onix.internship.databinding.SensorListItemBinding
import com.onix.internship.homesecurity.data.DataWebPage
import com.onix.internship.homesecurity.data.House




class SensorListAdapter (val clickListener: SensorItemListener): ListAdapter<House,SensorListAdapter.ViewHolder>(SensorListDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item!!, clickListener)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: SensorListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: House, clickListener: SensorItemListener) {
            binding.house = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SensorListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}
class SensorListDiffCallback : DiffUtil.ItemCallback<House>() {

    override fun areItemsTheSame(oldItem: House, newItem: House): Boolean {
        return oldItem.room == newItem.room
    }
    override fun areContentsTheSame(oldItem: House, newItem: House): Boolean {
        return oldItem == newItem
    }
}

class SensorItemListener ( val  clickListener: (itemId:String) -> Unit){
    fun onClick (item:House) = clickListener (item.room)
}