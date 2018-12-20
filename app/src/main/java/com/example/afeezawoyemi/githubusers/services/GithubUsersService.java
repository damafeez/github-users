package com.example.afeezawoyemi.githubusers.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubUsersService {
    private Retrofit retrofit = null;

    public GihubAPI gihubAPI() {
        String baseURL = "https://api.github.com/";
        if(retrofit == null) {
            retrofit = new Retrofit
                .Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit.create(GihubAPI.class);
    }
}
