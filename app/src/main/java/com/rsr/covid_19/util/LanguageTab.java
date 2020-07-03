package com.rsr.covid_19.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.android.material.tabs.TabLayout;
import com.rsr.covid_19.util.extension.AppExtension;

import java.util.Objects;

public class LanguageTab implements TabLayout.OnTabSelectedListener {
    private Context mContext;
    private TabLayout mTabLayout;

    public LanguageTab(Context mContext, TabLayout mTabLayout) {
        this.mContext = mContext;
        this.mTabLayout = mTabLayout;
        init();
    }

    private void init() {
        if(new SharedPreference(mContext).isLanguageEnglish()) {
            Objects.requireNonNull(mTabLayout.getTabAt(0)).select();
        }
        else {
            Objects.requireNonNull(mTabLayout.getTabAt(1)).select();
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                new SharedPreference(mContext).setLanguageMode(true);
                AppExtension.setLocale(mContext,"en");
                Refresh_Activity();
                break;

            case 1:
                new SharedPreference(mContext).setLanguageMode(false);
                AppExtension.setLocale(mContext,"bn");
                Refresh_Activity();
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {}

    @Override
    public void onTabReselected(TabLayout.Tab tab) {}


    private void Refresh_Activity() {
        Intent intent = new Intent(mContext, mContext.getClass());
        ((Activity) mContext).finish();
        mContext.startActivity(intent);
    }
}
