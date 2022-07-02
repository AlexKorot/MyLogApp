package com.onix.internship.ui.translate

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel

 enum class ChoiceLang(val value: Boolean) {UKR(true) ,POL(false)}

    class TranslateViewModel(private val slovnikAllWordList:Slovnik): BaseViewModel() {

     var listWord = ArrayList<String>()

        private  val _choiceLanguage=MutableLiveData<Boolean>(ChoiceLang.UKR.value)
    val choiceLanguage: LiveData<Boolean> = _choiceLanguage
        private val _languageOne=MutableLiveData<String>("Ukrainian")
    val languageOne:LiveData<String> = _languageOne


    private val _languageTwo=MutableLiveData<String>("Polish")
    val languageTwo:LiveData<String> =_languageTwo

    private val _error = MutableLiveData<String>()
        val error : LiveData<String> = _error

      fun changeLanguage(){

          if(choiceLanguage.value == ChoiceLang.UKR.value)
           { _languageOne.value ="Polish"
            _languageTwo.value ="Ukrainian"
               _choiceLanguage.value=ChoiceLang.POL.value
       }

           else{ _languageOne.value="Ukrainian"
                _languageTwo.value="Polish"
              _choiceLanguage.value=ChoiceLang.UKR.value
        }
    }
        fun wordTranslate(word: String){
   if(word.isBlank()||word.isEmpty()) _error.value="field must fill"
            else {
            _error.value=""

          listWord.add(slovnikAllWordList.getRandomWord())
       listWord.add(word)
       Log.d("myLog","$listWord" )
            }
        }



}