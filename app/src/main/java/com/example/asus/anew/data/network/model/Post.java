package com.example.asus.anew.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("likesCount")
    private int likescount;
    @Expose
    @SerializedName("commentsCount")
    private int commentscount;
    @Expose
    @SerializedName("liked")
    private boolean liked;
    @Expose
    @SerializedName("shareLink")
    private String sharelink;
    @Expose
    @SerializedName("categories")
    private List<String> categories;

    @Expose
    @SerializedName("attachments")
    private List<Attachment> attachments;
    @Expose
    @SerializedName("likes")
    private List<Like> likes;
    @Expose
    @SerializedName("comments")
    private List<String> comments;
    @Expose
    @SerializedName("hashtags")
    private List<Hashtag> hashtags;
    @Expose
    @SerializedName("repliesCount")
    private int repliescount;
    @Expose
    @SerializedName("deleted")
    private boolean deleted;
    @Expose
    @SerializedName("__v")
    private int V;
    @Expose
    @SerializedName("body")
    private String body;
    @Expose
    @SerializedName("author")
    private Author author;
    @Expose
    @SerializedName("createdAt")
    private String createdat;
    @Expose
    @SerializedName("updatedAt")
    private String updatedat;
    @Expose
    @SerializedName("shortId")
    private String shortid;

    public int getLikescount() {
        return likescount;
    }

    public void setLikescount(int likescount) {
        this.likescount = likescount;
    }

    public int getCommentscount() {
        return commentscount;
    }

    public void setCommentscount(int commentscount) {
        this.commentscount = commentscount;
    }

    public boolean getLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getSharelink() {
        return sharelink;
    }

    public void setSharelink(String sharelink) {
        this.sharelink = sharelink;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public int getRepliescount() {
        return repliescount;
    }

    public void setRepliescount(int repliescount) {
        this.repliescount = repliescount;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getV() {
        return V;
    }

    public void setV(int V) {
        this.V = V;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }

    public String getShortid() {
        return shortid;
    }

    public void setShortid(String shortid) {
        this.shortid = shortid;
    }
}
