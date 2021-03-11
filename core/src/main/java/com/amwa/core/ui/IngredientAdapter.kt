package com.amwa.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amwa.core.R
import com.amwa.core.databinding.ItemIngredientBinding
import com.amwa.core.domain.model.recipe.Ingredient
import com.amwa.core.utils.Constants
import com.bumptech.glide.Glide

class IngredientAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Ingredient>() {
        override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
            return oldItem == newItem
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return IngredientViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_ingredient,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is IngredientViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Ingredient>) {
        differ.submitList(list)
    }

    inner class IngredientViewHolder
    constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemIngredientBinding.bind(itemView)

        fun bind(item: Ingredient) = binding.apply {
            Glide.with(root.context)
                .load(Constants.INGREDIENT_IMG_BASE_URL + item.image)
                .placeholder(R.drawable.icons8_ingredients_100)
                .into(ivImage)
            ivImage.contentDescription = item.name

            tvTitle.text = item.name
            tvAmount.text = "${item.amount} ${item.unit}"
        }
    }
}