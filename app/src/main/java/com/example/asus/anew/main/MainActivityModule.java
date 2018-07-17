package com.example.asus.anew.main;


import com.example.asus.anew.main.stories.FragmentStories;
import com.example.asus.anew.main.stories.StoriesContract;
import com.example.asus.anew.main.stories.StoriesPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract FragmentStories StoriesFragment();


    @Binds
    public abstract MainContract.Presenter provideMainActivityPresenter(MainActivityPresenter presenter);

    @Binds
    public abstract StoriesContract.Presenter provideStoriesPresenter(StoriesPresenter presenter);

}

