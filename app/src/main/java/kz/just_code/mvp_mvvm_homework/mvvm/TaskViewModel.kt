package kz.just_code.mvp_mvvm_homework.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.just_code.mvp_mvvm_homework.repository.Todo
import kz.just_code.mvp_mvvm_homework.repository.TodoRepository

class FaqViewModel(
    private var repository: TodoRepository
) : ViewModel() {
    private var _todoListLiveData = MutableLiveData<List<Todo>>()
    var todoListLiveData: LiveData<List<Todo>> = _todoListLiveData

    init {
        getData()
    }

    private fun getData() {
        val data = repository.getTodoLIst()
        _todoListLiveData.postValue(data)
    }
}