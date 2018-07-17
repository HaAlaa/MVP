package com.example.asus.anew.main.stories.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.asus.anew.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextStoryVH extends RecyclerView.ViewHolder {
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.profileImage)
    ImageView userImage;
    @BindView(R.id.postDate)
    TextView postDate;
    @BindView(R.id.postText)
    ReadMoreTextView postText;
    @BindView(R.id.likes)
    TextView likes;

    public TextView getUserName() {
        return userName;
    }

    public ImageView getUserImage() {
        return userImage;
    }

    public TextView getPostDate() {
        return postDate;
    }

    public ReadMoreTextView getPostText() {
        return postText;
    }

    public TextView getLikes() {
        return likes;
    }

    public TextStoryVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
