package com.superawesome.sharedcode

class TodoRepository {

    private var todos: MutableList<Todo> = mutableListOf()

    fun addTodo(todoEntry: String) {
        val todo = Todo(todoEntry)
        todos.add(todo)
    }

    fun deleteTodo(index: Int) {
        todos.removeAt(index)
    }

    fun getTodos(): List<Todo> = todos
}
