package com.superawesome.multiplatform.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.superawesome.multiplatform.R
import com.superawesome.multiplatform.ui.MainAdapter.TodoViewHolder
import com.superawesome.sharedcode.Todo
import kotlinx.android.synthetic.main.item_todo.view.*

class MainAdapter(private val todoPositionListener: TodoClickListener) :
    RecyclerView.Adapter<TodoViewHolder>() {

    private var todos: List<Todo> = listOf()

    fun setData(data: List<Todo>) {
        todos = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder =
        TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = todos.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position], position, todoPositionListener)
    }


    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            todo: Todo,
            index: Int,
            todoPositionListener: TodoClickListener
        ) {
            itemView.item_todo_text_view.text = todo.todo
            itemView.setOnClickListener {
                todoPositionListener.onTodoClicked(index)
            }
        }
    }
}

