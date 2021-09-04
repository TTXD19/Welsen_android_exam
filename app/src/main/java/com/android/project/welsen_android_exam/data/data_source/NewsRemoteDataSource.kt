package com.android.project.welsen_android_exam.data.data_source

import com.android.project.welsen_android_exam.data.data_class.NewsDetailResp
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsRemoteDataSource(
    private val newsApiService: NewsApiService
): NewsDataSource {
    override fun getNews(country: String, key: String): Single<NewsDetailResp> {
        return newsApiService.getNews(country = country, key = key).subscribeOn(Schedulers.io())
    }
}