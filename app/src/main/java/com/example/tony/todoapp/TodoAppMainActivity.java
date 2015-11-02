package com.example.tony.todoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tony.todoapp.db.TodoRepository;
import com.example.tony.todoapp.entities.Todo;

import java.util.List;

public class TodoAppMainActivity extends AppCompatActivity {

    private ListView tasksList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_app_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TodoRepository repository = TodoRepository.getInstance();

        List<Todo> todos = repository.getAll();
        ArrayAdapter<Todo> todosAdapter = new ArrayAdapter<Todo>(this, android.R.layout.simple_list_item_1, todos);
        tasksList = (ListView) findViewById(R.id.tasksList);
        tasksList.setAdapter(todosAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TodoRepository.getInstance().add(new Todo("New one", "descriptin lorem"));
                tasksList.invalidateViews();
                Snackbar.make(view, "Added with success", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
            TodoRepository.getInstance().clearAll();
            tasksList.invalidateViews();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
