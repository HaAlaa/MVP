package com.example.asus.anew.data;


import com.example.asus.anew.data.SharedPreferences.AppSharedPreferenceHelper;
import com.example.asus.anew.data.network.AppNetworkHelper;
import com.example.asus.anew.data.network.model.Response;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppDataManager {

    private AppNetworkHelper mNetworkHelper;
    private AppSharedPreferenceHelper mSharedPreferenceHelper;

    @Inject
    public AppDataManager(AppNetworkHelper networkHelper, AppSharedPreferenceHelper sharedPreferenceHelper) {
        mNetworkHelper = networkHelper;
        mSharedPreferenceHelper = sharedPreferenceHelper;
    }

    public Single<Response> getStories(String last_id) {
        return mNetworkHelper.fetchStories(last_id);
    }

    public void saveAccessToken(String accessToken) {
        mSharedPreferenceHelper.setSharedPreferenceToken(AppSharedPreferenceHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        return mSharedPreferenceHelper.getSharedPreferenceToken(AppSharedPreferenceHelper.PREF_KEY_ACCESS_TOKEN, null);
    }
}

