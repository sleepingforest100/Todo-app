package kz.just_code.mvp_mvvm_homework.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.mvp_mvvm_homework.TodoAdapter
import kz.just_code.mvp_mvvm_homework.databinding.TodoFragmentBinding
import kz.just_code.mvp_mvvm_homework.repository.TodoRepositoryImplementation

class TaskMvvmFragment : Fragment(){
    private lateinit var binding: TodoFragmentBinding
    private val adapter: TodoAdapter = TodoAdapter()
    private val viewModel: FaqViewModel = FaqViewModel(TodoRepositoryImplementation())
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

        binding.todoList.layoutManager = LinearLayoutManager(requireContext())
        binding.todoList.adapter = adapter

        adapter.click = {
//            findNavController().navigate()
        }

        viewModel.todoListLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }

}