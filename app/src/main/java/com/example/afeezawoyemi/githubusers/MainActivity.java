package com.example.afeezawoyemi.githubusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.afeezawoyemi.githubusers.model.GithubUsers;
import com.example.afeezawoyemi.githubusers.presenter.GithubPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GithubUsersView {

    private RecyclerView users;
    private GithubPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = findViewById(R.id.rv_users);
        presenter = new GithubPresenter(this);
        presenter.getUsers();
    }

    public void launchDetailActivity(View view) {
        Intent showDetailActivity = new Intent(this, DetailActivity.class);
        startActivity(showDetailActivity);
    }

    @Override
    public void githubUsersReady(List<GithubUsers> usersList) {
        Log.d("tag", "githubUsersReady: " + usersList);
    }
}
