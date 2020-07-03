package com.rsr.covid_19.util;

import androidx.fragment.app.Fragment;

import com.rsr.covid_19.fragment.OverviewFragment;

public class Constants {

    /**
     * GoogleMap
     **/
    public static final int     LOCATION_REQUEST = 100;
    public static final int     GPS_REQUEST = 101;
    public static final int     GPS_UPDATE_INTERVAL = 10000;
    public static final int     GPS_FASTEST_INTERVAL = 5000;
    public final static float   DEFAULT_ZOOM = 5.0f;
    public final static float   DEFAULT_MIN_ZOOM = 4f;
    public final static float   DEFAULT_MAX_ZOOM = 12f;

    /**
     * Other
     **/
    public static boolean       isInternetConnected = false;
    public static boolean       isChartAnimationShowed = false;
    public static final int     STORAGE_REQUEST = 110;
    public static final long    SPLASH_TIMING = 3000;
    public static final String  PLAY_STORE_URL_PREFIX = "https://play.google.com/store/apps/details?id=";
    public static int           fragmentId = 0;

    /**
     * Intent key
     **/
    public static final String CASE_OVERVIEW_BUNDLE_KEY = "caseInfoKey";
    public static final String TOPIC_DETAILS_BUNDLE_KEY = "topicDetailsKey";
    public static final String TOPIC_ID_BUNDLE_KEY = "topicIdKey";
    public static final String VIDEO_TITLE_INTENT_KEY = "videoTitleKey";
    public static final String VIDEO_LINK_INTENT_KEY = "videoLinkKey";

    /**
     * Firebase Table
     **/
    public static final String NOTIFICATION_TABLE = "Notifications";
    public static final String TOPICS_TABLE = "Topics";
    public static final String VIDEOS_TABLE = "Videos";
}
