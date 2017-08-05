package com.example.todomanagementservice.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "todo_item")
class TodoItem(
        @Id @GeneratedValue val id: Long? = null,
        var content: String? = null,
        var complete: String? = null,
        @ManyToOne
        @JoinColumn(name = "todo_id")
        @JsonIgnore
        var todo: Todo? = null) {
    override fun toString(): String {
        return "TodoItem(id=$id, content=$content, complete=$complete, todo=$todo)"
    }
}
