package com.android.project.welsen_android_exam.data.data_source

import com.android.project.welsen_android_exam.data.data_class.NewsDetailResp
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") key: String
    ): Single<NewsDetailResp>

}