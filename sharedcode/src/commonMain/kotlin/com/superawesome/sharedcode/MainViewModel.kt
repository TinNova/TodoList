package com.superawesome.sharedcode

import com.superawesome.sharedcode.di.KodeinInjector
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.kodein.di.erased.instance

class MainViewModel : ViewModel() {

    private val todoRepo by KodeinInjector.instance<TodoRepository>()

    var getMainLiveData = MutableLiveData(todoRepo.getTodos())

    fun addTodo(todoEntry: String) {
        todoRepo.addTodo(todoEntry)
        getMainLiveData.postValue(todoRepo.getTodos())
    }

    fun deleteTodo(todoIndex: Int) {
        todoRepo.deleteTodo(todoIndex)
        getMainLiveData.postValue(todoRepo.getTodos())
    }
}
