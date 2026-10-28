
package com.example.androidassignments;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityAndroidTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void validEmailTest() {
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

        // Click the back button
        Espresso.pressBack();

        // Verify that the email field contains the expected text
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("test@gmail.com")
                ));
    }

    @Test
    public void invalidEmailTest() {
        // Clear and enter the email
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(
                        ViewActions.typeText("test@gmail"),
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
        Espresso.onView(ViewMatchers.withText(R.string.DialogCancel))
                .perform(click());


        // Verify that the email field contains the expected text
        // This works cuz looking for LoginNameField would make this
        // fail if it actually moved onto MainActivity
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("test@gmail")
                ));


        // Repeat
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(
                        ViewActions.typeText("test.com"),
                        ViewActions.closeSoftKeyboard()
                );
        Espresso.onView(ViewMatchers.withId(R.id.LoginButton))
                .perform(click());
        Espresso.onView(ViewMatchers.withText(R.string.DialogCancel))
                .perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("test.com")
                ));
    }

    @Test
    public void emptyFieldsTest() {
        // Clear email
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(ViewActions.clearText());

        // Clear password
        Espresso.onView(ViewMatchers.withId(R.id.LoginPasswordField))
                .perform(ViewActions.clearText());

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.LoginButton))
                .perform(click());
        Espresso.onView(ViewMatchers.withText(R.string.DialogCancel))
                .perform(click());

        // Verify that the email field contains the expected text
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("")
                ));

        // new email
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(
                        ViewActions.typeText("test@gmail.com"),
                        ViewActions.closeSoftKeyboard()
                );

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.LoginButton))
                .perform(click());
        Espresso.onView(ViewMatchers.withText(R.string.DialogCancel))
                .perform(click());

        // Verify that the email field contains the expected text
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("test@gmail.com")
                ));

        // new password
        Espresso.onView(ViewMatchers.withId(R.id.LoginPasswordField))
                .perform(
                        ViewActions.typeText("1234abcd"),
                        ViewActions.closeSoftKeyboard()
                );

        // remove email
        Espresso.onView(ViewMatchers.withId(R.id.LoginNameField))
                .perform(ViewActions.clearText());

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.LoginButton))
                .perform(click());
        Espresso.onView(ViewMatchers.withText(R.string.DialogCancel))
                .perform(click());

        // Verify that the password field contains the expected text
        Espresso.onView(ViewMatchers.withId(R.id.LoginPasswordField))
                .check(ViewAssertions.matches(
                        ViewMatchers.withText("1234abcd")
                ));
    }
}
