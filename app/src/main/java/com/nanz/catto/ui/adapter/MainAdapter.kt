package com.nanz.catto.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nanz.catto.data.response.CatResponse
import com.nanz.catto.databinding.ItemMainBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val list: MutableList<CatResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    fun addData(list: List<CatResponse>) {
        this.list.clear()
        this.list.addAll(list)
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

}