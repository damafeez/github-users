package com.example.afeezawoyemi.githubusers;

import com.example.afeezawoyemi.githubusers.model.GithubUserProfile;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GithubUserProfileModelTest {
    String username = "damafeez";
    String profileImage = "http://randomImageUrl.png";
    String followers = "33";
    String following = "44";
    String bio = "This is my bio";
    String publicRepos = "55";
    private GithubUserProfile githubUserProfile = new GithubUserProfile(
            username,
            profileImage,
            followers,
            following,
            bio,
            publicRepos
    );

    @Test
    public void usernameIsReturned() {
        assertEquals(username, githubUserProfile.getUsername());
    }

    @Test
    public void profileImageIsReturned() {
        assertEquals(profileImage, githubUserProfile.getProfileImage());
    }

    @Test
    public void followersIsReturned() {
        assertEquals(followers, githubUserProfile.getFollowers());
    }

    @Test
    public void followingIsReturned() {
        assertEquals(following, githubUserProfile.getFollowing());
    }

    @Test
    public void bioIsReturned() {
        assertEquals(bio, githubUserProfile.getBio());
    }

    @Test
    public void publicReposIsReturned() {
        assertEquals(publicRepos, githubUserProfile.getPublicRepos());
    }

    @Test
    public void describeContentsReturnsZero() {
        assertEquals(0, githubUserProfile.describeContents());
    }

}