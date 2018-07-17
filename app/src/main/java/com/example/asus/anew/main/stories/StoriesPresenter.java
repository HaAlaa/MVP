package com.example.asus.anew.main.stories;


import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.asus.anew.base.BasePresenterImpl;
import com.example.asus.anew.data.AppDataManager;
import com.example.asus.anew.data.network.model.Response;
import com.example.asus.anew.data.network.model.Story;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class StoriesPresenter extends BasePresenterImpl<StoriesContract.View> implements StoriesContract.Presenter {

    private String last_id = "";
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private boolean isFirstPage = true;
    private boolean isRefreshing = false;
    private boolean isLoadingAdded = false;

    @Inject
    public StoriesPresenter() {
    }


    @Override
    public void onViewAdded(StoriesContract.View view) {
        super.onViewAdded(view);
    }

    @Override
    public PaginationScrollListener onScrollEvent(LinearLayoutManager mLinearLayoutManager) {
        return new PaginationScrollListener(mLinearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                isFirstPage = false;
                loadStories();
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        };
    }

    @Override
    public void loadStories() {
        isLoading = true;
        compositeDisposable.add(getAppDataManager().getStories(last_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response>() {
                    @Override
                    public void accept(Response response) {
                        Log.i("ooooooooooooooo", "response size" + response.getStories().size() + "");
                        getView().refresh(false);
                        if (isRefreshing) {
                            isRefreshing = false;
                            isLoadingAdded = false;
                            getView().clear();
                        }

                        updateStoriesRecycler(response);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {

                    }
                }));
    }

    @Override
    public void updateStoriesRecycler(Response response) {
        List<Story> storyList = response.getStories();
        last_id = storyList.get(storyList.size() - 1).getId();
        loadPage(storyList);
    }

    @Override
    public void loadPage(List<Story> storyList) {

        if (!isFirstPage) removeLoadingFooter();
        getView().updateStoriesList(storyList);
        isLoading = false;
        isFirstPage = false;

        if (getView().isLast())
            addLoadingFooter();
        else isLastPage = true;
    }

    public void changeIsLoadingAddedStatus(boolean isLoadingAdded) {
        this.isLoadingAdded = isLoadingAdded;
    }

    @Override
    public void addLoadingFooter() {
        isLoadingAdded = true;
        getView().SetLoadFooter();
    }

    @Override
    public void removeLoadingFooter() {
        isLoadingAdded = false;
        getView().removeLoadingFooter();
    }

    @Override
    public void onRefreshAction() {
        isFirstPage = true;
        isRefreshing = true;
        last_id = "";
        Log.i("oooooooooo", "add refresh");

        loadStories();
    }
}
