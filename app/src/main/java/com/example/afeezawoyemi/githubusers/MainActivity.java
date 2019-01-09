package com.example.afeezawoyemi.githubusers;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.afeezawoyemi.githubusers.model.GithubUser;
import com.example.afeezawoyemi.githubusers.presenter.GithubPresenter;
import com.example.afeezawoyemi.githubusers.adapter.GithubAdapter;
import com.example.afeezawoyemi.githubusers.model.GithubUser;
import com.example.afeezawoyemi.githubusers.presenter.GithubPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GithubUsersView{
    private GithubPresenter presenter;
    private RecyclerView userListRecycler;
    private Toolbar appToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appToolbar = findViewById(R.id.action_bar);
        appToolbar.setTitleTextColor(Color.GRAY);
        presenter = new GithubPresenter(this);
        userListRecycler = findViewById(R.id.rv_users);
        presenter.getUsers();
    }

    @Override
    public void githubUsersReady(List<GithubUser> users) {
        userListRecycler.setLayoutManager(new LinearLayoutManager(this));
        GithubAdapter adapter = new GithubAdapter(users);
        userListRecycler.setAdapter(adapter);
    }
}
