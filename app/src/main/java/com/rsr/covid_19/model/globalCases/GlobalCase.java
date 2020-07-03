package com.rsr.covid_19.model.globalCases;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GlobalCase implements Serializable {

    @SerializedName("active")
    private Long mActive;
    @SerializedName("admin2")
    private String mAdmin2;
    @SerializedName("combinedKey")
    private String mCombinedKey;
    @SerializedName("confirmed")
    private Long mConfirmed;
    @SerializedName("countryRegion")
    private String mCountryRegion;
    @SerializedName("deaths")
    private Long mDeaths;
    @SerializedName("fips")
    private String mFips;
    @SerializedName("incidentRate")
    private Double mIncidentRate;
    @SerializedName("iso2")
    private String mIso2;
    @SerializedName("iso3")
    private String mIso3;
    @SerializedName("lastUpdate")
    private Long mLastUpdate;
    @SerializedName("lat")
    private Double mLat;
    @SerializedName("long")
    private Double mLong;
    @SerializedName("peopleHospitalized")
    private Long mPeopleHospitalized;
    @SerializedName("peopleTested")
    private Long mPeopleTested;
    @SerializedName("provinceState")
    private String mProvinceState;
    @SerializedName("recovered")
    private Long mRecovered;
    @SerializedName("uid")
    private Long mUid;

    public long getActive() {
        return mActive == null ? 0 : mActive;
    }

    public String getAdmin2() {
        return mAdmin2;
    }

    public String getCombinedKey() {
        return mCombinedKey;
    }

    public long getConfirmed() {
        return mConfirmed == null ? 0 : mConfirmed;
    }

    public String getCountryRegion() {
        return mCountryRegion;
    }

    public long getDeaths() {
        return mDeaths == null ? 0 : mDeaths;
    }

    public String getFips() {
        return mFips;
    }

    public double getIncidentRate() {
        return mIncidentRate == null ? 0 : mIncidentRate;
    }

    public String getIso2() {
        return mIso2;
    }

    public String getIso3() {
        return mIso3;
    }

    public long getLastUpdate() {
        return mLastUpdate == null ? 0 : mLastUpdate;
    }

    public Double getLat() {
        return mLat;
    }

    public Double getLong() {
        return mLong;
    }

    public long getPeopleHospitalized() {
        return mPeopleHospitalized == null ? 0 : mPeopleHospitalized;
    }

    public long getPeopleTested() {
        return mPeopleTested == null ? 0 : mPeopleTested;
    }

    public String getProvinceState() {
        return mProvinceState;
    }

    public long getRecovered() {
        return mRecovered == null ? 0 : mRecovered;
    }

    public Long getUid() {
        return mUid;
    }
}

