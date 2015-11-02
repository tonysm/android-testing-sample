package com.example.tony.todoapp.db;

import com.example.tony.todoapp.entities.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private List<Todo> todos = new ArrayList<>();
    private static TodoRepository instance;

    private TodoRepository() {
    }

    public static TodoRepository getInstance() {
        if (instance == null) {
            instance = new TodoRepository();
            instance.add(new Todo("First", "description 1"));
            instance.add(new Todo("Second", "description 2"));
        }

        return instance;
    }

    public void add(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getAll() {
        return todos;
    }

    public void clearAll() {
        todos.clear();
    }
}
