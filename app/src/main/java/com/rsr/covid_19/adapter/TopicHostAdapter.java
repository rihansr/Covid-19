package com.rsr.covid_19.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rsr.covid_19.R;
import com.rsr.covid_19.model.topic.TopicHost;
import com.rsr.covid_19.util.SharedPreference;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"SetTextI18n"})
public class TopicHostAdapter extends RecyclerView.Adapter<TopicHostAdapter.ViewHolder> {

    private Context            mContext;
    private List<TopicHost> topicHosts = new ArrayList<>();

    public TopicHostAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<TopicHost> topicHosts) {
        this.topicHosts = topicHosts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicHostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_topic_host, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView   title;
        private RecyclerView        rcvSliderHosts;

        private ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            rcvSliderHosts = v.findViewById(R.id.rcvSliders);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final TopicHostAdapter.ViewHolder holder, final int position) {
        final TopicHost topicHost = topicHosts.get(position);

        holder.title.setText(new SharedPreference(mContext).isLanguageEnglish()? topicHost.getTitle_En() : topicHost.getTitle_Bn());

        holder.rcvSliderHosts.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        TopicAdapter topicAdapter = new TopicAdapter(mContext);
        holder.rcvSliderHosts.setAdapter(topicAdapter);
        topicAdapter.setAdapterData(topicHost.getTopics());
    }

    @Override
    public int getItemCount() {
        return topicHosts.size();
    }
}
