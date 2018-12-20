package com.example.afeezawoyemi.githubusers.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GithubUsersResponse {
    List<GithubUsers> githubUsers;

    public GithubUsersResponse() {
        githubUsers = new ArrayList<GithubUsers>();
    }

    public List<GithubUsers> getGithubUsers() {
        return githubUsers;
    }
}