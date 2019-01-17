package com.example.afeezawoyemi.githubusers;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class DetailActivityTest {
    private String TAG = "DetailActivityTest";
    @Rule
    public ActivityTestRule<DetailActivity> mDetailActivityTestRule = new ActivityTestRule<DetailActivity>(DetailActivity.class, false, false);

    @Before
    public void launch() throws Exception {
        Intent intent = new Intent();
        intent.putExtra("username", "TheDancerCodes");
        mDetailActivityTestRule.launchActivity(intent);
        sleep(8000);
    }

    @Test
    public void testDetailLayoutIsDisplayed () {
        onView(withId(R.id.detail_layout)).check(matches(isDisplayed()));
    }

    @Test
    public void testShareButtonClick() {
        onView(withId(R.id.share_button)).perform(click());
    }

    @Test
    public void testRestoreOnScreenOrientationChange() {
        mDetailActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        sleep(1000);
        mDetailActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);

    }

    public void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            Log.e(TAG, "Thread Error: " + e.getMessage());
        }
    }
}
