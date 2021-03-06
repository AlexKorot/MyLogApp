package com.onix.internship.di


import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.splash.SplashViewModel
import com.onix.internship.ui.translate.Slovnik
import com.onix.internship.ui.translate.TranslateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
    viewModel{ TranslateViewModel(slovnikAllWordList = Slovnik())}


}