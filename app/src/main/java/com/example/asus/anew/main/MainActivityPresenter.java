package com.example.asus.anew.main;


import com.example.asus.anew.base.BasePresenterImpl;
import com.example.asus.anew.main.stories.StoriesContract;

import javax.inject.Inject;

public class MainActivityPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {

    MainContract.View view;

    @Inject
    public MainActivityPresenter() {

    }

}
