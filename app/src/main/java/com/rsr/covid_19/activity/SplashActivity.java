package com.rsr.covid_19.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.rsr.covid_19.R;
import com.rsr.covid_19.receiver.NetworkStatusChangeReceiver;
import com.rsr.covid_19.util.Constants;
import com.rsr.covid_19.util.SharedPreference;
import com.rsr.covid_19.util.extension.AppExtension;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class SplashActivity extends AppCompatActivity {

    private boolean                     isSplashDone = false;
    private LottieAnimationView         loader;
    private AppCompatTextView           networkCheckingTv;
    private NetworkStatusChangeReceiver networkStatusChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(new SharedPreference(this).isLanguageEnglish()) AppExtension.setLocale(this,"en");
        else AppExtension.setLocale(this,"bn");
        setContentView(R.layout.activity_splash);

        init();

        setSplashTimer();
    }


    /**
     * {@link #onResume()} called when the activity is in the resumed state
     **/
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkStatusChangeReceiver, new IntentFilter(CONNECTIVITY_ACTION));
    }


    /**
     * {@link #onPause()} called when an activity is about to lose focus
     **/
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkStatusChangeReceiver);
    }

    private void init(){
        loader = findViewById(R.id.loader);
        networkCheckingTv = findViewById(R.id.networkCheckingTv);
        networkStatusChangeReceiver = new NetworkStatusChangeReceiver();
    }


    /**
     *  Show splash screen for {@link Constants/SPLASH_TIMING} 2 seconds
     **/
    private void setSplashTimer(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Constants.isInternetConnected) {
                    launchNewActivity();
                }
                else {
                    loader.setVisibility(View.VISIBLE);
                    networkCheckingTv.setVisibility(View.VISIBLE);
                }

                isSplashDone = true;
            }
        }, Constants.SPLASH_TIMING);
    }


    /**
     * Go to {@link HomeActivity}
     **/
    private void launchNewActivity() {
        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


    /**
     *  {@link NetworkStatusChangeReceiver} Monitor internet connection
     **/
    public void updateInternetConnectionStatus(boolean isConnected) {
        if (isConnected) {
            if(isSplashDone){
                launchNewActivity();
            }
        }
    }
}
