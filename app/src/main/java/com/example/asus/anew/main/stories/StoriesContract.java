package com.example.asus.anew.main.stories;

import android.support.v7.widget.LinearLayoutManager;

import com.example.asus.anew.base.BasePresenter;
import com.example.asus.anew.base.BaseView;
import com.example.asus.anew.data.network.model.Response;
import com.example.asus.anew.data.network.model.Story;

import java.util.List;

public interface StoriesContract {

    interface View extends BaseView {
        void refresh(boolean is_refreshing);

        void clear();

        void SetLoadFooter();

        void removeLoadingFooter();

        void add(Story story);

        boolean isLast();

        void updateStoriesList(List<Story> storyList);


    }

    interface Presenter extends BasePresenter<View> {

        PaginationScrollListener onScrollEvent(LinearLayoutManager mLinearLayoutManager);

        void onRefreshAction();

        void loadStories();

        void updateStoriesRecycler(Response response);

        void loadPage(List<Story> storyList);

        void addLoadingFooter();

        void removeLoadingFooter();

        void changeIsLoadingAddedStatus(boolean isLoadingAdded);


    }

}