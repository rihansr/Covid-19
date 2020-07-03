
package com.rsr.covid_19.model.countryCases;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("alpha2")
    private String mIso2;
    @SerializedName("alpha3")
    private String mIso3;
    @SerializedName("country_en")
    private String mCountryEn;
    @SerializedName("country_bn")
    private String mCountryBn;
    @SerializedName("latitude")
    private Double mLatitude;
    @SerializedName("longitude")
    private Double mLongitude;

    public String getIso2() {
        return mIso2;
    }

    public String getIso3() {
        return mIso3;
    }

    public String getCountryEn() {
        return mCountryEn;
    }

    public String getCountryBn() {
        return mCountryBn;
    }

    public Double getLatitude() {
        return mLatitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }
}
