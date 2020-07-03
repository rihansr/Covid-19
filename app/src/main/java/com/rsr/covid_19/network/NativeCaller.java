package com.rsr.covid_19.network;

public class NativeCaller {

    public NativeCaller() {
        System.loadLibrary("native-lib");
    }

    public final native String getBaseUrl();

    public final native String getOverviewUrl();
}
