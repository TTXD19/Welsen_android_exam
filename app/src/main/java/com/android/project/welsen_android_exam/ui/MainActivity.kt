package com.android.project.welsen_android_exam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.project.welsen_android_exam.R
import com.android.project.welsen_android_exam.data.data_class.local.NewsDetailRespRealm
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmResults
import io.realm.kotlin.where
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModel()
    private lateinit var realm: Realm
    private lateinit var results: RealmResults<NewsDetailRespRealm>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel.getData()
//        mainActivityViewModel.data.observe(this){
//            Log.d("testData", it.articles?.get(0)?.description ?: "empty")
//        }

        realm = Realm.getDefaultInstance()
        results = realm.where<NewsDetailRespRealm>().findAllAsync()

        results.addChangeListener(RealmChangeListener {
            Log.d("testData", it.toString())
            for (data in it){
                data?.also { newsDetail ->
                    Log.d("testData", newsDetail.newsTitle ?: "empty")
                }
            }
        })
    }
}