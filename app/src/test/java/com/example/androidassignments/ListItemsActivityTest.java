package com.example.androidassignments;

import android.app.Activity;

import junit.framework.TestCase;

public class ListItemsActivityTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testOnCreate() {
        assertTrue(ListItemsActivity.class.getName().compareTo("com.example.androidassignments.ListItemsActivity") == 0);
    }

    public void testOnActivityResult() {
        assertTrue(Activity.RESULT_OK == -1);
    }
}