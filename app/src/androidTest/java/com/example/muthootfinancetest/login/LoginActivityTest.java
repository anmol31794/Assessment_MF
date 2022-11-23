package com.example.muthootfinancetest.login;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.muthootfinancetest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void loginClickWithRightData() {
        String email = "test1@gmail.com";
        String password = "Passw0rd!";
        onView(ViewMatchers.withId(R.id.etEmail)).perform(ViewActions.typeText(email));
        onView(withId(R.id.etPassword)).perform(ViewActions.typeText(password));
        closeSoftKeyboard();
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.tvEmail)).check(matches(isDisplayed()));
    }

    @Test
    public void loginClickWithWrongEmail() {
        String email = "test1gmail.com";
        String password = "Passw0rd!";
        onView(ViewMatchers.withId(R.id.etEmail)).perform(ViewActions.typeText(email));
        onView(withId(R.id.etPassword)).perform(ViewActions.typeText(password));
        closeSoftKeyboard();
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.etEmail)).check(matches(hasErrorText("Please enter a valid email")));
    }

    @Test
    public void loginClickWithWrongPassword() {
        String email = "test1@gmail.com";
        String password = "Passw0rd";
        onView(ViewMatchers.withId(R.id.etEmail)).perform(ViewActions.typeText(email));
        onView(withId(R.id.etPassword)).perform(ViewActions.typeText(password));
        closeSoftKeyboard();
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.etPassword)).check(matches(hasErrorText("Please enter a valid password")));
    }

    @Test
    public void checkFieldsVisibleOnLogin() {
        onView(withId(R.id.etEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.etPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));
    }
}
