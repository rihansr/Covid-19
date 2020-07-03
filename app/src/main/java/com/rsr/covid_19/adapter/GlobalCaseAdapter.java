package com.rsr.covid_19.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.rsr.covid_19.R;
import com.rsr.covid_19.model.countryCases.CountryCase;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"SetTextI18n"})
public class GlobalCaseAdapter extends RecyclerView.Adapter<GlobalCaseAdapter.ViewHolder> {

    private Context                 mContext;
    private List<CountryCase>       cases = new ArrayList<>();
    private OnCaseSelectListener    mOnCaseSelectListener;

    public GlobalCaseAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<CountryCase> cases) {
        this.cases = cases;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GlobalCaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_global_case, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView countryName;
        private AppCompatTextView affectedCount;
        private AppCompatTextView activeCount;
        private AppCompatTextView deathCount;
        private AppCompatTextView recoveredCount;

        private ViewHolder(View v) {
            super(v);
            countryName = v.findViewById(R.id.countryName);
            affectedCount = v.findViewById(R.id.affectedCount);
            activeCount = v.findViewById(R.id.activeCount);
            deathCount = v.findViewById(R.id.deathCount);
            recoveredCount = v.findViewById(R.id.recoveredCount);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final GlobalCaseAdapter.ViewHolder holder, final int position) {
        final CountryCase mCase = this.cases.get(position);

        holder.countryName.setText(mCase.getCombinedKey());
        holder.affectedCount.setText(new DecimalFormat().format(mCase.getConfirmed()));
        holder.activeCount.setText(new DecimalFormat().format(mCase.getActive()));
        holder.deathCount.setText(new DecimalFormat().format(mCase.getDeaths()));
        holder.recoveredCount.setText(new DecimalFormat().format(mCase.getRecovered()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnCaseSelectListener != null) mOnCaseSelectListener.onTestClick(mCase);
            }
        });
    }

    public void setOnCaseSelectListener(OnCaseSelectListener mOnCaseSelectListener) {
        this.mOnCaseSelectListener = mOnCaseSelectListener;
    }

    public interface OnCaseSelectListener {
        void onTestClick(CountryCase response);
    }

    @Override
    public int getItemCount() {
        return cases.size();
    }
}
