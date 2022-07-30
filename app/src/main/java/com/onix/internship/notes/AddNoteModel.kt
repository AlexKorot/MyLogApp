package com.onix.internship.notes

import androidx.databinding.ObservableField
import com.onix.internship.arch.BaseViewModel

class AddNoteModel: BaseViewModel() {
    val title:ObservableField<String> = ObservableField<String>()
    val description :ObservableField<String> = ObservableField<String>()
}