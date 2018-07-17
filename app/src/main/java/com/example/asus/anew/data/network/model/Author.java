package com.example.asus.anew.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Author {
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("isSubscribed")
    private boolean issubscribed;
    @Expose
    @SerializedName("followersCount")
    private int followerscount;
    @Expose
    @SerializedName("followingCount")
    private int followingcount;
    @Expose
    @SerializedName("isFollowed")
    private boolean isfollowed;
    @Expose
    @SerializedName("isExcluded")
    private boolean isexcluded;
    @Expose
    @SerializedName("isBanned")
    private boolean isbanned;
    @Expose
    @SerializedName("avatar")
    private String avatar;
    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("followers")
    private Followers followers;
    @Expose
    @SerializedName("banned")
    private Banned banned;
    @Expose
    @SerializedName("excludedUsers")
    private List<String> excludedusers;
    @Expose
    @SerializedName("glowsCount")
    private int glowscount;
    @Expose
    @SerializedName("postsCount")
    private int postscount;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("website")
    private String website;
    @Expose
    @SerializedName("biography")
    private String biography;
    @Expose
    @SerializedName("lastName")
    private String lastname;
    @Expose
    @SerializedName("firstName")
    private String firstname;

    public boolean getIssubscribed() {
        return issubscribed;
    }

    public void setIssubscribed(boolean issubscribed) {
        this.issubscribed = issubscribed;
    }

    public int getFollowerscount() {
        return followerscount;
    }

    public void setFollowerscount(int followerscount) {
        this.followerscount = followerscount;
    }

    public int getFollowingcount() {
        return followingcount;
    }

    public void setFollowingcount(int followingcount) {
        this.followingcount = followingcount;
    }

    public boolean getIsfollowed() {
        return isfollowed;
    }

    public void setIsfollowed(boolean isfollowed) {
        this.isfollowed = isfollowed;
    }

    public boolean getIsexcluded() {
        return isexcluded;
    }

    public void setIsexcluded(boolean isexcluded) {
        this.isexcluded = isexcluded;
    }

    public boolean getIsbanned() {
        return isbanned;
    }

    public void setIsbanned(boolean isbanned) {
        this.isbanned = isbanned;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public Banned getBanned() {
        return banned;
    }

    public void setBanned(Banned banned) {
        this.banned = banned;
    }

    public List<String> getExcludedusers() {
        return excludedusers;
    }

    public void setExcludedusers(List<String> excludedusers) {
        this.excludedusers = excludedusers;
    }

    public int getGlowscount() {
        return glowscount;
    }

    public void setGlowscount(int glowscount) {
        this.glowscount = glowscount;
    }

    public int getPostscount() {
        return postscount;
    }

    public void setPostscount(int postscount) {
        this.postscount = postscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
