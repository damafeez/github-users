package com.example.afeezawoyemi.githubusers.services;

import com.example.afeezawoyemi.githubusers.model.GithubUserProfile;
import com.example.afeezawoyemi.githubusers.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GihubAPI {
    @GET("search/users?q=language:java+location:nairobi&per_page=40&sort=followers")
    Call<GithubUsersResponse> getUsers();

    @GET("/users/{username}")
    Call<GithubUserProfile> getUserProfile(@Path("username") String username, @Query("client_id") String clientId, @Query("client_secret") String clientSecret);
}
