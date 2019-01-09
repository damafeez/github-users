package com.example.afeezawoyemi.githubusers.model;

import com.google.gson.annotations.SerializedName;

public class GithubUser {
    @SerializedName("login")
    String username;

    @SerializedName("avatar_url")
    String profileImage;

    String url;

    public String getUsername() {
        return  username;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getUrl() {
        return url;
    }
}
