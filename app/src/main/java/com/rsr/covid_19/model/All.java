
package com.rsr.covid_19.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class All {

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
    private Object mPeopleHospitalized;
    @SerializedName("peopleTested")
    private Object mPeopleTested;
    @SerializedName("provinceState")
    private String mProvinceState;
    @SerializedName("recovered")
    private Long mRecovered;
    @SerializedName("uid")
    private Long mUid;

    public Long getActive() {
        return mActive;
    }

    public void setActive(Long active) {
        mActive = active;
    }

    public Object getAdmin2() {
        return mAdmin2;
    }

    public void setAdmin2(Object admin2) {
        mAdmin2 = admin2;
    }

    public String getCombinedKey() {
        return mCombinedKey;
    }

    public void setCombinedKey(String combinedKey) {
        mCombinedKey = combinedKey;
    }

    public Long getConfirmed() {
        return mConfirmed;
    }

    public void setConfirmed(Long confirmed) {
        mConfirmed = confirmed;
    }

    public String getCountryRegion() {
        return mCountryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        mCountryRegion = countryRegion;
    }

    public Long getDeaths() {
        return mDeaths;
    }

    public void setDeaths(Long deaths) {
        mDeaths = deaths;
    }

    public Object getFips() {
        return mFips;
    }

    public void setFips(Object fips) {
        mFips = fips;
    }

    public Double getIncidentRate() {
        return mIncidentRate;
    }

    public void setIncidentRate(Double incidentRate) {
        mIncidentRate = incidentRate;
    }

    public String getIso2() {
        return mIso2;
    }

    public void setIso2(String iso2) {
        mIso2 = iso2;
    }

    public String getIso3() {
        return mIso3;
    }

    public void setIso3(String iso3) {
        mIso3 = iso3;
    }

    public Long getLastUpdate() {
        return mLastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        mLastUpdate = lastUpdate;
    }

    public Double getLat() {
        return mLat;
    }

    public void setLat(Double lat) {
        mLat = lat;
    }

    public Double getLong() {
        return mLong;
    }

    public void setLong(Double lng) {
        mLong = lng;
    }

    public Object getPeopleHospitalized() {
        return mPeopleHospitalized;
    }

    public void setPeopleHospitalized(Object peopleHospitalized) {
        mPeopleHospitalized = peopleHospitalized;
    }

    public Object getPeopleTested() {
        return mPeopleTested;
    }

    public void setPeopleTested(Object peopleTested) {
        mPeopleTested = peopleTested;
    }

    public String getProvinceState() {
        return mProvinceState;
    }

    public void setProvinceState(String provinceState) {
        mProvinceState = provinceState;
    }

    public Long getRecovered() {
        return mRecovered;
    }

    public void setRecovered(Long recovered) {
        mRecovered = recovered;
    }

    public Long getUid() {
        return mUid;
    }

    public void setUid(Long uid) {
        mUid = uid;
    }

}
