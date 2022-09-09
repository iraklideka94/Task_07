package com.example.task_07.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.task_07.databinding.MusicLayoutBinding
import com.example.task_07.models.ActiveCourse

class DataAdapter: PagingDataAdapter<ActiveCourse,DataAdapter.MyViewHolder>(diffCallBack) {

    inner class MyViewHolder(val binding: MusicLayoutBinding): RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallBack = object : DiffUtil.ItemCallback<ActiveCourse>() {
            override fun areItemsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            tvBookBold.text = currentItem?.booking_time.toString()
            tvTxt.text = currentItem?.booking_time.toString()
            val imageLink = currentItem?.image
            imageView.load(imageLink) {
                crossfade(true)
                crossfade(1000)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(MusicLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}