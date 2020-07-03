package com.rsr.covid_19.util;

import android.content.Context;

public class SharedPreference {

    private Context context;
    private final String LANGUAGE_SP_NAME = "language";
    private final String LANGUAGE_SP_KEY = "languageSpKey";
    private final String NOTIFICATION_COUNT_SP_NAME = "isNotificationPermissionForbid";
    private final String NOTIFICATION_COUNT_SP_KEY = "forbidSpKey";
    private final String OVERVIEW_SP_NAME = "overview";
    private final String OVERVIEW_SP_KEY = "overviewSpKey";

    public SharedPreference(Context context) {
        this.context = context;
    }

    public void setLanguageMode(boolean state){
        context.getSharedPreferences(LANGUAGE_SP_NAME, Context.MODE_PRIVATE).edit().putBoolean(LANGUAGE_SP_KEY, state).apply();
    }

    public boolean isLanguageEnglish(){
        return context.getSharedPreferences(LANGUAGE_SP_NAME, Context.MODE_PRIVATE).getBoolean(LANGUAGE_SP_KEY,true);
    }

    public void setNotificationCount(int count){
        context.getSharedPreferences(NOTIFICATION_COUNT_SP_NAME, Context.MODE_PRIVATE).edit().putInt(NOTIFICATION_COUNT_SP_KEY, count).apply();
    }

    public int getNotificationCount(){
        return context.getSharedPreferences(NOTIFICATION_COUNT_SP_NAME, Context.MODE_PRIVATE).getInt(NOTIFICATION_COUNT_SP_KEY,0);
    }

    public void setOverviewData(String data){
        context.getSharedPreferences(OVERVIEW_SP_NAME, Context.MODE_PRIVATE).edit().putString(OVERVIEW_SP_KEY, data).apply();
    }

    public String getOverviewData(){
        return context.getSharedPreferences(OVERVIEW_SP_NAME, Context.MODE_PRIVATE).getString(OVERVIEW_SP_KEY,null);
    }
}
