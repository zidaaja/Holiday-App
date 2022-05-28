package com.amazida.harilibur.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.amazida.harilibur.databinding.FragmentDetailLiburanBinding

class HariLiburDetailFragment: Fragment() {
    private val detailViewModel : MyViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailLiburanBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewmodel = detailViewModel

        return binding.root
    }
}