package com.example.asus.anew.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.asus.anew.data.AppDataManager;
import com.example.asus.anew.data.SharedPreferences.AppSharedPreferenceHelper;
import com.example.asus.anew.data.network.ApiHeader;
import com.example.asus.anew.data.network.AppNetworkHelper;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;


@Module
public  class AppModule {

    // same as provides but this returns injected parameter

    private final Application mApplication;

    public AppModule(Application app) {
        mApplication = app;
    }


    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    public AppDataManager provideAppDataManager(AppNetworkHelper networkHelper, AppSharedPreferenceHelper sharedPreferenceHelper) {
        return new AppDataManager(networkHelper, sharedPreferenceHelper);
    }

    @Provides
    public AppSharedPreferenceHelper provideAppSharedPreferenceHelper(SharedPreferences sharedPreferences) {
        return new AppSharedPreferenceHelper(sharedPreferences);
    }

    @Provides
    public SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

    @Provides
    public AppNetworkHelper provideNetworkHelper(ApiHeader apiHeader) {
        return new AppNetworkHelper(apiHeader);
    }

    @Provides
    public ApiHeader provideApiHeader(String accessToken) {
        return new ApiHeader(accessToken);
    }

    @Provides
    String provideAccessToken() {
        return "JWT " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjU5NjRhYzAwNDNhNTRhMDAwMWRiNGE5YiIsImlhdCI6MTUyNDEzMTkxOX0.Z2X6jeoLV4uB7xuNtwFAju8UVlruSkat6NeN2Ap8XWw";
    }


    @Provides
    Gson provideGson(){return new Gson();}


}
