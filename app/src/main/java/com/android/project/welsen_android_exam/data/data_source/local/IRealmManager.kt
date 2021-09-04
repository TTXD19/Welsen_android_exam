package com.android.project.welsen_android_exam.data.data_source.local

import com.android.project.welsen_android_exam.data.data_class.local.NewsDetailRespRealm
import io.realm.RealmResults

interface IRealmManager {
    fun getNewsList(): RealmResults<NewsDetailRespRealm>
}