package com.example.androidassignments;

import junit.framework.TestCase;

public class LoginActivityTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testOnCreate() {
//        System.out.println(LoginActivity.class.getName());
        assertTrue(LoginActivity.class.getName().compareTo("com.example.androidassignments.LoginActivity") == 0);
    }
}