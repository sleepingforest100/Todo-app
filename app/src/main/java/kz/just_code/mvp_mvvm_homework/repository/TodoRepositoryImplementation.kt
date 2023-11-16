package kz.just_code.mvp_mvvm_homework.repository

import kz.just_code.mvp_mvvm_homework.R

class TodoRepositoryImplementation : TodoRepository {
    private var todoList: List<Todo> = listOf()
    override fun getTodoLIst(): List<Todo> {
        return if (todoList.isEmpty()) getRemoteTodo()
        else todoList
    }

    private fun getRemoteTodo(): List<Todo> {
        val list: MutableList<Todo> = mutableListOf(
            Todo(0, R.string.title_1, R.string.description_1),
           Todo(1, R.string.title_2, R.string.description_2)
        )
        todoList = list
        return list
    }
}