package com.android.project.welsen_android_exam.data.repository

import com.android.project.welsen_android_exam.BuildConfig
import com.android.project.welsen_android_exam.data.data_class.NewsDetailResp
import com.android.project.welsen_android_exam.data.data_source.NewsDataSource
import io.reactivex.rxjava3.core.Single

class NewsRepository(
    private val newsDataSource: NewsDataSource
): INewsRepository {
    override fun getNewsData(country: String): Single<NewsDetailResp> {
        return newsDataSource.getNews(country = country, key = BuildConfig.API_KEY)
    }
}