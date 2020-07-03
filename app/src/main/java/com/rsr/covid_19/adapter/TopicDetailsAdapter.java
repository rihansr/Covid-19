package com.rsr.covid_19.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rsr.covid_19.R;
import com.rsr.covid_19.model.topic.TopicDetails;
import com.rsr.covid_19.util.SharedPreference;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"SetTextI18n"})
public class TopicDetailsAdapter extends RecyclerView.Adapter<TopicDetailsAdapter.ViewHolder> {

    private Context               mContext;
    private List<TopicDetails> topicDetails = new ArrayList<>();

    public TopicDetailsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<TopicDetails> topicDetails) {
        this.topicDetails = topicDetails;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopicDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_topic_details, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView  iconLeft;
        private AppCompatTextView   details;
        private AppCompatImageView  iconRight;

        private ViewHolder(View v) {
            super(v);
            iconLeft = v.findViewById(R.id.iconLeft);
            details = v.findViewById(R.id.details);
            iconRight = v.findViewById(R.id.iconRight);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final TopicDetailsAdapter.ViewHolder holder, final int position) {
        final TopicDetails details = topicDetails.get(position);

        holder.details.setText(new SharedPreference(mContext).isLanguageEnglish()? details.getSubDetails_En() : details.getSubDetails_Bn());

        holder.iconLeft.getLayoutParams().height =(int) mContext.getResources().getDimension(details.isSmallIcon() ? R.dimen.slider_Icon_Size_Small : R.dimen.slider_Icon_Size_Large);
        holder.iconLeft.getLayoutParams().width =(int) mContext.getResources().getDimension(details.isSmallIcon() ? R.dimen.slider_Icon_Size_Small : R.dimen.slider_Icon_Size_Large);
        holder.iconLeft.requestLayout();
        holder.iconLeft.setVisibility(details.getIcon() != null
                ?
                details.isRightPosition() ? View.GONE : View.VISIBLE
                :
                View.GONE);

        holder.iconRight.getLayoutParams().height =(int) mContext.getResources().getDimension(details.isSmallIcon() ? R.dimen.slider_Icon_Size_Small : R.dimen.slider_Icon_Size_Large);
        holder.iconRight.getLayoutParams().width =(int) mContext.getResources().getDimension(details.isSmallIcon() ? R.dimen.slider_Icon_Size_Small : R.dimen.slider_Icon_Size_Large);
        holder.iconRight.requestLayout();
        holder.iconRight.setVisibility(details.getIcon() != null
                ?
                details.isRightPosition() ? View.VISIBLE : View.GONE
                :
                View.GONE);

        Glide.with(mContext)
                .load(details.getIcon())
                .override((int)mContext.getResources().getDimension(details.isSmallIcon() ? R.dimen.slider_Icon_Size_Small : R.dimen.slider_Icon_Size_Large),
                        (int)mContext.getResources().getDimension(details.isSmallIcon() ? R.dimen.slider_Icon_Size_Small : R.dimen.slider_Icon_Size_Large))
                .error(R.drawable.ic_logo)
                .fallback(R.drawable.ic_logo)
                .into(details.isRightPosition() ? holder.iconRight : holder.iconLeft);
    }

    @Override
    public int getItemCount() {
        return topicDetails.size();
    }
}
