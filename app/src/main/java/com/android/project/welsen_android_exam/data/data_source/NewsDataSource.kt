package com.android.project.welsen_android_exam.data.data_source

import com.android.project.welsen_android_exam.BuildConfig
import com.android.project.welsen_android_exam.data.data_class.NewsDetailResp
import io.reactivex.rxjava3.core.Single

interface NewsDataSource {

    fun getNews(
        country: String,
        key: String
    ): Single<NewsDetailResp>
}