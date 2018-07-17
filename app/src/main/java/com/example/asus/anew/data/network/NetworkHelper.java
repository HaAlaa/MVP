package com.example.asus.anew.data.network;


import com.example.asus.anew.data.network.model.Response;

import io.reactivex.Single;


public interface NetworkHelper {
    Single<Response> fetchStories(String last_id);
}
