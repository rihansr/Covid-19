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
import com.rsr.covid_19.adapter.NotificationAdapter;
import com.rsr.covid_19.model.notification.Notification;
import com.rsr.covid_19.util.Constants;
import com.rsr.covid_19.util.SharedPreference;

import java.util.ArrayList;

import static com.rsr.covid_19.activity.HomeActivity.infoBtn;
import static com.rsr.covid_19.activity.HomeActivity.loader;
import static com.rsr.covid_19.activity.HomeActivity.toolbarTitle;

public class NotificationFragment extends Fragment {

    private Context             context;
    private RecyclerView        rcvFaq;
    private NotificationAdapter notificationAdapter;

    public NotificationFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        initId(view);

        init();

        setAdapter();

        return view;
    }

    private void initId(View view) {
        rcvFaq = view.findViewById(R.id.rcvFaq);
    }

    private void init() {
        loader.setVisibility(View.GONE);
        HomeActivity.setShimmer(R.layout.sample_notification_shimmer, 10, false);
        infoBtn.setEnabled(false);
        infoBtn.setVisibility(View.INVISIBLE);
        toolbarTitle.setText(context.getResources().getString(R.string.notification));

        FirebaseDatabase.getInstance().getReference(Constants.NOTIFICATION_TABLE)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ArrayList<Notification> notifications = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Notification notification = snapshot.getValue(Notification.class);
                            if (notification == null) continue;
                            notifications.add(notification);
                        }

                        HomeActivity.removeShimmer();
                        new SharedPreference(context).setNotificationCount(notifications.size());
                        notificationAdapter.setAdapterData(notifications);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        databaseError.toException().printStackTrace();
                        HomeActivity.removeShimmer();
                    }
                });
    }

    private void setAdapter() {
        rcvFaq.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        notificationAdapter = new NotificationAdapter(context);
        rcvFaq.setAdapter(notificationAdapter);
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
