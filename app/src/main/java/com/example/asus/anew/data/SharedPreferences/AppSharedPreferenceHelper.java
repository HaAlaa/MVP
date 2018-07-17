package com.example.asus.anew.data.SharedPreferences;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppSharedPreferenceHelper implements SharedPreferenceHelper {
    public static String PREF_KEY_ACCESS_TOKEN = "access-token";

    SharedPreferences mSharedPreferences;

    @Inject
    public AppSharedPreferenceHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public String getSharedPreferenceToken(String key, String value) {
        return mSharedPreferences.getString(key, value);
    }

    @Override
    public void setSharedPreferenceToken(String key, String defValue) {
        mSharedPreferences.edit().putString(key, defValue).apply();
    }

}
