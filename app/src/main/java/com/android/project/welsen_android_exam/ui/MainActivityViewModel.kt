package com.android.project.welsen_android_exam.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.project.welsen_android_exam.data.data_class.NewsDetailResp
import com.android.project.welsen_android_exam.data.data_class.local.NewsDetailRespRealm
import com.android.project.welsen_android_exam.data.data_source.local.IRealmManager
import com.android.project.welsen_android_exam.data.repository.INewsRepository
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.realm.Realm
import io.realm.RealmChangeListener

class MainActivityViewModel(
    private val newsRepository: INewsRepository,
    private val realmManager: IRealmManager
): ViewModel() {

    val data = MutableLiveData<List<NewsDetailRespRealm>>()

    fun fetchData(){
        newsRepository.getNewsData("us").subscribeBy {newsResp ->
            Realm.getDefaultInstance().use {
                it.executeTransaction { realm ->
                    for (data in newsResp.articles!!){
                        realm.insert(NewsDetailRespRealm().apply {
                            newsTitle = data.title
                            imageUrl = data.urlToImage
                        })
                    }
                }
            }
        }
    }

    fun getLocalData(){
        val results = realmManager.getNewsList()
        results.addChangeListener(RealmChangeListener {
            data.postValue(it)
        })
    }
}