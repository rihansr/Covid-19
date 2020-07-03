
package com.rsr.covid_19.model.globalCases;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CaseOverview implements Serializable {

    private int     icon;
    private long    count;
    private long    subCount;
    private int     text;
    private String  percentage;

    public CaseOverview(int icon, long count, long subCount, int text, String percentage) {
        this.icon = icon;
        this.count = count;
        this.subCount = subCount;
        this.text = text;
        this.percentage = percentage;
    }

    public CaseOverview(int icon, long count, long subCount, int text) {
        this.icon = icon;
        this.count = count;
        this.subCount = subCount;
        this.text = text;
    }

    public CaseOverview(int icon, long count, int text, String percentage) {
        this.icon = icon;
        this.count = count;
        this.text = text;
        this.percentage = percentage;
    }

    public CaseOverview(int icon, long count, int text) {
        this.icon = icon;
        this.count = count;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getSubCount() {
        return subCount;
    }

    public void setSubCount(long subCount) {
        this.subCount = subCount;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
