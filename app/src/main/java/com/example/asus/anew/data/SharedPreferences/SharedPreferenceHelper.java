package com.example.asus.anew.data.SharedPreferences;

public interface SharedPreferenceHelper {
    String getSharedPreferenceToken(String key, String value);

    void setSharedPreferenceToken(String key, String defValue);
}
