package com.example.amigodavizinhanca;

import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Test;

public class LoginActivityTest {

    @Test
    void testaLoginBemSucedido() {
        // Enter correct username and password
        Espresso.onView(ViewMatchers.withId(R.id.usernameEditText))
                .perform(ViewActions.typeText("admin"))
        Espresso.onView(ViewMatchers.withId(R.id.passwordEditText))
                .perform(ViewActions.typeText("password"))

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
                .perform(ViewActions.click())

        // Check if the login success message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
                .check(ViewAssertions.matches(withText("Login successful")))
    }

}
