package com.rsr.covid_19.model.globalCases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubGlobalCase {
    @SerializedName("value")
    @Expose
    private Integer count;

    @SerializedName("detail")
    @Expose
    private String link;

    public SubGlobalCase() {}

    /**
     * @param count
     * @param link
     */

    public SubGlobalCase(Integer count, String link) {
        this.count = count;
        this.link = link;
    }

    public Integer getCount() {
        return count;
    }

    public String getLink() {
        return link;
    }
}
