package kz.just_code.mvp_mvvm_homework.mvp

import kz.just_code.mvp_mvvm_homework.repository.Todo

sealed interface TaskScreen {
    interface View {
        fun showTask(task: String)
        fun showData(list: List<Todo>)
    }

    interface Presenter {
        fun getData()
        fun openDetails(todo: Todo)

    }

}