package com.example.tony.todoapp.usecases;

import com.example.tony.todoapp.db.TodoRepository;
import com.example.tony.todoapp.entities.Todo;
import com.example.tony.todoapp.usecases.AddTodo;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class AddTodoTest {
    
    @Test
    public void addsTodo() {
        TodoRepository repository = mock(TodoRepository.class);
        AddTodo handler = new AddTodo(repository);

        Todo todo = handler.handle("New todo", "New description");

        verify(repository).add(todo);
    }
}
