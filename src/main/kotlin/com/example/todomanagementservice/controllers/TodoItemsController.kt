package com.example.todomanagementservice.controllers

import com.example.todomanagementservice.entities.TodoItem
import com.example.todomanagementservice.services.TodoItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/todos")
class TodoItemsController @Autowired constructor(val todoItemService: TodoItemService) {
    @PostMapping("/{todoId}/items")
    fun createTodoItem(@PathVariable(name = "todoId") todoId: Long, @RequestBody todoItem: TodoItem): TodoItem {
        return todoItemService.createTodoItem(todoId, todoItem)
    }

    @PutMapping("/items/{id}")
    fun updateTodoItem(@PathVariable id: Long, @RequestBody todoItem: TodoItem): TodoItem {
        return todoItemService.updateTodoItem(id, todoItem)
    }

    @DeleteMapping("/items/{id}")
    fun deleteTodoItem(@PathVariable id: Long): TodoItem {
        return todoItemService.deleteTodoItem(id)
    }
}
