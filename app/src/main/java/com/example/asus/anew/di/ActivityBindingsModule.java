package com.example.asus.anew.di;

import com.example.asus.anew.main.MainActivity;
import com.example.asus.anew.main.MainActivityModule;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;


@Module(includes = AndroidInjectionModule.class)
abstract class ActivityBindingsModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();

}

