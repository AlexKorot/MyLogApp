package com.onix.internship.ui.translate

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.TransleteFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TranslateFragment:BaseFragment<TransleteFragmentBinding> (R.layout.translete_fragment){
    override val viewModel: TranslateViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel=viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.button2.setOnClickListener {
            var word = binding.word1.text.toString()
            viewModel.wordTranslate(word )
            binding.word1.setText(null)
            viewModel.error.observe(viewLifecycleOwner,{
                binding.word.error=it
            })


        }
    }
}