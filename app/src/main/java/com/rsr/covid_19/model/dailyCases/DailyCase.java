package com.rsr.covid_19.model.dailyCases;

import com.google.gson.annotations.SerializedName;

public class DailyCase {

    @SerializedName("active")
    private String mActive;
    @SerializedName("admin2")
    private String mAdmin2;
    @SerializedName("combinedKey")
    private String mCombinedKey;
    @SerializedName("confirmed")
    private String mConfirmed;
    @SerializedName("countryRegion")
    private String mCountryRegion;
    @SerializedName("deaths")
    private String mDeaths;
    @SerializedName("fips")
    private String mFips;
    @SerializedName("lastUpdate")
    private String mLastUpdate;
    @SerializedName("lat")
    private String mLat;
    @SerializedName("long")
    private String mLong;
    @SerializedName("provinceState")
    private String mProvinceState;
    @SerializedName("recovered")
    private String mRecovered;

    public String getActive() {
        return mActive;
    }

    public void setActive(String active) {
        mActive = active;
    }

    public String getAdmin2() {
        return mAdmin2;
    }

    public void setAdmin2(String admin2) {
        mAdmin2 = admin2;
    }

    public String getCombinedKey() {
        return mCombinedKey;
    }

    public void setCombinedKey(String combinedKey) {
        mCombinedKey = combinedKey;
    }

    public String getConfirmed() {
        return mConfirmed;
    }

    public void setConfirmed(String confirmed) {
        mConfirmed = confirmed;
    }

    public String getCountryRegion() {
        return mCountryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        mCountryRegion = countryRegion;
    }

    public String getDeaths() {
        return mDeaths;
    }

    public void setDeaths(String deaths) {
        mDeaths = deaths;
    }

    public String getFips() {
        return mFips;
    }

    public void setFips(String fips) {
        mFips = fips;
    }

    public String getLastUpdate() {
        return mLastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        mLastUpdate = lastUpdate;
    }

    public String getLat() {
        return mLat;
    }

    public void setLat(String lat) {
        mLat = lat;
    }

    public String getLong() {
        return mLong;
    }

    public void setLong(String mLong) {
        mLong = mLong;
    }

    public String getProvinceState() {
        return mProvinceState;
    }

    public void setProvinceState(String provinceState) {
        mProvinceState = provinceState;
    }

    public String getRecovered() {
        return mRecovered;
    }

    public void setRecovered(String recovered) {
        mRecovered = recovered;
    }

}