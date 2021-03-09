package com.amwa.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amwa.core.R
import com.amwa.core.databinding.ItemInstructionBinding
import com.amwa.core.domain.model.recipe.Instruction

class InstructionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Instruction>() {
        override fun areItemsTheSame(oldItem: Instruction, newItem: Instruction): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Instruction, newItem: Instruction): Boolean {
            return oldItem == newItem
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return InstructionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_instruction,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is InstructionViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Instruction>) {
        differ.submitList(list)
    }

    inner class InstructionViewHolder
    constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemInstructionBinding.bind(itemView)

        fun bind(item: Instruction) = binding.apply {
            tvNumber.text = item.number.toString()
            tvInstruction.text = item.step
        }
    }
}