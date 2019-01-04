package com.example.afeezawoyemi.githubusers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import static android.content.ContentValues.TAG;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder> {
    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView userImage;
        public TextView username;
        public View userListItem;

        public ViewHolder(View listItem) {
            super(listItem);
            userImage = (ImageView) listItem.findViewById(R.id.userImage);
            username = (TextView) listItem.findViewById(R.id.username);
            userListItem = listItem;
        }
    }

    private List<GithubUser> githubUsers;
//    private

    public GithubAdapter(List<GithubUser> users) {
        githubUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View githubUserView = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(githubUserView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        GithubUser githubUser = githubUsers.get(position);
        ImageView userImage = viewHolder.userImage;
        TextView username = viewHolder.username;
        Picasso.with(context).load(githubUser.getProfileImage())
                .placeholder(R.drawable.placeholder).into(userImage);
        username.setText(githubUser.getUsername());
        viewHolder.userListItem.setOnClickListener(launchDetailActivity);
    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    public View.OnClickListener launchDetailActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent showDetailActivity = new Intent(context, DetailActivity.class);
            context.startActivity(showDetailActivity);
        }
    };
}
