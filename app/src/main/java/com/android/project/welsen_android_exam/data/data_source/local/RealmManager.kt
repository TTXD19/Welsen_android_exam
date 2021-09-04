package com.android.project.welsen_android_exam.data.data_source.local

import com.android.project.welsen_android_exam.data.data_class.local.NewsDetailRespRealm
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where

open class RealmManager(
    val realm: Realm
): IRealmManager {

    override fun getNewsList(): RealmResults<NewsDetailRespRealm> {
        return realm.where<NewsDetailRespRealm>().findAllAsync()
    }
}