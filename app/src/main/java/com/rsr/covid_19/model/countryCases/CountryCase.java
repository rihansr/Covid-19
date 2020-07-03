
package com.rsr.covid_19.model.countryCases;

import com.google.gson.annotations.SerializedName;

public class CountryCase {

    @SerializedName("active")
    private Long mActive;
    @SerializedName("admin2")
    private Object mAdmin2;
    @SerializedName("combinedKey")
    private String mCombinedKey;
    @SerializedName("confirmed")
    private Long mConfirmed;
    @SerializedName("countryRegion")
    private String mCountryRegion;
    @SerializedName("deaths")
    private Long mDeaths;
    @SerializedName("fips")
    private Object mFips;
    @SerializedName("incidentRate")
    private Object mIncidentRate;
    @SerializedName("lastUpdate")
    private Long mLastUpdate;
    @SerializedName("lat")
    private Double mLat;
    @SerializedName("long")
    private Double mLong;
    @SerializedName("peopleTested")
    private Object mPeopleTested;
    @SerializedName("provinceState")
    private Object mProvinceState;
    @SerializedName("recovered")
    private Long mRecovered;

    public Long getActive() {
        return mActive;
    }

    public Object getAdmin2() {
        return mAdmin2;
    }

    public String getCombinedKey() {
        return mCombinedKey;
    }

    public Long getConfirmed() {
        return mConfirmed;
    }

    public String getCountryRegion() {
        return mCountryRegion;
    }

    public Long getDeaths() {
        return mDeaths;
    }

    public Object getFips() {
        return mFips;
    }

    public Object getIncidentRate() {
        return mIncidentRate;
    }

    public Long getLastUpdate() {
        return mLastUpdate;
    }

    public Double getLat() {
        return mLat;
    }

    public Double getLong() {
        return mLong;
    }

    public Object getPeopleTested() {
        return mPeopleTested;
    }

    public Object getProvinceState() {
        return mProvinceState;
    }

    public Long getRecovered() {
        return mRecovered;
    }
}
