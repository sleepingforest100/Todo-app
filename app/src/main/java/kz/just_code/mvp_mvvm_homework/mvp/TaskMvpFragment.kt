package kz.just_code.mvp_mvvm_homework.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.mvp_mvvm_homework.TodoAdapter
import kz.just_code.mvp_mvvm_homework.databinding.TodoFragmentBinding
import kz.just_code.mvp_mvvm_homework.mvp.TaskPresenter
import kz.just_code.mvp_mvvm_homework.mvp.TaskScreen
import kz.just_code.mvp_mvvm_homework.repository.Todo

class TaskMvpFragment : Fragment(), TaskScreen.View {
    private lateinit var binding: TodoFragmentBinding
    private val adapter: TodoAdapter = TodoAdapter()
    private lateinit var presenter: TaskScreen.Presenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TodoFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = TaskPresenter(this)

        binding.todoList.layoutManager = LinearLayoutManager(requireContext())
        binding.todoList.adapter = adapter

        adapter.click = {
            presenter.openDetails(it)
//            findNavController().navigate()
        }

    }

    override fun showTask(task: String) {
        Toast.makeText(requireContext(), task, Toast.LENGTH_SHORT).show()
    }

    override fun showData(list: List<Todo>) {
        adapter.submitList(list)
    }
}