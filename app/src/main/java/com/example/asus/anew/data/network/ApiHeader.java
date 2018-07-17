package com.example.asus.anew.data.network;

import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;


public class ApiHeader {

    @SerializedName("Authorization")
    private String mAccessToken;

    @Inject
    public ApiHeader(String token) {
        mAccessToken = token;
    }

    public void setToken(String Token) {
        this.mAccessToken = Token;
    }

    public String getToken() {
        return mAccessToken;
    }

}
