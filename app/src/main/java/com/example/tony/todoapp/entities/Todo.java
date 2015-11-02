package com.example.tony.todoapp.entities;

public class Todo {
    private Integer id;
    private String name;
    private String description;

    public Todo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Todo(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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
