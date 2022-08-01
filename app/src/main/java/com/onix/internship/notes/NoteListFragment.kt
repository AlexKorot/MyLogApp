package com.onix.internship.notes

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.NoteListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoteListFragment:BaseFragment<NoteListFragmentBinding>(R.layout.note_list_fragment) {
    override val viewModel:NoteListViewModel by viewModel()

}