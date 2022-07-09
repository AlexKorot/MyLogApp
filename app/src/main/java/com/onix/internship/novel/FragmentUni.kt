package com.onix.internship.novel

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.UniFragmentBinding
import com.onix.internship.ui.main.MainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentUni:BaseFragment<UniFragmentBinding>(R.layout.uni_fragment){

    override val viewModel: NovelViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.dialogTextUni.observe(viewLifecycleOwner) {
            when(it){
             resources.getString(R.string.dialog_Uni_first) -> binding.textView.visibility = View.VISIBLE
             resources.getString(R.string.dialog_Uni_four)->{binding.imageButton.visibility=View.VISIBLE
                                                              binding.imageButton2.visibility=View.VISIBLE}
            resources.getString(R.string.next) -> {binding.textView.visibility = View.INVISIBLE
                navigate(R.id.fragmentMeadow, clearStack = true)}
               }
            }
        }
    }


