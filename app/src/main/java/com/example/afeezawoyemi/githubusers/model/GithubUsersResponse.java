package com.example.afeezawoyemi.githubusers.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GithubUsersResponse {
    @SerializedName("items")
    @Expose
    List<GithubUser> githubUsers;
    public GithubUsersResponse() {
        githubUsers = new ArrayList<GithubUser>();
    }

    public List<GithubUser> getGithubUsers() {
        return githubUsers;
    }
}