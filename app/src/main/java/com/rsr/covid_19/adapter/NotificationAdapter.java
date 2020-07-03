package com.rsr.covid_19.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rsr.covid_19.R;
import com.rsr.covid_19.activity.PlayerActivity;
import com.rsr.covid_19.model.notification.Notification;
import com.rsr.covid_19.util.Constants;
import com.rsr.covid_19.util.SharedPreference;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

@SuppressLint({"SetTextI18n"})
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private Context             mContext;
    private List<Notification>  notifications = new ArrayList<>();

    public NotificationAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<Notification> notifications) {
        this.notifications = notifications;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_notification, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView         icon;
        private AppCompatTextView       title;
        private AppCompatTextView       message;
        private AppCompatTextView       date;
        private RecyclerView            rcvPhotos;
        private FrameLayout             videoHolder;
        private AppCompatImageView      thumbnail;
        private AppCompatImageButton    playBtn;

        private ViewHolder(View v) {
            super(v);
            icon = v.findViewById(R.id.icon);
            title = v.findViewById(R.id.title);
            message = v.findViewById(R.id.message);
            date = v.findViewById(R.id.date);
            rcvPhotos = v.findViewById(R.id.rcvPhotos);
            videoHolder = v.findViewById(R.id.videoHolder);
            thumbnail = v.findViewById(R.id.thumbnail);
            playBtn = v.findViewById(R.id.playBtn);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final NotificationAdapter.ViewHolder holder, final int position) {
        SharedPreference sp = new SharedPreference(mContext);
        final Notification notification = notifications.get(position);

        if(notification.getIcon() != null){
            Glide.with(mContext)
                    .load(notification.getIcon())
                    .override((int) mContext.getResources().getDimension(R.dimen.icon_Size_Large),
                            (int) mContext.getResources().getDimension(R.dimen.icon_Size_Large))
                    .error(R.drawable.ic_notification)
                    .fallback(R.drawable.ic_notification)
                    .into(holder.icon);
        }

        holder.title.setText(sp.isLanguageEnglish()? notification.getTitle_En() : notification.getTitle_Bn());
        holder.message.setText(sp.isLanguageEnglish()? notification.getMessage_En() : notification.getMessage_Bn());

        long time = notification.getDate();
        long now = System.currentTimeMillis();
        CharSequence ago = DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS);
        holder.date.setText(ago);

        if(notification.getPhotos() != null && notification.getPhotos().size() != 0){
            holder.rcvPhotos.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
            PhotoAdapter photoAdapter = new PhotoAdapter(mContext);
            holder.rcvPhotos.setAdapter(photoAdapter);
            photoAdapter.setPhotoPaths(notification.getPhotos());
        }

        if(notification.getVideoLink() != null){
            holder.videoHolder.setVisibility(View.VISIBLE);

            holder.playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, PlayerActivity.class);
                    intent.putExtra(Constants.VIDEO_TITLE_INTENT_KEY, sp.isLanguageEnglish()? notification.getVideoTitle_En() : notification.getVideoTitle_Bn());
                    intent.putExtra(Constants.VIDEO_LINK_INTENT_KEY, notification.getVideoLink());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.isMemoryCacheable();
            Glide.with(mContext)
                    .setDefaultRequestOptions(requestOptions)
                    .load(notification.getVideoLink())
                    .into(holder.thumbnail);
        }
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }
}
