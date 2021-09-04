package com.android.project.welsen_android_exam.di.module

import com.android.project.welsen_android_exam.data.repository.INewsRepository
import com.android.project.welsen_android_exam.data.repository.NewsRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    single { NewsRepository(get()) } bind INewsRepository::class
}