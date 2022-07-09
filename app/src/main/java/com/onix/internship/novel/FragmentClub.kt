package com.onix.internship.novel

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.databinding.ClubFragmentBinding
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentClub :BaseFragment<ClubFragmentBinding>(R.layout.club_fragment){
    override val viewModel: NovelViewModel by viewModel()
}