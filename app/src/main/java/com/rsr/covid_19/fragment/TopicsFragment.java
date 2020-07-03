package com.rsr.covid_19.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.Circle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rsr.covid_19.R;
import com.rsr.covid_19.activity.HomeActivity;
import com.rsr.covid_19.adapter.TopicHostAdapter;
import com.rsr.covid_19.model.topic.TopicHost;
import com.rsr.covid_19.util.Constants;

import java.util.ArrayList;

import static com.rsr.covid_19.activity.HomeActivity.infoBtn;
import static com.rsr.covid_19.activity.HomeActivity.loader;
import static com.rsr.covid_19.activity.HomeActivity.toolbarTitle;

public class TopicsFragment extends Fragment {

    private Context          context;
    private RecyclerView     rcvSliderHosts;
    private TopicHostAdapter topicAdapter;

    public TopicsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topics, container, false);

        initId(view);

        init();

        setAdapter();

        return view;
    }

    private void initId(View view) {
        rcvSliderHosts = view.findViewById(R.id.rcvSliderHosts);
    }

    private void setAdapter() {
        rcvSliderHosts.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        topicAdapter = new TopicHostAdapter(context);
        rcvSliderHosts.setAdapter(topicAdapter);
    }

    private void init() {
        loader.setVisibility(View.GONE);
        HomeActivity.setShimmer(R.layout.sample_topic_shimmer, 3, false);
        infoBtn.setEnabled(false);
        infoBtn.setVisibility(View.INVISIBLE);
        toolbarTitle.setText(context.getResources().getString(R.string.covid19));

        FirebaseDatabase.getInstance().getReference(Constants.TOPICS_TABLE)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ArrayList<TopicHost> topicHosts = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            TopicHost topicHost = snapshot.getValue(TopicHost.class);
                            if (topicHost == null) continue;
                            topicHosts.add(topicHost);
                        }

                        HomeActivity.removeShimmer();
                        topicAdapter.setAdapterData(topicHosts);
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
