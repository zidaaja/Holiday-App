package com.amazida.harilibur.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.amazida.harilibur.R
import com.amazida.harilibur.databinding.FragmentListLiburanBinding

class HariLiburListFragment: Fragment() {

    private val viewModel: MyViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListLiburanBinding.inflate(inflater)
        viewModel.getData()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = HariLiburListAdapter(HariLiburListener { harilibur ->
            viewModel.onHariLiburClicked(harilibur)
            findNavController()
                .navigate(R.id.action_hariLiburListFragment_to_hariLiburDetailFragment)
        })
        return binding.root
    }
}