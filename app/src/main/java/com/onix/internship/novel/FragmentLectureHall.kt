package com.onix.internship.novel

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.loadAnimation
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.LectureHallFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentLectureHall:BaseFragment<LectureHallFragmentBinding>(R.layout.lecture_hall_fragment) {

    override val viewModel: NovelViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel=viewModel
        binding.lifecycleOwner = viewLifecycleOwner

          viewModel.dialogTextLecture.observe(viewLifecycleOwner,{
              if(it==resources.getString(R.string.next)){binding.textView.visibility=View.GONE
                  navigate(R.id.fragmentUni, clearStack = true)}
          })


  }
}