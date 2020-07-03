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

import com.airbnb.lottie.LottieAnimationView;
import com.rsr.covid_19.R;
import com.rsr.covid_19.model.globalCases.CaseOverview;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("SetTextI18n")
public class CaseOverviewAdapter extends RecyclerView.Adapter<CaseOverviewAdapter.ViewHolder> {

    private Context             mContext;
    private List<CaseOverview>  caseOverviews = new ArrayList<>();

    public CaseOverviewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<CaseOverview> caseOverviews) {
        this.caseOverviews = caseOverviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CaseOverviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_case_overview, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private LottieAnimationView      icon;
        private AppCompatTextView       count;
        private AppCompatTextView       todayTv;
        private AppCompatTextView       subCount;
        private AppCompatTextView       text;
        private AppCompatTextView       percentage;

        private ViewHolder(View v) {
            super(v);
            icon = v.findViewById(R.id.icon);
            count = v.findViewById(R.id.count);
            todayTv = v.findViewById(R.id.todayTv);
            subCount = v.findViewById(R.id.subCount);
            text = v.findViewById(R.id.text);
            percentage = v.findViewById(R.id.percentage);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final CaseOverviewAdapter.ViewHolder holder, final int position) {
        final CaseOverview overview = caseOverviews.get(position%caseOverviews.size());

        holder.icon.setAnimation(overview.getIcon());

        holder.count.setText(new DecimalFormat().format(overview.getCount()));

        holder.todayTv.setVisibility(overview.getSubCount() != 0 ? View.VISIBLE : View.GONE);
        holder.subCount.setVisibility(overview.getSubCount() != 0 ? View.VISIBLE : View.GONE);
        holder.subCount.setText(overview.getSubCount() != 0 ? new DecimalFormat().format(overview.getSubCount()) + ")" : null);

        holder.text.setText(mContext.getResources().getString(overview.getText()));

        holder.percentage.setVisibility(overview.getPercentage() != null ? View.VISIBLE : View.GONE);
        holder.percentage.setText(overview.getPercentage());
    }

    @Override
    public int getItemCount() {
        return caseOverviews.size() == 0 ? 0 : Integer.MAX_VALUE;
    }
}
