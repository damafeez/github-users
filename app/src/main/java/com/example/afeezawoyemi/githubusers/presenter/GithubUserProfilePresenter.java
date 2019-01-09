package com.example.afeezawoyemi.githubusers.presenter;


import com.example.afeezawoyemi.githubusers.UserProfileView;
import com.example.afeezawoyemi.githubusers.model.GithubUserProfile;
import com.example.afeezawoyemi.githubusers.services.GithubUsersService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GithubUserProfilePresenter {
    private UserProfileView userProfileView;
    private GithubUsersService githubUsersService;
    public GithubUserProfilePresenter(UserProfileView view) {
        this.userProfileView = view;

        if (this.githubUsersService == null) {
            this.githubUsersService = new GithubUsersService();
        }
    }

    public void getUserProfile(String username, String clientId, String clientSecret) {
        this.githubUsersService
                .gihubAPI()
                .getUserProfile(username, clientId, clientSecret)
                .enqueue(new Callback<GithubUserProfile>() {
                    @Override
                    public void onResponse(Call<GithubUserProfile> call, Response<GithubUserProfile> response) {
                        GithubUserProfile data = response.body();

                        if (data != null && data.getProfileImage() != null) {
                            GithubUserProfile result = data;

                            userProfileView.userProfileReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<GithubUserProfile> call, Throwable t) {
                        try {
                            throw new InterruptedException("An error occurred");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
