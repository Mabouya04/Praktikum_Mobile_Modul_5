package com.example.valorantapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.databinding.ListViewItemBinding
import com.example.valorantapp.network.MakeUp

class MakeUpListAdapter (val clickListener: MakeUpListener):
    ListAdapter<MakeUp, MakeUpListAdapter.MakeUpViewHolder>(DiffCallback) {

        class MakeUpViewHolder(
            var binding: ListViewItemBinding
        ) : RecyclerView.ViewHolder(binding.root){
            fun bind(clickListener: MakeUpListener, makeUp: MakeUp){
                binding.makeup = makeUp
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }

        companion object DiffCallback : DiffUtil.ItemCallback<MakeUp>(){

            override fun areItemsTheSame(oldItem: MakeUp, newItem: MakeUp): Boolean {
                return oldItem.nameMakeup == newItem.nameMakeup
            }

            override fun areContentsTheSame(oldItem: MakeUp, newItem: MakeUp): Boolean {
                return oldItem.descriptionMakeUp == newItem.descriptionMakeUp && oldItem.makeUpLink == newItem.makeUpLink
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeUpViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MakeUpViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MakeUpViewHolder, position: Int) {
        val makeup = getItem(position)
        holder.bind(clickListener, makeup)
    }
}


class MakeUpListener(val clickListener: (makeUp: MakeUp) -> Unit){
    fun onClick(makeUp: MakeUp) = clickListener(makeUp)
}