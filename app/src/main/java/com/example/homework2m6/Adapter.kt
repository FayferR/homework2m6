package com.example.homework2m6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2m6.databinding.ItemBinding

class Adapter(var list: ArrayList<Model>, var onClick: ((Model) -> Unit)) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(private var binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Model) {
            binding.imageItem.setImageResource(model.image)
            itemView.setOnClickListener {
                onClick(model)
                if (model.select) {
                    binding.imageSelect.visibility = View.VISIBLE
                } else {
                    binding.imageSelect.visibility = View.INVISIBLE
                }
            }
            onClick(model)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}