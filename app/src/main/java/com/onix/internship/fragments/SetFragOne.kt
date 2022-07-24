package com.onix.internship.fragments

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SettingFragOneBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SetFragOne: BaseFragment<SettingFragOneBinding> (R.layout.setting_frag_one){
    override val viewModel: StartFragmentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.str = this
}

    fun navPrev(){
        navigate(R.id.ageCheckFragment,clearStack = true)
    }
    fun navNext(){
        navigate(R.id.setFragTwo,clearStack = true)
    }
}