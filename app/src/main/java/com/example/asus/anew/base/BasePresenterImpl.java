package com.example.asus.anew.base;

import com.example.asus.anew.data.AppDataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Inject AppDataManager appDataManager;

    public AppDataManager getAppDataManager() {
        return appDataManager;
    }

    public T getView() {
        return view;
    }

    private T view;

    @Override
    public void onViewAdded(T view) {
        this.view = view;
    }

    @Override
    public void onViewRemoved() {
        compositeDisposable.clear();
        view = null;
    }
}
