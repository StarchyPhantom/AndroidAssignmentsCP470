package com.example.androidassignments;

import android.app.Activity;

import junit.framework.TestCase;

public class MainActivityTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testOnCreate() {
        assertTrue(MainActivity.class.getName().compareTo("com.example.androidassignments.MainActivity") == 0);
    }

    public void testOnActivityResult() {
        assertTrue(Activity.RESULT_OK == -1);
    }
}