package com.rsr.covid_19.model.notification;

import java.io.Serializable;
import java.util.List;

public class Notification implements Serializable {

    private String          id;
    private String          icon;
    private String          title_En;
    private String          message_En;
    private String          title_Bn;
    private String          message_Bn;
    private long            date;
    private List<String>    photos;
    private String          videoTitle_En;
    private String          videoTitle_Bn;
    private String          videoLink;

    public Notification() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle_En() {
        return title_En;
    }

    public void setTitle_En(String title_En) {
        this.title_En = title_En;
    }

    public String getMessage_En() {
        return message_En;
    }

    public void setMessage_En(String message_En) {
        this.message_En = message_En;
    }

    public String getTitle_Bn() {
        return title_Bn;
    }

    public void setTitle_Bn(String title_Bn) {
        this.title_Bn = title_Bn;
    }

    public String getMessage_Bn() {
        return message_Bn;
    }

    public void setMessage_Bn(String message_Bn) {
        this.message_Bn = message_Bn;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getVideoTitle_En() {
        return videoTitle_En;
    }

    public void setVideoTitle_En(String videoTitle_En) {
        this.videoTitle_En = videoTitle_En;
    }

    public String getVideoTitle_Bn() {
        return videoTitle_Bn;
    }

    public void setVideoTitle_Bn(String videoTitle_Bn) {
        this.videoTitle_Bn = videoTitle_Bn;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
}

