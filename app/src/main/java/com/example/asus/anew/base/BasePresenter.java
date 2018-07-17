package com.example.asus.anew.base;


import com.example.asus.anew.data.AppDataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public interface BasePresenter<T extends BaseView> {

    void onViewAdded(T view);

    void onViewRemoved();

}
