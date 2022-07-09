package com.onix.internship.novel

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.MeadowFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMeadow:BaseFragment<MeadowFragmentBinding>(R.layout.meadow_fragment) {
    override val viewModel: NovelViewModel by viewModel()
}