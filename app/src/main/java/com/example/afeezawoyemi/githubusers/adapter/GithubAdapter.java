package com.example.afeezawoyemi.githubusers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afeezawoyemi.githubusers.DetailActivity;
import com.example.afeezawoyemi.githubusers.R;
import com.example.afeezawoyemi.githubusers.model.GithubUser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder> {
    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView userImage;
        public TextView username;
        public View userListItem;
        public ImageView shareButton;

        public ViewHolder(View listItem) {
            super(listItem);
            userImage = listItem.findViewById(R.id.userImage);
            username = listItem.findViewById(R.id.username);
            shareButton = listItem.findViewById(R.id.shareIcon);
            userListItem = listItem;
        }
    }

    private List<GithubUser> githubUsers;

    public GithubAdapter(List<GithubUser> users) {
        githubUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View githubUserView = inflater.inflate(R.layout.list_item_grid, parent, false);
        ViewHolder viewHolder = new ViewHolder(githubUserView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        GithubUser githubUser = githubUsers.get(position);
        ImageView userImage = viewHolder.userImage;
        TextView username = viewHolder.username;
        final String usernameString = githubUser.getUsername();
        Picasso.with(context).load(githubUser.getProfileImage())
                .placeholder(R.drawable.placeholder).into(userImage);
        username.setText(usernameString);
        viewHolder.userListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showDetailActivity = new Intent(context, DetailActivity.class);
                showDetailActivity.putExtra("username", usernameString);
                context.startActivity(showDetailActivity);
            }
        });
        viewHolder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent profileShareIntent = new Intent(Intent.ACTION_SEND);
            profileShareIntent.setType("text/plain");
            profileShareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer @" + usernameString + ", https://github.com/" + usernameString + ".");
            context.startActivity(Intent.createChooser(profileShareIntent, "Share profile using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }
}
