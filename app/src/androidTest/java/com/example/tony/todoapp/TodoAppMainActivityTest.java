package com.example.tony.todoapp;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

public class TodoAppMainActivityTest extends ActivityInstrumentationTestCase2<TodoAppMainActivity> {
    private TodoAppMainActivity todoMainActivity;

    public TodoAppMainActivityTest() {
        super(TodoAppMainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        todoMainActivity = getActivity();
    }

    @Test
    public void testWorks() {
        assertTrue(true);
    }
}
