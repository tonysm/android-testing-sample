package com.example.tony.todoapp.usecases;

import com.example.tony.todoapp.db.TodoRepository;
import com.example.tony.todoapp.entities.Todo;

public class AddTodo {

    private TodoRepository repository;

    public AddTodo(TodoRepository repository) {
        this.repository = repository;
    }
    
    public Todo handle(String name, String description) {
        Todo todo = new Todo(name, description);

        repository.add(todo);

        return todo;
    }
}
