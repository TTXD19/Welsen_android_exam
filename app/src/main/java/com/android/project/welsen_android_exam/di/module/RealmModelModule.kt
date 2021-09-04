package com.android.project.welsen_android_exam.di.module

import com.android.project.welsen_android_exam.data.data_source.local.IRealmManager
import com.android.project.welsen_android_exam.data.data_source.local.RealmManager
import io.realm.Realm
import org.koin.dsl.bind
import org.koin.dsl.module

val realmModelModule = module {
    single { RealmManager(getRealmInstance()) } bind IRealmManager::class
}

fun getRealmInstance(): Realm{
    return Realm.getDefaultInstance()
}