package com.example.asus.anew.main.stories;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.asus.anew.R;
import com.example.asus.anew.base.BaseFragment;
import com.example.asus.anew.data.AppDataManager;
import com.example.asus.anew.data.network.model.Story;
import com.example.asus.anew.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentStories extends BaseFragment<StoriesContract.Presenter> implements StoriesContract.View, SwipeRefreshLayout.OnRefreshListener {
    List<Story> stories;
    StoriesAdapter mStoriesAdapter;
    LinearLayoutManager mLinearLayoutManager;
    @Inject AppDataManager mDataManager;

    @BindView(R.id.storiesRecycler) RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout mSwipeRefreshLayout;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stories, container, false);
        ButterKnife.bind(this, rootView);

        mSwipeRefreshLayout.setOnRefreshListener(this);
        checkInternetConnection();
        return rootView;
    }


    private void loadFirstPage() {
        //load first page
        mSwipeRefreshLayout.setRefreshing(true);
        getPresenter().loadStories();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void checkInternetConnection() {
        if (isNetworkConnected()) {
            loadFirstPage();
        } else {
            if (mActivity != null) {
                new AlertDialog.Builder(mActivity)
                        .setTitle(R.string.no_internet)
                        .setMessage(R.string.no_internet_msg)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert).show();
            }
        }
    }


    @Override
    protected void setUp(View view) {
        stories = new ArrayList<>();
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mStoriesAdapter = new StoriesAdapter(getActivity());
        mStoriesAdapter.setStories(stories);
        recyclerView.setAdapter(mStoriesAdapter);
        recyclerView.addOnScrollListener(getPresenter().onScrollEvent(mLinearLayoutManager));
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        getPresenter().onRefreshAction();
    }


    @Override
    public void add(Story story) {
        stories.add(story);
        mStoriesAdapter.notifyItemInserted(stories.size() - 1);
    }

    @Override
    public boolean isLast() {
        if (stories.size() % Constants.PAGINATION_ITEMS_COUNT == 0)
            return true;
        else return false;
    }

    @Override
    public void updateStoriesList(List<Story> storyList) {
        for (Story s : storyList)
            add(s);
    }

    public void remove(Story story) {
        int position = stories.indexOf(story);
        if (position > -1) {
            stories.remove(position);
            mStoriesAdapter.notifyItemRemoved(position);
        }
    }

    @Override
    public void clear() {
        mStoriesAdapter.setIsLoadingAdded(false);
        while (mStoriesAdapter.getItemCount() > 0) {
            remove(getItem(0));
        }
        refresh(false);
    }

    public Story getItem(int position) {
        return stories.get(position);
    }

    @Override
    public void SetLoadFooter() {
        getPresenter().changeIsLoadingAddedStatus(true);
        mStoriesAdapter.setIsLoadingAdded(true);

        add(new Story());
        getPresenter().loadStories();
    }

    @Override
    public void removeLoadingFooter() {
        getPresenter().changeIsLoadingAddedStatus(false);
        mStoriesAdapter.setIsLoadingAdded(false);

        int position = stories.size() - 1;
        Story item = getItem(position);

        if (item != null) {
            stories.remove(position);
            mStoriesAdapter.notifyItemRemoved(position);
        }
    }

    @Override
    public void refresh(boolean is_refreshing) {
        mSwipeRefreshLayout.setRefreshing(is_refreshing);
    }
}
