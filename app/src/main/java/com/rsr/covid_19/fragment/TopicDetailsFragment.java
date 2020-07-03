package com.rsr.covid_19.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.style.Circle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rsr.covid_19.R;
import com.rsr.covid_19.adapter.TopicDetailsAdapter;
import com.rsr.covid_19.model.topic.Topic;
import com.rsr.covid_19.model.topic.TopicHost;
import com.rsr.covid_19.util.Constants;
import com.rsr.covid_19.util.SharedPreference;
import com.rsr.covid_19.util.extension.AppExtension;

import java.util.ArrayList;

import static com.rsr.covid_19.activity.HomeActivity.loader;

@SuppressLint("ClickableViewAccessibility, SetTextI18n")
public class TopicDetailsFragment extends DialogFragment {

    private static final String TAG = TopicDetailsFragment.class.getSimpleName();
    private Context             mContext;
    private LinearLayoutCompat  toolBar;
    private AppCompatTextView   topicTitle;
    private ProgressBar         loader;
    private RecyclerView        rcvTopicDetails;
    private TopicDetailsAdapter topicDetailsAdapter;

    public static TopicDetailsFragment show(@NonNull AppCompatActivity appCompatActivity, Topic topic, String topicId){
        TopicDetailsFragment fragment = new TopicDetailsFragment();
        if(topic != null || topicId != null){
            Bundle args = new Bundle();
            if(topic != null) args.putSerializable(Constants.TOPIC_DETAILS_BUNDLE_KEY, topic);
            else args.putString(Constants.TOPIC_ID_BUNDLE_KEY, topicId);
            fragment.setArguments(args);
        }
        fragment.show(appCompatActivity.getSupportFragmentManager(), TAG);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setCancelable(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        AppExtension.halfScreenDialog(getDialog());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_topic_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initId(view);

        if (getArguments() == null) { dismiss(); return; }
        Topic topic = (Topic) getArguments().getSerializable(Constants.TOPIC_DETAILS_BUNDLE_KEY);
        String topicId = getArguments().getString(Constants.TOPIC_ID_BUNDLE_KEY);

        if (topic == null && topicId == null){ dismiss(); return; }
        init(topic, topicId);
        getArguments().remove(Constants.TOPIC_DETAILS_BUNDLE_KEY);
    }

    private void initId(View view) {
        toolBar = view.findViewById(R.id.toolBar);
        topicTitle = view.findViewById(R.id.topicTitle);
        rcvTopicDetails = view.findViewById(R.id.rcvTopicDetails);
        loader = view.findViewById(R.id.loader);
    }

    private void init(Topic topic, String topicId){
        loader.setIndeterminateDrawable(new Circle());

        toolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        setAdapter();

        if(topic != null){
            if(new SharedPreference(mContext).isLanguageEnglish()){
                topicTitle.setVisibility(topic.getTitle_En() == null ? View.GONE : View.VISIBLE);
                topicTitle.setText(topic.getTitle_En());
            }
            else {
                topicTitle.setVisibility(topic.getTitle_Bn() == null ? View.GONE : View.VISIBLE);
                topicTitle.setText(topic.getTitle_Bn());
            }

            topicDetailsAdapter.setAdapterData(topic.getDetails());
        }
        else {
            loader.setVisibility(View.VISIBLE);

            FirebaseDatabase.getInstance().getReference().child(topicId)
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            loader.setVisibility(View.GONE);

                            if(dataSnapshot.exists()){
                                Topic topic = dataSnapshot.getValue(Topic.class);
                                if(topic == null) {dismiss(); return;}

                                if(new SharedPreference(mContext).isLanguageEnglish()){
                                    topicTitle.setVisibility(topic.getTitle_En() == null ? View.GONE : View.VISIBLE);
                                    topicTitle.setText(topic.getTitle_En());
                                }
                                else {
                                    topicTitle.setVisibility(topic.getTitle_Bn() == null ? View.GONE : View.VISIBLE);
                                    topicTitle.setText(topic.getTitle_Bn());
                                }

                                topicDetailsAdapter.setAdapterData(topic.getDetails());
                            }
                            else {
                                dismiss();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            databaseError.toException().printStackTrace();
                            loader.setVisibility(View.GONE);
                            dismiss();
                        }
                    });
        }
    }

    private void setAdapter() {
        rcvTopicDetails.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        topicDetailsAdapter = new TopicDetailsAdapter(mContext);
        rcvTopicDetails.setAdapter(topicDetailsAdapter);
    }

    /**
     *  Context Bind
     **/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
