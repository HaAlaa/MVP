package com.example.asus.anew.main.stories.holders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.asus.anew.R;
import com.example.asus.anew.data.network.model.Story;
import com.example.asus.anew.utils.Constants;
import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoStoryVH extends RecyclerView.ViewHolder implements View.OnClickListener {
    @Inject
    Gson gson;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.profileImage)
    ImageView userImage;
    @BindView(R.id.postDate)
    TextView postDate;
    @BindView(R.id.postText)
    TextView postText;
    @BindView(R.id.postImage)
    ImageView postImage;
    @BindView(R.id.likes)
    TextView likes;

    private Story story;

    public PhotoStoryVH(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Story story) {
        this.story = story;
    }

    @Override
    public void onClick(View v) {
        callStoryDetailsActivity(v);
    }

    public TextView getUserName() {
        return userName;
    }

    public ImageView getUserImage() {
        return userImage;
    }

    public TextView getPostDate() {
        return postDate;
    }

    public TextView getPostText() {
        return postText;
    }

    public ImageView getPostImage() {
        return postImage;
    }

    public TextView getLikes() {
        return likes;
    }

    public Story getStory() {
        return story;
    }

    public void setUserName(TextView userName) {
        this.userName = userName;
    }

    public void setUserImage(ImageView userImage) {
        this.userImage = userImage;
    }

    public void setPostDate(TextView postDate) {
        this.postDate = postDate;
    }

    public void setPostText(TextView postText) {
        this.postText = postText;
    }

    public void setPostImage(ImageView postImage) {
        this.postImage = postImage;
    }

    public void setLikes(TextView likes) {
        this.likes = likes;
    }

    private void callStoryDetailsActivity(View v) {
       /* Intent intent = new Intent(v.getContext(), PhotoDetailsActivity.class);
        String storyJson = gson.toJson(story);

        intent.putExtra(Constants.PHOTO_SERIALIZABLE_STORY, storyJson);
        v.getContext().startActivity(intent);
        */
    }

}

