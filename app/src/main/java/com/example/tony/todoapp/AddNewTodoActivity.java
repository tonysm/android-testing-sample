package com.example.tony.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tony.todoapp.db.TodoRepository;
import com.example.tony.todoapp.entities.Todo;
import com.example.tony.todoapp.usecases.AddTodo;

public class AddNewTodoActivity extends AppCompatActivity {

    EditText nameField;
    EditText descriptionField;
    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_todo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        saveButton = (Button) findViewById(R.id.save);
        cancelButton = (Button) findViewById(R.id.cancel);
        nameField = (EditText) findViewById(R.id.name);
        descriptionField = (EditText) findViewById(R.id.description);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast
                    .makeText(getApplicationContext(), "Saving...", Toast.LENGTH_SHORT)
                    .show();

                AddTodo handler = new AddTodo(new TodoRepository());
                handler.handle(nameField.getText().toString(), descriptionField.getText().toString());

                redirectToTodoIndex();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToTodoIndex();
            }
        });
    }

    public void redirectToTodoIndex() {
        finish();
    }

}
