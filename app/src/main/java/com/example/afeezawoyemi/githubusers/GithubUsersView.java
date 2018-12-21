package com.example.afeezawoyemi.githubusers;

import com.example.afeezawoyemi.githubusers.model.GithubUsers;

import java.util.List;

public interface GithubUsersView {
    void githubUsersReady(List<GithubUsers> usersList);
}
