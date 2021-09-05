package com.android.project.welsen_android_exam.data.data_class.local

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NewsDetailRespRealm: RealmObject() {
    @PrimaryKey
    var time: String? = null
    var newsTitle: String? = null
    var imageUrl: String? = null
}