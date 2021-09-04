package com.android.project.welsen_android_exam.data.data_source.local

import io.realm.RealmObject

enum class TaskStatus(val displayName: String) {
    Open("Open"),
    InProgress("In Progress"),
    Complete("Complete"),
}