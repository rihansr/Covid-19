package com.rsr.covid_19.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.github.ybq.android.spinkit.style.Circle;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rsr.covid_19.R;
import com.rsr.covid_19.fragment.CasesMapFragment;
import com.rsr.covid_19.fragment.DailyCasesFragment;
import com.rsr.covid_19.fragment.NotificationFragment;
import com.rsr.covid_19.fragment.GlobalCasesFragment;
import com.rsr.covid_19.fragment.OverviewFragment;
import com.rsr.covid_19.fragment.RelatedVideosFragment;
import com.rsr.covid_19.fragment.TopicsFragment;
import com.rsr.covid_19.model.notification.Notification;
import com.rsr.covid_19.model.video.VideoModel;
import com.rsr.covid_19.receiver.NetworkStatusChangeReceiver;
import com.rsr.covid_19.util.Constants;
import com.rsr.covid_19.util.CustomSnackBar;
import com.rsr.covid_19.util.LanguageTab;
import com.rsr.covid_19.util.SharedPreference;
import com.rsr.covid_19.util.SliderData;
import com.rsr.covid_19.util.extension.AppExtension;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;
import static com.rsr.covid_19.util.Constants.fragmentId;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout                drawerLayout;
    private RelativeLayout              contentView;
    private NavigationView              navigationView;
    public static AppCompatTextView     toolbarTitle;
    private AppCompatImageButton        menu;
    public static AppCompatImageButton  infoBtn;
    private TabLayout                   languageTab;
    public static LottieAnimationView   loader;
    public static LinearLayoutCompat    shimmerBanner;
    private AppCompatTextView           notificationCount;
    private DatabaseReference           notificationReference;
    private ValueEventListener          notificationListener;
    private static Context              context;
    private NetworkStatusChangeReceiver networkStatusChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(new SharedPreference(this).isLanguageEnglish()) AppExtension.setLocale(this,"en");
        else AppExtension.setLocale(this,"bn");
        setContentView(R.layout.activity_home);

        initId();

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setNotificationCount();
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

    private void initId() {
        drawerLayout = findViewById(R.id.drawerLayout);
        contentView = findViewById(R.id.contentView);
        toolbarTitle = findViewById(R.id.toolbarTitle);
        navigationView = findViewById(R.id.navigationView);
        menu = findViewById(R.id.menuBtn);
        infoBtn = findViewById(R.id.infoBtn);
        languageTab = findViewById(R.id.languageTab);
        notificationCount = findViewById(R.id.notificationCount);
        shimmerBanner = findViewById(R.id.shimmer_Container);
        context = HomeActivity.this;
        loader = findViewById(R.id.loader);
    }

    private void init() {
        switch (fragmentId) {
            case 1:
                setFragments(1, new GlobalCasesFragment());
                break;

            case 2:
                setFragments(2, new DailyCasesFragment());
                break;

            case 3:
                setFragments(3, new CasesMapFragment());
                break;

            case 4:
                setFragments(4, new TopicsFragment());
                break;

            case 5:
                setFragments(5, new RelatedVideosFragment());
                break;

            case 6:
                setFragments(6, new NotificationFragment());
                break;

            case 0:
            default:
                setFragments(7, new OverviewFragment());
        }

        networkStatusChangeReceiver = new NetworkStatusChangeReceiver();

        notificationCount.setText(new DecimalFormat().format(0));

        setDrawer();

        //addVideos1();
        //addVideos2();

        //addTopics();

        //addNotification();

        setNotificationCount();
    }

    private void addTopics() {
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-1")
                .setValue(SliderData.beReadyFoCoronaVirus());
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-2")
                .setValue(SliderData.mentalHealth());
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-3")
                .setValue(SliderData.communicatingSeveritySeries());
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-4")
                .setValue(SliderData.gettingWorkplaceReady());
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-5")
                .setValue(SliderData.protectYourself());
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-6")
                .setValue(SliderData.healthyTraveling());
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-7")
                .setValue(SliderData.socialDistance());
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-8")
                .setValue(SliderData.maskGuidance());
        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .child("SLH-9")
                .setValue(SliderData.mythsAndRumours());
    }

    private void addNotification() {
        String id = "N-1";

        Notification notification = new Notification();
        notification.setId(id);
        notification.setTitle_En("Test");
        notification.setTitle_Bn("tesh");
        notification.setMessage_En("How are you?");
        notification.setMessage_Bn("Kene solor?");
        notification.setDate(System.currentTimeMillis());
        notification.setVideoTitle_En("How to protect yourself against COVID-19?");
        notification.setVideoTitle_Bn("কোভিড-১৯ থেকে কীভাবে নিজেকে রক্ষা করবেন?");
        notification.setVideoLink("https://firebasestorage.googleapis.com/v0/b/capable-boulder-272611.appspot.com/o/videos%2Fhow_to_protect_yourself_against_covid_19_english.mp4?alt=media&token=c5bcc937-7cf5-4b3b-bea1-165874908b1f");

        FirebaseDatabase.getInstance().getReference(Constants.NOTIFICATION_TABLE)
                .child(id)
                .setValue(notification);
    }

    private void addVideos1() {
        String id = "VD-1";

        VideoModel video = new VideoModel();
        video.setId(id);
        video.setTitle_En("How to protect yourself against COVID-19?");
        video.setTitle_Bn("কোভিড-১৯ থেকে কীভাবে নিজেকে রক্ষা করবেন?");
        video.setUrl_En("https://firebasestorage.googleapis.com/v0/b/capable-boulder-272611.appspot.com/o/videos%2Fhow_to_protect_yourself_against_covid_19_english.mp4?alt=media&token=c5bcc937-7cf5-4b3b-bea1-165874908b1f");
        video.setUrl_Bn("https://firebasestorage.googleapis.com/v0/b/capable-boulder-272611.appspot.com/o/videos%2Fhow_to_protect_yourself_against_covid_19_bangla.mp4?alt=media&token=415cb578-7c66-4e45-a8e5-f69f7c0bbc03");
        video.setDuration_En("1:30");
        video.setDuration_Bn("১ঃ৫২");

        FirebaseDatabase.getInstance().getReference(Constants.VIDEOS_TABLE)
                .child(id)
                .setValue(video);
    }

    private void addVideos2() {
        String id = "VD-2";

        VideoModel video = new VideoModel();
        video.setId(id);
        video.setTitle_En("Seven steps to prevent the spread of coronavirus");
        video.setTitle_Bn("করোনাভাইরাসের বিস্তার রোধে সাতটি পদক্ষেপ");
        video.setUrl_En("https://firebasestorage.googleapis.com/v0/b/capable-boulder-272611.appspot.com/o/videos%2Fseven_steps_to_prevent_the_spread_of_the%20virus_english.mp4?alt=media&token=ade99b0d-3417-4615-b325-e22f4143e07c");
        video.setUrl_Bn("https://firebasestorage.googleapis.com/v0/b/capable-boulder-272611.appspot.com/o/videos%2Fseven_steps_to_prevent_the_spread_of_the%20virus_english.mp4?alt=media&token=ade99b0d-3417-4615-b325-e22f4143e07c");
        video.setDuration_En("0:30");
        video.setDuration_Bn("০ঃ৩০");

        FirebaseDatabase.getInstance().getReference(Constants.VIDEOS_TABLE)
                .child(id)
                .setValue(video);
    }

    private void setDrawer(){
        languageTab.addOnTabSelectedListener(new LanguageTab(this, languageTab));

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        findViewById(R.id.navOverview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().findFragmentById(R.id.hostFragment) instanceof OverviewFragment) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return;
                }
                setFragments(0, new OverviewFragment());
            }
        });

        findViewById(R.id.navGlobalCases).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().findFragmentById(R.id.hostFragment) instanceof GlobalCasesFragment) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return;
                }
                setFragments(1, new GlobalCasesFragment());
            }
        });

        findViewById(R.id.navDailyCases).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().findFragmentById(R.id.hostFragment) instanceof DailyCasesFragment) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return;
                }
                setFragments(2, new DailyCasesFragment());
            }
        });

        findViewById(R.id.navMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                if (getSupportFragmentManager().findFragmentById(R.id.hostFragment) instanceof CasesMapFragment) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return;
                }
                setFragments(3, new CasesMapFragment());
            }
        });

        findViewById(R.id.navTopics).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().findFragmentById(R.id.hostFragment) instanceof TopicsFragment) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return;
                }
                setFragments(4, new TopicsFragment());
            }
        });

        findViewById(R.id.navVideos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().findFragmentById(R.id.hostFragment) instanceof RelatedVideosFragment) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return;
                }
                setFragments(5, new RelatedVideosFragment());
            }
        });

        findViewById(R.id.navNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().findFragmentById(R.id.hostFragment) instanceof NotificationFragment) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return;
                }
                notificationCount.setText(new DecimalFormat().format(0));
                setFragments(6, new NotificationFragment());
            }
        });

        findViewById(R.id.navShare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPermissionGranted(Constants.STORAGE_REQUEST)){
                    shareApk();
                }
            }
        });

        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.setDrawerElevation(0);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                contentView.setX((navigationView.getWidth() * slideOffset));
                DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) contentView.getLayoutParams();
                contentView.setLayoutParams(params);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void setFragments(int id, Fragment fragment) {
        fragmentId = id;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.hostFragment, fragment);
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void setNotificationCount(){
        notificationReference = FirebaseDatabase.getInstance().getReference(Constants.NOTIFICATION_TABLE);

        notificationListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                SharedPreference sp = new SharedPreference(HomeActivity.this);
                if(dataSnapshot.getChildrenCount() > sp.getNotificationCount())
                    notificationCount.setText(new DecimalFormat().format(Math.abs(dataSnapshot.getChildrenCount()-sp.getNotificationCount())));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                databaseError.toException().printStackTrace();
            }
        };

        notificationReference.addValueEventListener(notificationListener);
    }

    /**
     *  Monitor Internet Connection
     **/
    public void updateInternetConnectionStatus(boolean isConnected) {
        if (isConnected) {
            if(CustomSnackBar.snackbar != null) CustomSnackBar.snackbar.dismiss();
        }
        else {
            CustomSnackBar snackbar = new CustomSnackBar(HomeActivity.this,
                    drawerLayout,
                    getResources().getString(R.string.network_Error),
                    getResources().getString(R.string.retry),
                    CustomSnackBar.Duration.INDEFINITE
            );
            snackbar.show();
            snackbar.setOnDismissListener(new CustomSnackBar.OnDismissListener() {
                @Override
                public void onDismiss(Snackbar snackbar) {
                    networkStatusChangeReceiver.onReceive(HomeActivity.this, null);
                    snackbar.dismiss();
                }
            });
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        try {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if ( v instanceof EditText) {
                    Rect outRect = new Rect();
                    v.getGlobalVisibleRect(outRect);
                    if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                        v.clearFocus();
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        if (imm != null) {
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                        }
                    }
                }
            }
            return super.dispatchTouchEvent(event);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (notificationReference != null && notificationListener != null) notificationReference.removeEventListener(notificationListener);
    }

    public static void setShimmer(int layout, int limit, boolean topSpace) {
        shimmerBanner.removeAllViews();
        shimmerBanner.setVisibility(View.VISIBLE);

        if(topSpace) shimmerBanner.addView(LayoutInflater.from(context).inflate(R.layout.sample_space_shimmer, null, false));

        for (int i = 0; i < limit; i++) {
            View inflatedLayout = LayoutInflater.from(context).inflate(layout, null, false);
            shimmerBanner.addView(inflatedLayout);
        }
    }

    public static void removeShimmer(){
        shimmerBanner.setVisibility(View.GONE);
        shimmerBanner.removeAllViews();
    }

    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        for (int i = 0; i < permissions.length; i++) {

            switch (requestCode) {
                case Constants.STORAGE_REQUEST:
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {

                        /* If user rejected the permission */
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                            if (! shouldShowRequestPermissionRationale(permissions[i])) {

                                /* If user also CHECKED "never ask again */
                                new AlertDialog.Builder(this, R.style.CustomDialogTheme)
                                        .setCancelable(true)
                                        .setTitle(HomeActivity.this.getResources().getString(R.string.storagePermissionNecessary))
                                        .setMessage(HomeActivity.this.getResources().getString(R.string.storagePermissionMessage))
                                        .setPositiveButton(HomeActivity.this.getResources().getString(R.string.openSettings), new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                                                intent.addCategory(Intent.CATEGORY_DEFAULT);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                            }
                                        })
                                        .create()
                                        .show();
                            }
                        }
                    }
                    else {
                        shareApk();
                    }
                    break;

                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    public  boolean isPermissionGranted(int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
                return false;
            }
        }
        else {
            return true;
        }
    }

    private void shareApk() {
        try {
            File initialApkFile = new File(getPackageManager().getApplicationInfo(getPackageName(), 0).sourceDir);

            File tempFile = new File(getExternalCacheDir() + "/ExtractedApk");

            if (!tempFile.isDirectory())
                if (!tempFile.mkdirs())
                    return;

            tempFile = new File(tempFile.getPath() + "/" + getResources().getString(R.string.app_name) + ".apk");

            if (!tempFile.exists()) {
                if (!tempFile.createNewFile()) {
                    return;
                }
            }

            InputStream in = new FileInputStream(initialApkFile);
            OutputStream out = new FileOutputStream(tempFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();

            AppExtension.shareFile(HomeActivity.this, tempFile);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
