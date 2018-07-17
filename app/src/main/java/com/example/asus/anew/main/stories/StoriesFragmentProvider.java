package com.example.asus.anew.main.stories;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StoriesFragmentProvider {

    @ContributesAndroidInjector(modules = StoriesFragmentModule.class)
    abstract FragmentStories provideStoriesFragment();
}
