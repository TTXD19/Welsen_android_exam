package com.android.project.welsen_android_exam.data.repository

import com.android.project.welsen_android_exam.data.data_class.NewsDetailResp
import io.reactivex.rxjava3.core.Single

interface INewsRepository {

    fun getNewsData(
        country: String
    ): Single<NewsDetailResp>

}