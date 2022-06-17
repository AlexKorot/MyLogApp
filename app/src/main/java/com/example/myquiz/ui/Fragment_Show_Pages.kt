package com.example.myquiz.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myquiz.R
import com.example.myquiz.databinding.FragmentShowPageBinding

class Fragment_Show_Pages:Fragment(R.layout.fragment_show_page) {
    private lateinit var binding: FragmentShowPageBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentShowPageBinding.bind(view)
        binding.btNext.setOnClickListener {


            findNavController().navigate(R.id.action_fragment_Show_Pages_to_fragment_Result)

        }
    }

}