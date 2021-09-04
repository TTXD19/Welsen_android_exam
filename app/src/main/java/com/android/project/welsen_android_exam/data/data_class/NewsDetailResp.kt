package com.android.project.welsen_android_exam.data.data_class


import com.google.gson.annotations.SerializedName

data class NewsDetailResp(
    val articles: List<Article>? = null,
    val status: String? = null,
    val totalResults: Int? = null
)