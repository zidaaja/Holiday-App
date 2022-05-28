package com.amazida.harilibur.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.amazida.harilibur.network.HariLibur
import com.amazida.harilibur.databinding.ListViewItemBinding


class HariLiburListAdapter(private val clickListener: HariLiburListener) :
    ListAdapter<HariLibur, HariLiburListAdapter.HariLiburViewHolder>(DiffCallback)
{
    class HariLiburViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: HariLiburListener, harilibur: HariLibur){
            binding.harilibur = harilibur
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<HariLibur>(){
        override fun areItemsTheSame(oldItem: HariLibur, newItem: HariLibur): Boolean {
            return oldItem.namaBulan == newItem.namaBulan
        }

        override fun areContentsTheSame(oldItem: HariLibur, newItem: HariLibur): Boolean {
            return oldItem.namaBulan == newItem.namaBulan
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : HariLiburViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HariLiburViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HariLiburViewHolder, position: Int){
        val harilibur = getItem(position)
        holder.bind(clickListener, harilibur)
    }
}

class HariLiburListener(val clickListener: (harilibur: HariLibur ) -> Unit){
    fun onClick(hariLibur: HariLibur) = clickListener(hariLibur)
}