package com.onix.internship.fragments

import android.os.Bundle

import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.AgeCheckFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AgeCheckFragment : BaseFragment<AgeCheckFragmentBinding>(R.layout.age_check_fragment) {
    override val viewModel: StartFragmentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.str = this
    }
    fun navNext(){
        navigate(R.id.setFragOne,clearStack = false)
    }

}