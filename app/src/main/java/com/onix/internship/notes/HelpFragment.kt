package com.onix.internship.notes

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.HelpFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HelpFragment:BaseFragment<HelpFragmentBinding>(R.layout.help_fragment) {
    override val viewModel:NoteListViewModel by viewModel()
}