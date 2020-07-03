package com.rsr.covid_19.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.Circle;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.snackbar.Snackbar;
import com.rsr.covid_19.R;
import com.rsr.covid_19.receiver.NetworkStatusChangeReceiver;
import com.rsr.covid_19.util.Constants;
import com.rsr.covid_19.util.CustomSnackBar;
import com.rsr.covid_19.util.SharedPreference;
import com.rsr.covid_19.util.extension.AppExtension;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class PlayerActivity extends AppCompatActivity implements Player.EventListener{

    private final String                TAG = "Hell";
    private FrameLayout                 root_Layout;
    private SimpleExoPlayer             player;
    private PlayerView                  playerView;
    private ProgressBar                 loadingProgress;
    private long                        playbackPosition;
    private int                         currentWindow;
    private long                        bufferedPosition;
    private boolean                     playWhenReady = true;
    private MediaSource                 mediaSource;
    private LinearLayoutCompat          playbackButtonsAll;
    private AppCompatTextView           titleTextView;
    private String                      url;
    private boolean                     doubleBackToExitPressedOnce = false;
    private NetworkStatusChangeReceiver networkStatusChangeReceiver;
    private final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(new SharedPreference(this).isLanguageEnglish()) AppExtension.setLocale(this,"en");
        else AppExtension.setLocale(this,"bn");
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_player);

        initId();

        init();
    }

    private void initId(){
        root_Layout = findViewById(R.id.root_Layout);
        playerView = findViewById(R.id.video_view);
        loadingProgress = findViewById(R.id.loading);
        loadingProgress.setIndeterminateDrawable(new Circle());
        playbackButtonsAll = findViewById(R.id.playback_buttons);
        titleTextView = findViewById(R.id.videoTitle);
    }

    private void init(){
        networkStatusChangeReceiver = new NetworkStatusChangeReceiver();

        findViewById(R.id.img_btn_player_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titleTextView.setText(getIntent().getStringExtra(Constants.VIDEO_TITLE_INTENT_KEY));
        url = getIntent().getStringExtra(Constants.VIDEO_LINK_INTENT_KEY);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT > 23) {
            initializePlayer();
            Log.i(TAG, "onStart SDK > 23");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(networkStatusChangeReceiver, new IntentFilter(CONNECTIVITY_ACTION));
        if ((Util.SDK_INT <= 23 || player == null)) {
            Log.i(TAG, "onResume If");
            initializePlayer();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(networkStatusChangeReceiver);

        if (Util.SDK_INT <= 23) {
            Log.i(TAG, "onPause SDK <= 23");
            releasePlayer();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            releasePlayer();
            Log.i(TAG, "onStop SDK > 23");
        }
    }

    private void initializePlayer() {
        DefaultTrackSelector trackSelector = new DefaultTrackSelector();

        // Build on the current parameters.
        DefaultTrackSelector.Parameters currentParameters = trackSelector.getParameters();

        // Build the resulting parameters.
        DefaultTrackSelector.Parameters newParameters = currentParameters
                .buildUpon()
                .setMaxVideoSizeSd()
                .setPreferredAudioLanguage("en")
                .setMaxVideoBitrate(Integer.MAX_VALUE)
                .build();

        // Set the new parameters.
        trackSelector.setParameters(newParameters);

        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(this, DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON), trackSelector, new DefaultLoadControl());
            loadingProgress.setVisibility(View.VISIBLE);
            playbackButtonsAll.setVisibility(View.GONE);
            playerView.setPlayer(player);
            player.setPlayWhenReady(playWhenReady);
            Log.i(TAG, "initializePlayer: current window " + currentWindow + " current position " + playbackPosition);
            player.seekTo(currentWindow, playbackPosition);
        }

        mediaSource = buildMediaSource(Uri.parse(url));
        player.prepare(mediaSource, false, false);
        player.addListener(this);
    }

    private void releasePlayer() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            Log.i(TAG, "releasePlayer: playbackPosition " + playbackPosition);
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
            player.release();
            player = null;
        }
    }

    private MediaSource buildMediaSource(Uri uri) {
        final String userAgent = "rs-exoplayer";

        if (uri.getLastPathSegment().contains("mp3") || uri.getLastPathSegment().contains("mp4") || uri.getLastPathSegment().contains("mkv")) {
            return new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent)).createMediaSource(uri);
        }
        else if (uri.getLastPathSegment().contains("m3u8")) {
            return new HlsMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent)).createMediaSource(uri);
        }
        else {
            DashChunkSource.Factory dashChunkSourceFactory = new DefaultDashChunkSource.Factory(new DefaultHttpDataSourceFactory(userAgent, BANDWIDTH_METER));
            DataSource.Factory manifestDataSourceFactory = new DefaultHttpDataSourceFactory(userAgent);
            return new DashMediaSource.Factory(dashChunkSourceFactory, manifestDataSourceFactory).createMediaSource(uri);
        }
    }

    @Override
    public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {}

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {}

    @Override
    public void onLoadingChanged(boolean isLoading) {}

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        String stateString;
        switch (playbackState) {
            case Player.STATE_IDLE:
                loadingProgress.setVisibility(View.VISIBLE);
                playbackButtonsAll.setVisibility(View.INVISIBLE);
                playbackPosition = bufferedPosition;
                Log.i(TAG, "onPlayerStateChanged: " + playbackPosition);
                stateString = "ExoPlayer.STATE_IDLE      -";
                break;

            case Player.STATE_BUFFERING:
                playbackButtonsAll.setVisibility(View.INVISIBLE);
                loadingProgress.setVisibility(View.VISIBLE);
                stateString = "ExoPlayer.STATE_BUFFERING -";
                break;

            case Player.STATE_READY:
                playbackButtonsAll.setVisibility(View.VISIBLE);
                loadingProgress.setVisibility(View.INVISIBLE);
                stateString = "ExoPlayer.STATE_READY     -";
                break;

            case Player.STATE_ENDED:
                stateString = "ExoPlayer.STATE_ENDED     -";
                break;

            default:
                stateString = "UNKNOWN_STATE             -";
                break;
        }

        Log.i(TAG, "changed state to " + stateString + " playWhenReady: " + playWhenReady);

        if (playbackState == Player.STATE_IDLE || playbackState == Player.STATE_ENDED || !playWhenReady) {

            playerView.setKeepScreenOn(false);
        }
        else {
            // STATE_IDLE, STATE_ENDED
            // This prevents the screen from getting dim/lock
            playerView.setKeepScreenOn(true);
        }
    }

    @Override
    public void onRepeatModeChanged(int repeatMode) {}

    @Override
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {}

    @Override
    public void onPlayerError(ExoPlaybackException error) {}

    @Override
    public void onPositionDiscontinuity(int reason) {}

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {}

    @Override
    public void onSeekProcessed() {}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        releasePlayer();
    }

    public void updateInternetConnectionStatus(Boolean isConnected) {
        if (isConnected) {
            Log.i(TAG, "updateInternetConnectionStatusView: Connected");
            Log.i(TAG, "updateInternetConnectionStatusView: " + playbackPosition);
            player.seekTo(currentWindow, playbackPosition);
            player.prepare(mediaSource, false, false);
            if(CustomSnackBar.snackbar != null) CustomSnackBar.snackbar.dismiss();
        }
        else {
            Log.i(TAG, "updateInternetConnectionStatusView: Connected");
            playbackPosition = player.getCurrentPosition();
            bufferedPosition = player.getBufferedPosition();
            Log.i(TAG, "updateInternetConnectionStatusView: " + playbackPosition);
            Log.i(TAG, "updateInternetConnectionStatusView: " + player.getBufferedPosition());

            CustomSnackBar snackbar = new CustomSnackBar(PlayerActivity.this,
                    root_Layout,
                    getResources().getString(R.string.network_Error),
                    getResources().getString(R.string.retry),
                    CustomSnackBar.Duration.INDEFINITE
            );
            snackbar.show();
            snackbar.setOnDismissListener(new CustomSnackBar.OnDismissListener() {
                @Override
                public void onDismiss(Snackbar snackbar) {
                    networkStatusChangeReceiver.onReceive(PlayerActivity.this, null);
                    snackbar.dismiss();
                }
            });
        }
    }
}
