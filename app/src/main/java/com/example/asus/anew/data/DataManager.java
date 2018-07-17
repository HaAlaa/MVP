package com.example.asus.anew.data;


import com.example.asus.anew.data.network.model.Response;

import io.reactivex.Single;

public interface DataManager {

    Single<Response> getStories(String last_id);

    void saveAccessToken(String accessToken);

    String getAccessToken();
}