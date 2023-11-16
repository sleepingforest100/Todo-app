package kz.just_code.mvp_mvvm_homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.mvp_mvvm_homework.databinding.ItemTodoBinding
import kz.just_code.mvp_mvvm_homework.repository.Todo

class TodoAdapter : ListAdapter<Todo, TodoAdapter.FaqViewHolder>(FaqDiffUtils) {
    var click: ((Todo)->Unit)?=null

    object FaqDiffUtils : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }

    }

    inner class FaqViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Todo) {
            binding.todoTitle.text = itemView.context.getString(item.title)
            binding.todoSubtitle.text = itemView.context.getString(item.description)

            itemView.setOnClickListener {
                click?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        return FaqViewHolder(
            ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}