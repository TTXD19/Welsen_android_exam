package com.android.project.welsen_android_exam.data.data_class.local

import io.realm.RealmObject

open class NewsDetailRespRealm: RealmObject() {
    var newsTitle: String? = null
    var imageUrl: String? = null
}