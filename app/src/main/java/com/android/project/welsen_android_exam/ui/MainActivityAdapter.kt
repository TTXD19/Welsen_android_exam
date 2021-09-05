package com.android.project.welsen_android_exam.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.project.welsen_android_exam.data.data_class.local.NewsDetailRespRealm
import com.android.project.welsen_android_exam.databinding.VhNewsItemBinding
import com.bumptech.glide.Glide

class MainActivityAdapter: RecyclerView.Adapter<MainActivityAdapter.NewDerailViewHolder>() {

    private val dataList = mutableListOf<NewsDetailRespRealm>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewDerailViewHolder {
        return NewDerailViewHolder(
            VhNewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewDerailViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateDataList(locationList: List<NewsDetailRespRealm>) {
        dataList.clear()
        dataList.addAll(locationList)
        notifyDataSetChanged()
    }

    inner class NewDerailViewHolder(
        private val binding: VhNewsItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(data: NewsDetailRespRealm){
            binding.tvNewsTitle.text = data.newsTitle
            Glide.with(binding.root.context).load(data.imageUrl).into(binding.imageNewsThumbnail)
        }
    }
}