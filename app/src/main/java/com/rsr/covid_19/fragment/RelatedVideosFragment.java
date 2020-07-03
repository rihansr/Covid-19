package com.rsr.covid_19.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rsr.covid_19.R;
import com.rsr.covid_19.activity.HomeActivity;
import com.rsr.covid_19.adapter.VideoAdapter;
import com.rsr.covid_19.model.video.VideoModel;
import com.rsr.covid_19.util.Constants;

import java.util.ArrayList;

import static com.rsr.covid_19.activity.HomeActivity.infoBtn;
import static com.rsr.covid_19.activity.HomeActivity.loader;
import static com.rsr.covid_19.activity.HomeActivity.toolbarTitle;

public class RelatedVideosFragment extends Fragment {

    private Context         context;
    private RecyclerView    rcvVideos;
    private VideoAdapter    videoAdapter;

    public RelatedVideosFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_related_videos, container, false);
        initId(view);

        init();

        setAdapter();

        return view;
    }

    private void initId(View view) {
        rcvVideos = view.findViewById(R.id.rcvVideos);
    }

    private void setAdapter() {
        rcvVideos.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        videoAdapter = new VideoAdapter(context);
        rcvVideos.setAdapter(videoAdapter);
    }

    private void init() {
        loader.setVisibility(View.GONE);
        HomeActivity.setShimmer(R.layout.sample_video_shimmer, 4, false);
        infoBtn.setEnabled(false);
        infoBtn.setVisibility(View.INVISIBLE);
        toolbarTitle.setText(context.getResources().getString(R.string.relatedVideos));

        FirebaseDatabase.getInstance().getReference(Constants.VIDEOS_TABLE)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ArrayList<VideoModel> videos = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            VideoModel video = snapshot.getValue(VideoModel.class);
                            if (video == null) continue;
                            videos.add(video);
                        }

                        HomeActivity.removeShimmer();
                        videoAdapter.setAdapterData(videos);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        databaseError.toException().printStackTrace();
                        HomeActivity.removeShimmer();
                    }
                });
    }

    /**
     *  Context Bind
     **/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
