package com.onix.internship.ui.fragments

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.GameFragmentBinding
import com.onix.internship.databinding.SplashFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : BaseFragment<GameFragmentBinding>(R.layout.game_fragment){
    override val viewModel: GameViewModel by viewModel()
     val state=arguments?.getString("State")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (state=="cross") binding.imageView.setImageResource(R.drawable.cross)

        else binding.imageView.setImageResource(R.drawable.circle)

    }

}