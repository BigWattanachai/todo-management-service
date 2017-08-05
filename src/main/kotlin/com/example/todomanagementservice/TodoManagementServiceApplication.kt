package com.example.todomanagementservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TodoManagementServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(TodoManagementServiceApplication::class.java, *args)
}
