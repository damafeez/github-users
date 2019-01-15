package com.example.afeezawoyemi.githubusers.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GithubUserProfile implements Parcelable {
    @SerializedName("login")
    String username;

    @SerializedName("avatar_url")
    String profileImage;

    String followers;

    String following;

    String bio;

    @SerializedName("public_repos")
    String publicRepos;

    protected GithubUserProfile(Parcel in) {
        username = in.readString();
        profileImage = in.readString();
        followers = in.readString();
        following = in.readString();
        bio = in.readString();
        publicRepos = in.readString();
    }

    public GithubUserProfile(
            String username,
            String profileImage,
            String followers,
            String following,
            String bio,
            String publicRepos
    ) {
        this.username = username;
        this.profileImage = profileImage;
        this.followers = followers;
        this.following = following;
        this.bio = bio;
        this.publicRepos = publicRepos;
    }

    public static final Creator<GithubUserProfile> CREATOR = new Creator<GithubUserProfile>() {
        @Override
        public GithubUserProfile createFromParcel(Parcel in) {
            return new GithubUserProfile(in);
        }

        @Override
        public GithubUserProfile[] newArray(int size) {
            return new GithubUserProfile[size];
        }
    };

    public String getUsername() {
        return  username;
    }

    public String getProfileImage() {
        return profileImage;
    }
    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }

    public String getPublicRepos() {
        return publicRepos;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(profileImage);
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(bio);
        dest.writeString(publicRepos);
    }
}
