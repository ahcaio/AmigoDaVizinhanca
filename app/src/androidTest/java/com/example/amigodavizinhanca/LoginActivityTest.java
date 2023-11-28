package com.example.amigodavizinhanca;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testaLoginBemSucedido() {
        // Enter correct username and password
        Espresso.onView(ViewMatchers.withId(R.id.edtTextEmailAddress))
                .perform(ViewActions.typeText("admin"));
        Espresso.onView(ViewMatchers.withId(R.id.edtTextPassword))
                .perform(ViewActions.typeText("admin123"));

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.btnLogin))
                .perform(ViewActions.click());

        // Check if the login success message is displayed
        Espresso.onView(ViewMatchers.withText("Login realizado com sucesso"))
                .inRoot(RootMatchers.isDialog())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testaLoginComUsuarioCorretoESenhaIncorreta() {
        // Enter correct username and password
        Espresso.onView(ViewMatchers.withId(R.id.edtTextEmailAddress))
                .perform(ViewActions.typeText("admin"));
        Espresso.onView(ViewMatchers.withId(R.id.edtTextPassword))
                .perform(ViewActions.typeText("admin"));

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.btnLogin))
                .perform(ViewActions.click());

        // Check if the login success message is displayed
        Espresso.onView(ViewMatchers.withText("A senha está incorreta. Favor tentar novamente."))
                .inRoot(RootMatchers.isDialog())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testaLoginComUsuarioIncorretoESenhaCorreta() {
        // Enter correct username and password
        Espresso.onView(ViewMatchers.withId(R.id.edtTextEmailAddress))
                .perform(ViewActions.typeText("adminn"));
        Espresso.onView(ViewMatchers.withId(R.id.edtTextPassword))
                .perform(ViewActions.typeText("admin123"));

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.btnLogin))
                .perform(ViewActions.click());

        // Check if the login success message is displayed
        Espresso.onView(ViewMatchers.withText("O usuário está incorreto. Favor tentar novamente com outro usuário."))
                .inRoot(RootMatchers.isDialog())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testaLoginComUsuarioESenhaIncorreta() {
        // Enter correct username and password
        Espresso.onView(ViewMatchers.withId(R.id.edtTextEmailAddress))
                .perform(ViewActions.typeText("adminN"));
        Espresso.onView(ViewMatchers.withId(R.id.edtTextPassword))
                .perform(ViewActions.typeText("admin"));

        // Click the login button
        Espresso.onView(ViewMatchers.withId(R.id.btnLogin))
                .perform(ViewActions.click());

        // Check if the login success message is displayed
        Espresso.onView(ViewMatchers.withText("A senha e o usuário estão incorretos. Favor tentar novamente."))
                .inRoot(RootMatchers.isDialog())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
