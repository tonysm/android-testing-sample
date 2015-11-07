package com.example.tony.todoapp;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import org.junit.Test;

public class AddNewTodoActivityTest extends ActivityInstrumentationTestCase2<AddNewTodoActivity> {
    private AddNewTodoActivity mActivity;
    private TextView nameLabel;

    public AddNewTodoActivityTest() {
        super(AddNewTodoActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
        nameLabel = (TextView) mActivity.findViewById(R.id.name_label);
    }

    @Test
    public void testLabelsText() {
        String expectedNameLabel = mActivity.getString(R.string.item_name_input);
        String actualNameLabel = nameLabel.getText().toString();

        assertEquals(expectedNameLabel, actualNameLabel);
    }
}
