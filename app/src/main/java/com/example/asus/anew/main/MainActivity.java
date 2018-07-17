package com.example.asus.anew.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.example.asus.anew.R;
import com.example.asus.anew.base.BaseActivity;
import com.example.asus.anew.base.BaseView;
import com.example.asus.anew.main.stories.FragmentStories;
import com.viven.imagezoom.ImageZoomHelper;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {
    ImageZoomHelper imageZoomHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageZoomHelper = new ImageZoomHelper(this);
        addFragment(R.id.place_holder, new FragmentStories());
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return imageZoomHelper.onDispatchTouchEvent(ev) || super.dispatchTouchEvent(ev);

    }

}
