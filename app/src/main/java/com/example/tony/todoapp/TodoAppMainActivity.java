package com.example.tony.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tony.todoapp.db.TodoRepository;
import com.example.tony.todoapp.entities.Todo;

import java.util.List;

public class TodoAppMainActivity extends AppCompatActivity {

    private ListView tasksList;
    private ArrayAdapter<Todo> listAdapter;
    private TodoRepository repository;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_app_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        repository = new TodoRepository();

        List<Todo> todos = repository.getAll();
        listAdapter = new ArrayAdapter<Todo>(
            TodoAppMainActivity.this,
            android.R.layout.simple_list_item_1,
            todos
        );

        tasksList = (ListView) findViewById(R.id.tasksList);
        tasksList.setAdapter(listAdapter);

        tasksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Todo selected = listAdapter.getItem(position);
                Toast.makeText(TodoAppMainActivity.this, "Clicked: " + selected.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TodoAppMainActivity.this, AddNewTodoActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todo_app_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear) {
            repository.clearAll();
            listAdapter.clear();
            tasksList.invalidateViews();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
