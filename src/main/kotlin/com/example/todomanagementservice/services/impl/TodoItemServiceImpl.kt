package com.example.todomanagementservice.services.impl

import com.example.todomanagementservice.entities.TodoItem
import com.example.todomanagementservice.exceptions.NotFoundException
import com.example.todomanagementservice.repositories.TodoItemRepo
import com.example.todomanagementservice.repositories.TodoRepo
import com.example.todomanagementservice.services.TodoItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoItemServiceImpl @Autowired constructor(val todoRepo: TodoRepo,
                                                 val todoItemRepo: TodoItemRepo) : TodoItemService {
    override fun createTodoItem(todoId: Long, todoItem: TodoItem): TodoItem {
        val todo = todoRepo.findOne(todoId) ?: throw NotFoundException("No Todo with id $todoId")
        todoItem.todo = todo
        return todoItemRepo.saveAndFlush(todoItem)
    }

    override fun updateTodoItem(id: Long, todoItem: TodoItem): TodoItem {
        val result = todoItemRepo.findOne(id) ?: throw NotFoundException("No TodoItem with id $id")
        result.content = todoItem.content
        result.complete = todoItem.complete
        return todoItemRepo.saveAndFlush(result)
    }

    override fun deleteTodoItem(id: Long): TodoItem {
        val result = todoItemRepo.findOne(id) ?: throw NotFoundException("No TodoItem with id $id")
        todoItemRepo.delete(result)
        return result
    }
}
