package com.example.afeezawoyemi.githubusers;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private String TAG = "DetailActivityTest";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        sleep(3000);
    }

    @Test
    public void testMainLayoutIsDisplayed () {
        onView(withId(R.id.main_layout)).check(matches(isDisplayed()));
    }


    @Test
    public void recyclerViewIsDisplayed() {
        onView(withId(R.id.rv_users)).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerViewClick() {
        onView(withId(R.id.rv_users)).perform(RecyclerViewActions.scrollToPosition(4));
        onView(withId(R.id.rv_users)).perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));
    }

    @Test
    public void testSwipeRefresh() {
        onView(withId(R.id.main_layout)).perform(ViewActions.swipeDown());
    }

    @Test
    public void testRestoreOnScreenOrientationChange() {
        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        sleep(1000);
        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);

    }

    public void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            Log.e(TAG, "Thread Error: " + e.getMessage());
        }
    }
}