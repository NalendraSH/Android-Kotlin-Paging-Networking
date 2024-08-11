package com.nanz.catto.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nanz.catto.data.response.CatResponse
import com.nanz.catto.databinding.ItemMainBinding

class LoadMorePagingAdapter: PagingDataAdapter<CatResponse, LoadMorePagingAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bindItem(data)
        }
    }

    class ViewHolder(private val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(data: CatResponse) {
            if (data.breeds.isNotEmpty()) {
                val breeds = data.breeds[0]
                binding.tvBreedName.text = breeds.name
                Glide.with(binding.root.context)
                    .load(data.url)
                    .into(binding.ivCat)
                binding.tvTemperament.text = breeds.temperament
                binding.tvDescription.text = breeds.description
            }
        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CatResponse>() {
            override fun areItemsTheSame(oldItem: CatResponse, newItem: CatResponse): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: CatResponse, newItem: CatResponse): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}