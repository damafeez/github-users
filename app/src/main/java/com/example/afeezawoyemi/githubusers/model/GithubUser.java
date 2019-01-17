package com.example.afeezawoyemi.githubusers.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GithubUser implements Parcelable {
    @SerializedName("login")
    String username;

    @SerializedName("avatar_url")
    String profileImage;

    public String getUsername() {
        return  username;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public static final Creator<GithubUser> CREATOR = new Creator<GithubUser>() {
        @Override
        public GithubUser createFromParcel(Parcel in) {
            return new GithubUser(in);
        }

        @Override
        public GithubUser[] newArray(int size) {
            return new GithubUser[size];
        }
    };

    public GithubUser(String username, String profileImage) {
        this.username = username;
        this.profileImage = profileImage;
    }

    protected GithubUser(Parcel in) {
        username = in.readString();
        profileImage = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(profileImage);
    }
}