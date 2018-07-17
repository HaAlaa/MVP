package com.example.asus.anew.di;

import android.app.Application;

import com.example.asus.anew.MyApplication;
import com.example.asus.anew.data.AppDataManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBindingsModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    AppDataManager getAppDataManager();
    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent.Builder AppModule(AppModule module);

        AppComponent build();
    }
}
