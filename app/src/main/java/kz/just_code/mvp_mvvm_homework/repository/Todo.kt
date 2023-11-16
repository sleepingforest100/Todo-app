package kz.just_code.mvp_mvvm_homework.repository

import androidx.annotation.StringRes

data class Todo(
    val id: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int
)
