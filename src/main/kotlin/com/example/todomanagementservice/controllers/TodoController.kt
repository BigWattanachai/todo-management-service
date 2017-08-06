package com.example.todomanagementservice.controllers

import com.example.todomanagementservice.entities.Todo
import com.example.todomanagementservice.services.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/todos")
class TodoController @Autowired constructor(val todoService: TodoService) {
    @PostMapping
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        return ResponseEntity(todoService.createTodo(todo), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getTodo(@PathVariable id: Long): Todo {
        return todoService.getTodo(id)
    }

    @GetMapping
    fun getAllTodo(): List<Todo> {
        return todoService.getTodoList()
    }

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody todo: Todo): Todo {
        return todoService.updateTodo(id, todo)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): Todo {
        return todoService.deleteTodo(id)
    }
}
