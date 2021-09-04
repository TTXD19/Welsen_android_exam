package com.android.project.welsen_android_exam.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.project.welsen_android_exam.data.data_class.NewsDetailResp
import com.android.project.welsen_android_exam.data.data_class.local.NewsDetailRespRealm
import com.android.project.welsen_android_exam.data.repository.INewsRepository
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.realm.Realm

class MainActivityViewModel(
    private val newsRepository: INewsRepository
): ViewModel() {

    val data = MutableLiveData<NewsDetailResp>()

    fun getData(){
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
            data.postValue(newsResp)
        }
    }
}