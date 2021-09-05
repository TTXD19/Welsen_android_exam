package com.android.project.welsen_android_exam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.project.welsen_android_exam.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mainActivityViewModel: MainActivityViewModel by viewModel()

    private val mainActivityAdapter by lazy { MainActivityAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvNews.adapter = mainActivityAdapter

        mainActivityViewModel.fetchData()
        mainActivityViewModel.getLocalData()
        mainActivityViewModel.data.observe(this){ mainActivityAdapter.updateDataList(it) }
    }
}