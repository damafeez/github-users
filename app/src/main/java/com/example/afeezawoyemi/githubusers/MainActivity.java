package com.example.afeezawoyemi.githubusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.afeezawoyemi.githubusers.model.GithubUser;
import com.example.afeezawoyemi.githubusers.presenter.GithubPresenter;
import com.example.afeezawoyemi.githubusers.adapter.GithubAdapter;

import java.util.List;
public class MainActivity extends AppCompatActivity implements GithubUsersView{
    private GithubPresenter presenter;
    private RecyclerView userListRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new GithubPresenter(this);
        userListRecycler = (RecyclerView) findViewById(R.id.rv_users);
        presenter.getUsers();
    }

    public void launchDetailActivity(View view) {
        Intent showDetailActivity = new Intent(this, DetailActivity.class);
        startActivity(showDetailActivity);
    }

    @Override
    public void githubUsersReady(List<GithubUser> users) {
        userListRecycler.setLayoutManager(new LinearLayoutManager(this));
        GithubAdapter adapter = new GithubAdapter(users);
        userListRecycler.setAdapter(adapter);
    }
}
