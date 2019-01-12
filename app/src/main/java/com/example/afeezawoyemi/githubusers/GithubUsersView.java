package com.example.afeezawoyemi.githubusers;

import com.example.afeezawoyemi.githubusers.model.GithubUser;

import java.util.List;

public interface GithubUsersView {
    void githubUsersReady(List<GithubUser> usersList);
    void showErrorSnackBar();
    void switchRefreshState(Boolean state);
    boolean isNetworkConnected();
}
