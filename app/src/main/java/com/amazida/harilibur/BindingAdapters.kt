package com.amazida.harilibur

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amazida.harilibur.network.HariLibur
import com.amazida.harilibur.ui.HariLiburListAdapter

@BindingAdapter("getListData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<HariLibur>?){
    val adapter = recyclerView.adapter as HariLiburListAdapter
    adapter.submitList(data)
}
