package com.android.project.welsen_android_exam.di.module

import com.android.project.welsen_android_exam.data.data_source.NewsApiService
import com.android.project.welsen_android_exam.data.data_source.NewsDataSource
import com.android.project.welsen_android_exam.data.data_source.NewsRemoteDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {
    single { provideUserInfoRemoteDataSource(get()) } bind NewsDataSource::class
}

fun provideUserInfoRemoteDataSource(
    newsApiService: NewsApiService
): NewsRemoteDataSource{
    return NewsRemoteDataSource(newsApiService)
}