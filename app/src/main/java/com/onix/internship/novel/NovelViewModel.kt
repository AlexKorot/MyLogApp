package com.onix.internship.novel

import android.media.MediaPlayer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.R
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.provider.TextResProvider
import kotlinx.coroutines.delay

class NovelViewModel(private val dialogString: DialogString):BaseViewModel() {

    val dialogStringLect = dialogString.dialogsSceneLectureHall
    val dialogStringUni=dialogString.dialogSceneUni


    private val _dialogTextLecture = MutableLiveData("")
    val dialogTextLecture: LiveData<String>
        get() = _dialogTextLecture
    private val _dialogTextUni = MutableLiveData("")
    val dialogTextUni: LiveData<String>
        get() = _dialogTextUni
    //private val _visibSilv = MutableLiveData(false)
    val visibSilv : Boolean = true
      //  get() = _visibSilv

    init {
        getDialogText(dialogStringLect,_dialogTextLecture)
        getDialogText(dialogStringUni,_dialogTextUni)
    }

    private fun getDialogText(dialogString: List<String> ,dialogText:MutableLiveData<String>) {
        for (i in dialogString.indices) {
            launch {
                delay(((i + 1) * Const.DELAY_TEXT).toLong())
                dialogText.value = dialogString[i]

            }
        }
    }

}






