package com.example.asus.anew.main.stories;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.anew.R;
import com.example.asus.anew.data.network.model.Attachment;
import com.example.asus.anew.data.network.model.Story;
import com.example.asus.anew.main.stories.holders.LoadingVH;
import com.example.asus.anew.main.stories.holders.PhotoStoryVH;
import com.example.asus.anew.main.stories.holders.TextStoryVH;
import com.example.asus.anew.utils.Helpers;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.viven.imagezoom.ImageZoomHelper;

import java.util.ArrayList;
import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter {

    private static final int PHOTO_STORY = 0;
    private static final int TEXT_STORY = 1;
    private static final int LOADING = 2;
    private boolean isLoadingAdded = false;

    private List<Story> stories;
    private Context context;

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public StoriesAdapter(Context context) {
        stories = new ArrayList<>();
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder mViewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType) {
            case TEXT_STORY:
                view = inflater.inflate(R.layout.text_story_item, parent, false);
                mViewHolder = new TextStoryVH(view);

                break;
            case PHOTO_STORY:
                view = inflater.inflate(R.layout.photo_story_item, parent, false);
                mViewHolder = new PhotoStoryVH(view);
                break;
            case LOADING:
                view = inflater.inflate(R.layout.progress_item, parent, false);
                mViewHolder = new LoadingVH(view);
                break;
        }
        return mViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Story story = stories.get(position);

        switch (getItemViewType(position)) {
            case PHOTO_STORY:
                PhotoStoryVH storyViewHolder = (PhotoStoryVH) holder;
                storyViewHolder.bindData(story);
                storyViewHolder.getUserName().setText(story.getPost().getAuthor().getName());
                storyViewHolder.getPostDate().setText(Helpers.parseDateToDMY(story.getCreatedat(), context));
                storyViewHolder.getLikes().setText(String.valueOf(story.getPost().getLikes().size()));
                storyViewHolder.getPostText().setText(Helpers.fontColor(context, story.getPost().getBody(), "#"));
                String ProfileImgURL = story.getPost().getAuthor().getAvatar();
                Picasso.get().load(ProfileImgURL).placeholder(R.drawable.profile_pic_placeholder).into(storyViewHolder.getUserImage());
                ImageZoomHelper.setViewZoomable(storyViewHolder.getPostImage());
                ImageZoomHelper.setZoom(storyViewHolder.getPostImage(), true);

                List<Attachment> attachmentList = story.getPost().getAttachments();
                SetPostImg(storyViewHolder, attachmentList);

                break;
            case TEXT_STORY:
                TextStoryVH textStoryViewHolder = (TextStoryVH) holder;
                textStoryViewHolder.getUserName().setText(story.getPost().getAuthor().getName());
                textStoryViewHolder.getPostDate().setText(Helpers.parseDateToDMY(story.getCreatedat(), context));
                textStoryViewHolder.getLikes().setText(String.valueOf(story.getPost().getLikes().size()));
                textStoryViewHolder.getPostText().setText(Helpers.fontColor(context, story.getPost().getBody(), "#"));
                ProfileImgURL = story.getPost().getAuthor().getAvatar();
                Picasso.get().load(ProfileImgURL).into(textStoryViewHolder.getUserImage());

                break;
            case LOADING:

                break;
        }
    }

    @Override
    public int getItemCount() {
        return stories == null ? 0 : stories.size();
    }

    @Override
    public int getItemViewType(int position) {
        Story story = stories.get(position);
        if (position == stories.size() - 1 && isLoadingAdded)
            return LOADING;
        else if (story.getPost().getAttachments().size() != 0)
            return PHOTO_STORY;
        else
            return TEXT_STORY;
    }

    public void setIsLoadingAdded(boolean isLoadingAdded) {
        this.isLoadingAdded = isLoadingAdded;
    }

    private void SetPostImg(final PhotoStoryVH holder, List<Attachment> attachmentList) {
        final ImageView imageView = holder.getPostImage();

        if (attachmentList.size() != 0) {
            String attachmentType = attachmentList.get(0).getType();

            String imgURL;
            String thumbnailURL;

            if (attachmentType.equals("video")) {
                imgURL = attachmentList.get(0).getThumbnail();
                thumbnailURL = attachmentList.get(0).getThumbnail();
            } else {
                imgURL = attachmentList.get(0).getUrl();
                thumbnailURL = attachmentList.get(0).getThumbnail();
            }

            double imgHeight = Helpers.getScreenWidth(context) * attachmentList.get(0).getRatio();

            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.height = (int) imgHeight;
            imageView.setLayoutParams(layoutParams);

            final String finalImgURL = imgURL;
            Picasso.get().load(thumbnailURL) // thumbnail url goes here
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            Picasso.get()
                                    .load(finalImgURL) // image url goes here
                                    .into(imageView);
                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
        }
    }

}
