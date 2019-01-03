package com.example.afeezawoyemi.githubusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.afeezawoyemi.githubusers.model.GithubUser;
import com.example.afeezawoyemi.githubusers.presenter.GithubPresenter;
import com.example.afeezawoyemi.githubusers.adapter.GithubAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GithubUsersView {
    private RecyclerView users;
    private GithubPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new GithubPresenter(this);
        presenter.getUsers();
        RecyclerView userList = (RecyclerView) findViewById(R.id.rv_users);
//        GithubAdapter githubAdapter = new GithubAdapter()
    }

    public void launchDetailActivity(View view) {
        Intent showDetailActivity = new Intent(this, DetailActivity.class);
        startActivity(showDetailActivity);
    }

    @Override
    public void githubUsersReady(List<GithubUser> usersList) {
        Log.d("tag", "githubUsersReady: " + usersList);
    }
}
