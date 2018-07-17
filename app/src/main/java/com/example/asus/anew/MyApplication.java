package com.example.asus.anew;

import android.app.Activity;
import android.app.Application;
import android.os.UserManager;

import com.example.asus.anew.data.AppDataManager;
import com.example.asus.anew.di.AppComponent;
import com.example.asus.anew.di.AppModule;
import com.example.asus.anew.di.DaggerAppComponent;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyApplication extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> activityInjector;
    @Inject AppDataManager appDataManager;


    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        createComponent();
    }

    protected void createComponent() {

        appComponent = DaggerAppComponent.builder().application(this).AppModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}

