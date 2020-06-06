package com.superawesome.sharedcode.di

import com.superawesome.sharedcode.TodoRepository
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.singleton
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val KodeinInjector = Kodein {

    bind<TodoRepository>() with singleton { TodoRepository() }

}