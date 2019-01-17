package com.example.afeezawoyemi.githubusers.presenter;

import android.util.Log;

import com.example.afeezawoyemi.githubusers.GithubUsersView;
import com.example.afeezawoyemi.githubusers.model.GithubUser;
import com.example.afeezawoyemi.githubusers.model.GithubUsersResponse;
import com.example.afeezawoyemi.githubusers.services.GithubUsersService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GithubPresenter {
    private GithubUsersView githubUsersView;
    private GithubUsersService githubUsersService;
    public GithubPresenter(GithubUsersView view) {
        this.githubUsersView = view;

        if (this.githubUsersService == null) {
            this.githubUsersService = new GithubUsersService();
        }
    }

    public void getUsers() {
        githubUsersService
                .gihubAPI()
                .getUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        GithubUsersResponse data = response.body();

                        if (data != null && data.getGithubUsers() != null) {
                            List<GithubUser> result = data.getGithubUsers();

                            githubUsersView.githubUsersReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("An error occurred");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
