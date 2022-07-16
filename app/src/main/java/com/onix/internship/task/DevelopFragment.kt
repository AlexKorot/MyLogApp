package com.onix.internship.task

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.databinding.DevelopmentFragmentBinding
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DevelopFragment:BaseFragment<DevelopmentFragmentBinding>(R.layout.development_fragment) {
    override val viewModel: SplashViewModel by viewModel()
}