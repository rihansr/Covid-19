package com.rsr.covid_19.model.topic;

import java.io.Serializable;

public class TopicDetails implements Serializable {

    private String  id;
    private String  icon;
    private String  subDetails_En;
    private String  subDetails_Bn;
    private boolean isSmallIcon;
    private boolean rightPosition;

    public TopicDetails() {}

    public TopicDetails(String id, String subDetails_En, String subDetails_Bn) {
        this.id = id;
        this.subDetails_En = subDetails_En;
        this.subDetails_Bn = subDetails_Bn;
    }

    public TopicDetails(String id, String icon, String subDetails_En, String subDetails_Bn, boolean isSmallIcon, boolean rightPosition) {
        this.id = id;
        this.icon = icon;
        this.subDetails_En = subDetails_En;
        this.subDetails_Bn = subDetails_Bn;
        this.isSmallIcon = isSmallIcon;
        this.rightPosition = rightPosition;
    }

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

    public String getSubDetails_En() {
        return subDetails_En;
    }

    public void setSubDetails_En(String subDetails_En) {
        this.subDetails_En = subDetails_En;
    }

    public String getSubDetails_Bn() {
        return subDetails_Bn;
    }

    public void setSubDetails_Bn(String subDetails_Bn) {
        this.subDetails_Bn = subDetails_Bn;
    }

    public boolean isSmallIcon() {
        return isSmallIcon;
    }

    public void setSmallIcon(boolean smallIcon) {
        isSmallIcon = smallIcon;
    }

    public boolean isRightPosition() {
        return rightPosition;
    }

    public void setRightPosition(boolean rightPosition) {
        this.rightPosition = rightPosition;
    }
}

