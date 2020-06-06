package com.superawesome.multiplatform

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.superawesome.sharedcode.MainViewModel
import com.superawesome.sharedcode.Todo
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @InjectMocks
    lateinit var target: MainViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        target = MainViewModel()
    }

    @Test
    fun `Test AddTodo(), add a todo, assert the result`() {
        // given
        val todoInput = "first Todo"
        val todos: MutableList<Todo> = mutableListOf()
        val todo = Todo(todoInput)
        todos.add(todo)

        // when
        target.addTodo(todoInput)

        // then
        assertEquals(todos, target.getMainLiveData.value)

    }

    @Test
    fun `Test DeleteTodo(), start with two todos, delete the second, assert the result`() {
        // given
        val todos: MutableList<Todo> = mutableListOf()
        val todoInput1 = "first todo"
        val todoInput2 = "second todo"
        val todo1 = Todo(todoInput1)
        todos.add(todo1)

        target.addTodo(todoInput1)
        target.addTodo(todoInput2)

        // when
        target.deleteTodo(1)

        // then
        assertEquals(todos, target.getMainLiveData.value)
        // required to reset the liveData to zero, investigate how to resolve this properly
        target.deleteTodo(0)
    }
}
