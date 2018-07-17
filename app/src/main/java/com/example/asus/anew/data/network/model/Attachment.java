package com.example.asus.anew.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachment {

    @Expose
    @SerializedName("url")
    private String url;

    @Expose
    @SerializedName("_id")
    private String attachment_id;

    @Expose
    @SerializedName("deleted")
    private Boolean deleted;


    @Expose
    @SerializedName("isMuted")
    private Boolean isMuted;


    @Expose
    @SerializedName("ratio")
    private Double ratio;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("thumbnailBlur")
    private String thumbnailBlur;

    @Expose
    @SerializedName("thumbnail")
    private String thumbnail;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAttachment_id() {
        return attachment_id;
    }

    public void setAttachment_id(String attachment_id) {
        this.attachment_id = attachment_id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getMuted() {
        return isMuted;
    }

    public void setMuted(Boolean muted) {
        isMuted = muted;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThumbnailBlur() {
        return thumbnailBlur;
    }

    public void setThumbnailBlur(String thumbnailBlur) {
        this.thumbnailBlur = thumbnailBlur;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
