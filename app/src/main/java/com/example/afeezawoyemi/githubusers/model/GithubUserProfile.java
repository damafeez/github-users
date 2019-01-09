package com.example.afeezawoyemi.githubusers.model;

import com.google.gson.annotations.SerializedName;

public class GithubUserProfile {
    @SerializedName("login")
    String username;

    @SerializedName("avatar_url")
    String profileImage;

    String followers;

    String following;

    String bio;

    @SerializedName("public_repos")
    String publicRepos;

    public String getUsername() {
        return  username;
    }

    public String getProfileImage() {
        return profileImage;
    }
    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }

    public String getPublicRepos() {
        return publicRepos;
    }

    public String getBio() {
        return bio;
    }
}
