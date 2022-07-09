package com.onix.internship.di

import com.onix.internship.data.repository.*
import com.onix.internship.novel.DialogString
import org.koin.core.scope.get
import org.koin.dsl.module

val repositoryModule = module {
    single { PreferenceStorage(get()) }
    single {DialogString ()}
}