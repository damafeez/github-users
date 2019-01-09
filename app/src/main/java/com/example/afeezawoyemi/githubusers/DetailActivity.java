package com.example.afeezawoyemi.githubusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afeezawoyemi.githubusers.model.GithubUserProfile;
import com.example.afeezawoyemi.githubusers.presenter.GithubUserProfilePresenter;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements UserProfileView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        GithubUserProfilePresenter presenter = new GithubUserProfilePresenter(this);
        presenter.getUserProfile(username, getString(R.string.github_client_id), getString(R.string.github_client_secret));
    }

    @Override
    public void userProfileReady(GithubUserProfile githubUserProfile) {
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

    }
}
