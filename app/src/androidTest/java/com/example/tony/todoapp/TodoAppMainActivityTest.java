package com.example.tony.todoapp;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.test.ActivityInstrumentationTestCase2;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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
    public void testAddsNewTodo() {
        onView(withId(R.id.fab))
                .perform(click());

        onView(withId(R.id.name))
                .perform(ViewActions.typeText("New todo"));

        onView(withId(R.id.description))
                .perform(ViewActions.typeText("New Description"));

        onView(withId(R.id.save))
                .perform(click());

        onView(withText("New todo"))
            .check(matches(isDisplayed()));
    }
}
