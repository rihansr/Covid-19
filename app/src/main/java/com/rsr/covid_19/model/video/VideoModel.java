package com.rsr.covid_19.model.video;

import java.io.Serializable;

public class VideoModel implements Serializable {

    private String id;
    private String thumbnail;
    private String icon;
    private String title_En;
    private String message_En;
    private String duration_En;
    private String url_En;
    private String title_Bn;
    private String message_Bn;
    private String duration_Bn;
    private String url_Bn;
    private String info;

    public VideoModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    public String getDuration_En() {
        return duration_En;
    }

    public void setDuration_En(String duration_En) {
        this.duration_En = duration_En;
    }

    public String getUrl_En() {
        return url_En;
    }

    public void setUrl_En(String url_En) {
        this.url_En = url_En;
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

    public String getDuration_Bn() {
        return duration_Bn;
    }

    public void setDuration_Bn(String duration_Bn) {
        this.duration_Bn = duration_Bn;
    }

    public String getUrl_Bn() {
        return url_Bn;
    }

    public void setUrl_Bn(String url_Bn) {
        this.url_Bn = url_Bn;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

