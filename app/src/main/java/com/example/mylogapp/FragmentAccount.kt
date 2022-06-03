package com.example.mylogapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mylogapp.databinding.FragmentAccountBinding

class FragmentAccount: Fragment(R.layout.fragment_account){
    lateinit var binding: FragmentAccountBinding
    private val args:FragmentAccountArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentAccountBinding.bind(view)
        val email=args.email
        binding.tvLog.text= email
        val direction=FragmentAccountDirections.actionFragmentAccountToFragmentStart()
        binding.btStart.setOnClickListener {
            findNavController().navigate(direction)
        }
        binding.btExit.setOnClickListener {
            requireActivity().finish()
        }

    }
}