package com.onix.internship.di


import com.onix.internship.novel.NovelViewModel
import com.onix.internship.ui.main.MainViewModel
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
      viewModel{ NovelViewModel(get()) }

}