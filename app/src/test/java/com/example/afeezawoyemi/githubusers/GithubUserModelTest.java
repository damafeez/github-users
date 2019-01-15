package com.example.afeezawoyemi.githubusers;

import com.example.afeezawoyemi.githubusers.model.GithubUser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GithubUserModelTest {
    private String username = "damafeez";
    private String profileImage = "http://randomImageUrl.png";
    private GithubUser githubUser = new GithubUser(username, profileImage);

    @Test
    public void usernameIsReturned() {
        assertEquals(username, githubUser.getUsername());
    }

    @Test
    public void profileImageIsReturned() {
        assertEquals(profileImage, githubUser.getProfileImage());
    }

    @Test
    public void describeContentsReturnsZero() {
        assertEquals(0, githubUser.describeContents());
    }

}