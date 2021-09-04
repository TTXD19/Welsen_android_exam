package com.android.project.welsen_android_exam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.project.welsen_android_exam.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel.fetchData()
        mainActivityViewModel.getLocalData()
        mainActivityViewModel.data.observe(this){
            Log.d("testData", it.size.toString())
        }
    }
}