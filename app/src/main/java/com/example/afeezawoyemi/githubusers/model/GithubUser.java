package com.example.afeezawoyemi.githubusers.model;

import com.google.gson.annotations.SerializedName;

public class GithubUser {
    @SerializedName("login")
    String username;

    @SerializedName("avatar_url")
    String profileImage;

    public String getUsername() {
        return  username;
    }

    public String getProfileImage() {
        return profileImage;
    }
}