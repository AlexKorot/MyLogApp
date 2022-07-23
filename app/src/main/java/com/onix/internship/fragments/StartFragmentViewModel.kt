package com.onix.internship.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.fragments.model.UserModel

class StartFragmentViewModel(user:UserModel):BaseViewModel() {

   // lateinit var  user:UserModel
   val stateSwitch =MutableLiveData<Boolean>()
    val level=MutableLiveData<String>("1")
  //  init {
    //    user.level= level.value?.toInt()!!
   // }

    val enebleButton :LiveData<Boolean> = Transformations.map(stateSwitch)
    {
        it == true
    }


    fun onValueChanged(value: Float) {
        level.value=value.toInt().toString()
    }


 }


