package com.android.project.welsen_android_exam.di.module

import com.android.project.welsen_android_exam.ui.MainActivityViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainActivityViewModel(get(), get()) }
}