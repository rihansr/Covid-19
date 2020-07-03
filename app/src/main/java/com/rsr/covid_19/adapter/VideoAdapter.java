package com.rsr.covid_19.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rsr.covid_19.R;
import com.rsr.covid_19.activity.PlayerActivity;
import com.rsr.covid_19.fragment.TopicDetailsFragment;
import com.rsr.covid_19.model.video.VideoModel;
import com.rsr.covid_19.util.Constants;
import com.rsr.covid_19.util.SharedPreference;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private Context             mContext;
    private List<VideoModel>    videos = new ArrayList<>();

    public VideoAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<VideoModel> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_video, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageButton    infoBtn;
        private AppCompatImageButton    playBtn;
        private AppCompatImageView      thumbnail;
        private AppCompatTextView       duration;
        private CircleImageView         icon;
        private AppCompatTextView       title;
        private AppCompatTextView       message;

        private ViewHolder(View v) {
            super(v);
            infoBtn = v.findViewById(R.id.infoBtn);
            playBtn = v.findViewById(R.id.playBtn);
            thumbnail = v.findViewById(R.id.thumbnail);
            duration = v.findViewById(R.id.duration);
            icon = v.findViewById(R.id.icon);
            title = v.findViewById(R.id.title);
            message = v.findViewById(R.id.message);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoAdapter.ViewHolder holder, final int position) {
        SharedPreference sp = new SharedPreference(mContext);
        final VideoModel video = videos.get(position);

        holder.infoBtn.setVisibility(video.getInfo() == null ? View.GONE : View.VISIBLE);
        holder.infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopicDetailsFragment.show((AppCompatActivity) mContext, null, video.getInfo());
            }
        });

        holder.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayerActivity.class);
                intent.putExtra(Constants.VIDEO_TITLE_INTENT_KEY, sp.isLanguageEnglish()? video.getTitle_En() : video.getTitle_Bn());
                intent.putExtra(Constants.VIDEO_LINK_INTENT_KEY, sp.isLanguageEnglish()? video.getUrl_En() : video.getUrl_Bn());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.isMemoryCacheable();
        Glide.with(mContext)
                .setDefaultRequestOptions(requestOptions)
                .load(video.getThumbnail() != null ? video.getThumbnail() : (sp.isLanguageEnglish()? video.getUrl_En() : video.getUrl_Bn()))
                .into(holder.thumbnail);

        holder.duration.setText(sp.isLanguageEnglish() ? video.getDuration_En() : video.getDuration_Bn());

        holder.icon.setVisibility(video.getIcon() == null ? View.GONE : View.VISIBLE);
        holder.title.setText(sp.isLanguageEnglish()? video.getTitle_En() : video.getTitle_Bn());
        holder.message.setVisibility(video.getMessage_Bn() != null && video.getMessage_En() != null ? View.VISIBLE : View.GONE);
        holder.message.setText(sp.isLanguageEnglish() ? video.getMessage_En() : video.getMessage_Bn());
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
