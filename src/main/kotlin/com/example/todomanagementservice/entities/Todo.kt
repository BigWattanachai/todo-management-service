package com.example.todomanagementservice.entities

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "todo")
class Todo(
        @Id @GeneratedValue val id: Long? = null,
        var title: String? = null,
        @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.REMOVE), orphanRemoval = true)
        var todoItems: List<TodoItem>? = emptyList()) {
    override fun toString(): String {
        return "Todo(id=$id, title=$title, todoItems=$todoItems)"
    }
}
