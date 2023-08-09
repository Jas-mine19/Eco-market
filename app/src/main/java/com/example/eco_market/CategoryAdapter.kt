package com.example.eco_market

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.eco_market.databinding.ItemCategoryCardBinding

class CategoryAdapter(
    private val category: List<CategoryData>,
    private val onItemClick: (category: CategoryData, position: Int) -> Unit
) :
    RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemCategoryCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemCategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = category.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = category[position]
        holder.binding.categoryName.text = item.categoryName
//        holder.binding.ivBackground.setImageResource(item.imageUrl)
    }
}