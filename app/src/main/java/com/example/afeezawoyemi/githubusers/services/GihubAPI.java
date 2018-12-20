package com.example.afeezawoyemi.githubusers.services;

import com.example.afeezawoyemi.githubusers.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GihubAPI {
    @GET("search/users?q=language:java+location:nairobi&per_page=40&sort=followers")
    Call<GithubUsersResponse> getUsers();
}
