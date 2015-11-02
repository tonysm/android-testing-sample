package com.example.tony.todoapp.entities;

import com.orm.SugarRecord;

public class Todo extends SugarRecord<Todo> {
    private String name;
    private String description;

    public Todo() {
    }

    public Todo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return name;
    }
}
