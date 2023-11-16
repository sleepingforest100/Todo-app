package kz.just_code.mvp_mvvm_homework.mvp

import kz.just_code.mvp_mvvm_homework.repository.Todo
import kz.just_code.mvp_mvvm_homework.repository.TodoRepository
import kz.just_code.mvp_mvvm_homework.repository.TodoRepositoryImplementation

class TaskPresenter(
    private val view: TaskScreen.View
) : TaskScreen.Presenter {
    private val repository: TodoRepository = TodoRepositoryImplementation()

    init {
        getData()
    }

    override fun getData() {
        val data = repository.getTodoLIst()
        view.showData(data)
    }

    override fun openDetails(todo: Todo) {
        view.showTask(todo.description.toString())
    }

}