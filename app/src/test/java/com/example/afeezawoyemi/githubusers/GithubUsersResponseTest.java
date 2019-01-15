package com.example.afeezawoyemi.githubusers;

import com.example.afeezawoyemi.githubusers.model.GithubUser;
import com.example.afeezawoyemi.githubusers.model.GithubUsersResponse;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GithubUsersResponseTest {
    private GithubUsersResponse githubUsersResponse = new GithubUsersResponse();

    @Test
    public void githubUserIsReturned() {
        assertEquals(new ArrayList<GithubUser>(), githubUsersResponse.getGithubUsers());
    }
}
