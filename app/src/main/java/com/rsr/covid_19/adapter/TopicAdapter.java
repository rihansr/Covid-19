package com.rsr.covid_19.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rsr.covid_19.R;
import com.rsr.covid_19.fragment.TopicDetailsFragment;
import com.rsr.covid_19.model.topic.Topic;
import com.rsr.covid_19.util.SharedPreference;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"SetTextI18n"})
public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {

    private Context     mContext;
    private List<Topic> topics = new ArrayList<>();

    public TopicAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<Topic> topics) {
        this.topics = topics;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_topic, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private View                itemView;
        private AppCompatTextView   title;
        private RecyclerView        rcvSliderDetails;

        private ViewHolder(View v) {
            super(v);
            itemView = v.findViewById(R.id.itemView);
            title = v.findViewById(R.id.title);
            rcvSliderDetails = v.findViewById(R.id.rcvSliderDetails);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final TopicAdapter.ViewHolder holder, final int position) {
        final Topic topic = topics.get(position);

        holder.title.setText(new SharedPreference(mContext).isLanguageEnglish()? topic.getTitle_En() : topic.getTitle_Bn());

        holder.rcvSliderDetails.setNestedScrollingEnabled(false);
        holder.rcvSliderDetails.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        TopicDetailsAdapter topicDetailsAdapter = new TopicDetailsAdapter(mContext);
        holder.rcvSliderDetails.setAdapter(topicDetailsAdapter);
        topicDetailsAdapter.setAdapterData(topic.getDetails());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopicDetailsFragment.show((AppCompatActivity) mContext, topic, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }
}
