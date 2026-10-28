
package com.example.androidassignments;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ListItemsActivityAndroidTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void TestAllFeatures(){
        GoToList();

        // test switch
        Espresso.onView(ViewMatchers.withId(R.id.switch1))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.switch1))
                .perform(click());

        // cancel exit
        Espresso.onView(ViewMatchers.withId(R.id.checkBox))
                .perform(click());
        Espresso.onView(ViewMatchers.withText(R.string.cancel))
                .perform(click());

        // reset and click again to exit
        Espresso.onView(ViewMatchers.withId(R.id.checkBox))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.checkBox))
                .perform(click());
        Espresso.onView(ViewMatchers.withText(R.string.ok))
                .perform(click());
    }

    @Test
    public void GoToList() {
        // Clear and enter the email
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(
                        ViewActions.typeText("test@gmail.com"),
                        ViewActions.closeSoftKeyboard()
                );

        // Clear and enter the password
        Espresso.onView(ViewMatchers.withId(R.id.LoginPasswordField))
                .perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.LoginPasswordField))
                .perform(
                        ViewActions.typeText("1234abcd"),
                        ViewActions.closeSoftKeyboard()
                );

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.LoginButton))
                .perform(click());

        Espresso.onView(ViewMatchers.withId(R.id.buttonIsMe))
                .perform(click());
    }
}
