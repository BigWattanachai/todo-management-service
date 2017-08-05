package com.example.todomanagementservice.repositories

import com.example.todomanagementservice.entities.TodoItem
import org.springframework.data.jpa.repository.JpaRepository

interface TodoItemRepo : JpaRepository<TodoItem, Long>
