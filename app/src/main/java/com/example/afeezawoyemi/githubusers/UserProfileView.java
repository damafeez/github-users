package com.example.afeezawoyemi.githubusers;

import com.example.afeezawoyemi.githubusers.model.GithubUserProfile;

public interface UserProfileView {
    void userProfileReady(GithubUserProfile githubUserProfile);
    void showErrorSnackBar();
    boolean isNetworkConnected();
    void showDialog();
    void hideDialog();
}
