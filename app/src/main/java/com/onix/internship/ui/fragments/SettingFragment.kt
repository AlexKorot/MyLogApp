package com.onix.internship.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SettingFragmentBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingFragment:BaseFragment<SettingFragmentBinding>(R.layout.setting_fragment) {
    override val viewModel: GameViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle()

        binding.btCross.setOnClickListener {
           val cross ="cross"
            bundle.putString("State", cross)
            navigate(R.id.gameFragment,bundle,false)
        }
        binding.btCicle.setOnClickListener {
            val circle ="circle"
            bundle.putString("State", circle)
            navigate(R.id.gameFragment,bundle,false)
        }

    }


}
