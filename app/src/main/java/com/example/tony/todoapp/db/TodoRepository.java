package com.example.tony.todoapp.db;

import com.example.tony.todoapp.entities.Todo;
import java.util.List;

public class TodoRepository {

    public void add(Todo todo) {
        todo.save();
    }

    public List<Todo> getAll() {
        return Todo.listAll(Todo.class);
    }

    public void clearAll() {
        Todo.deleteAll(Todo.class);
    }
}
