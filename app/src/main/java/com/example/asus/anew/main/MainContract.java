package com.example.asus.anew.main;

import com.example.asus.anew.base.BasePresenter;
import com.example.asus.anew.base.BaseView;
import com.example.asus.anew.main.stories.StoriesContract;

public interface MainContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<MainContract.View> {


    }

}