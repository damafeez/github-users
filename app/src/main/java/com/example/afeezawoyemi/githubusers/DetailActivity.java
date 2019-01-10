package com.example.afeezawoyemi.githubusers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afeezawoyemi.githubusers.model.GithubUserProfile;
import com.example.afeezawoyemi.githubusers.presenter.GithubUserProfilePresenter;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements UserProfileView {

    private String username;
    private Toolbar appToolbar;
    private ProgressDialog progressDialog;
    private GithubUserProfile githubUserProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        appToolbar = findViewById(R.id.action_bar);
        appToolbar.setTitleTextColor(Color.GRAY);
        progressDialog = new ProgressDialog(this);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        progressDialog.setMessage("Please hold on, where fetching " + username + "'s profile.");
        progressDialog.setCancelable(false);
        GithubUserProfilePresenter presenter = new GithubUserProfilePresenter(this);
        if (savedInstanceState == null) {
            presenter.getUserProfile(username, getString(R.string.github_client_id), getString(R.string.github_client_secret));
            progressDialog.show();
        }
    }

    @Override
    public void userProfileReady(GithubUserProfile user) {
        githubUserProfile = user;
        displayUser();

    }

    private void displayUser() {
        setContentView(R.layout.activity_detail);
        ImageView userImage = findViewById(R.id.profile_image);
        TextView username = findViewById(R.id.username);
        TextView bio = findViewById(R.id.bio);
        TextView following = findViewById(R.id.following);
        TextView followers = findViewById(R.id.followers);
        TextView repos = findViewById(R.id.repos);

        username.setText(githubUserProfile.getUsername());
        following.setText(githubUserProfile.getFollowing());
        followers.setText(githubUserProfile.getFollowers());
        repos.setText(githubUserProfile.getPublicRepos());
        String bioString = githubUserProfile.getBio();
        if (bioString != null) {
            bio.setText(bioString);
        } else {
            bio.setText("This user has no bio");
        }
        Picasso.with(this).load(githubUserProfile.getProfileImage())
                .placeholder(R.drawable.placeholder).into(userImage);
        progressDialog.dismiss();
    }

    public void shareProfile(View view) {
        Intent profileShareIntent = new Intent(Intent.ACTION_SEND);
        profileShareIntent.setType("text/plain");
        profileShareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer @" + username + ", https://github.com/" + username + ".");
        startActivity(Intent.createChooser(profileShareIntent, "Share profile using"));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("user", githubUserProfile);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("user")) {
            githubUserProfile = savedInstanceState.getParcelable("user");
            displayUser();
        }
    }
}
