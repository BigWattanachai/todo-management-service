package com.example.todomanagementservice.services.impl

import com.example.todomanagementservice.entities.Todo
import com.example.todomanagementservice.exceptions.NotFoundException
import com.example.todomanagementservice.repositories.TodoRepo
import com.example.todomanagementservice.services.TodoService
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(val todoRepo: TodoRepo) : TodoService {
    override fun createTodo(todo: Todo): Todo {
        return todoRepo.saveAndFlush(todo)
    }

    override fun getTodo(id: Long): Todo {
        return todoRepo.findOne(id) ?: throw NotFoundException("No Todo with id $id")
    }

    override fun getTodoList(): List<Todo> {
        return todoRepo.findAll()
    }

    override fun updateTodo(id: Long, todo: Todo): Todo {
        val result = todoRepo.findOne(id) ?: throw NotFoundException("No Todo with id $id")
        result.title = todo.title
        return todoRepo.saveAndFlush(result)
    }

    override fun deleteTodo(id: Long): Todo {
        val result = todoRepo.findOne(id) ?: throw NotFoundException("No Todo with id $id")
        todoRepo.delete(result)
        return result
    }
}
