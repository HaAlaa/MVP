package com.example.asus.anew.data.network.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Story {

    @Expose
    @SerializedName("objects")
    private List<String> objects;
    @Expose
    @SerializedName("actor")
    private Actor actor;
    @Expose
    @SerializedName("totalActorsCount")
    private int totalactorscount;
    @Expose
    @SerializedName("verb")
    private String verb;
    @Expose
    @SerializedName("post")
    private Post post;
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("createdAt")
    private String createdat;
    @Expose
    @SerializedName("actors")
    private List<Actors> actors;
    @Expose
    @SerializedName("verbs")
    private List<String> verbs;

    public List<String> getObjects() {
        return objects;
    }

    public void setObjects(List<String> objects) {
        this.objects = objects;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public int getTotalactorscount() {
        return totalactorscount;
    }

    public void setTotalactorscount(int totalactorscount) {
        this.totalactorscount = totalactorscount;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }

    public List<String> getVerbs() {
        return verbs;
    }

    public void setVerbs(List<String> verbs) {
        this.verbs = verbs;
    }

}
