package com.example.androidassignments;

import junit.framework.TestCase;

public class ChatWindowTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testOnCreate() {
        assertTrue(ChatWindow.class.getName().compareTo("com.example.androidassignments.ChatWindow") == 0);
    }
}