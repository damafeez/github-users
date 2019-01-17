package com.example.afeezawoyemi.githubusers;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.afeezawoyemi.githubusers.model.GithubUser;
import com.example.afeezawoyemi.githubusers.presenter.GithubPresenter;
import com.example.afeezawoyemi.githubusers.adapter.GithubAdapter;
import com.example.afeezawoyemi.githubusers.util.ConnectionManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GithubUsersView, SwipeRefreshLayout.OnRefreshListener {
    private GithubPresenter presenter;
    private RecyclerView userListRecycler;
    private Toolbar appToolbar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<GithubUser> users;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appToolbar = findViewById(R.id.action_bar);
        appToolbar.setTitleTextColor(Color.GRAY);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        presenter = new GithubPresenter(this);
        userListRecycler = findViewById(R.id.rv_users);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                if (savedInstanceState == null) {
                    presenter.getUsers();
                }
            }
        });
    }

    @Override
    public void showErrorSnackBar() {
        Snackbar.make(userListRecycler, "Internet connection error, please check your network", Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void githubUsersReady(List<GithubUser> usersList) {
        users = usersList;
        displayUsers();
    }

    @Override
    public void switchRefreshState(Boolean state) {
        swipeRefreshLayout.setRefreshing(state);
    }

    @Override
    public boolean isNetworkConnected() {
        return ConnectionManager.isConnected(this);
    }

    private void displayUsers() {
        userListRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        GithubAdapter adapter = new GithubAdapter(users);
        userListRecycler.setAdapter(adapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("users", (ArrayList<GithubUser>) users);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("users")) {
            users = savedInstanceState.getParcelableArrayList("users");
            displayUsers();
        }
    }

    @Override
    public void onRefresh() {
        presenter.getUsers();
    }
}
