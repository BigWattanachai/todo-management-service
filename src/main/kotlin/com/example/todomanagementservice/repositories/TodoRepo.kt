package com.example.todomanagementservice.repositories

import com.example.todomanagementservice.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepo : JpaRepository<Todo, Long>
