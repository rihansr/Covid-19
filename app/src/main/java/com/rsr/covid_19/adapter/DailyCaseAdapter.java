package com.rsr.covid_19.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.rsr.covid_19.R;
import com.rsr.covid_19.model.dailyCases.DailyCase;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"SetTextI18n"})
public class DailyCaseAdapter extends RecyclerView.Adapter<DailyCaseAdapter.ViewHolder> implements Filterable {

    private Context               mContext;
    private List<DailyCase>        cases = new ArrayList<>();
    private List<DailyCase>        allCases = new ArrayList<>();
    private OnCaseSelectListener  mOnCaseSelectListener;

    public DailyCaseAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAdapterData(List<DailyCase> cases) {
        this.cases = cases;
        this.allCases = new ArrayList<>(cases);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DailyCaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_daily_case, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView countryName;
        private AppCompatTextView affectedCount;
        private AppCompatTextView deathCount;
        private AppCompatTextView recoveredCount;

        private ViewHolder(View v) {
            super(v);
            countryName = v.findViewById(R.id.countryName);
            affectedCount = v.findViewById(R.id.affectedCount);
            deathCount = v.findViewById(R.id.deathCount);
            recoveredCount = v.findViewById(R.id.recoveredCount);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final DailyCaseAdapter.ViewHolder holder, final int position) {
        final DailyCase mCase = this.cases.get(position);

        holder.countryName.setText(mCase.getCombinedKey() == null || mCase.getCombinedKey().trim().isEmpty()
                ?
                ((mCase.getProvinceState() == null || mCase.getProvinceState().trim().isEmpty()
                        ?
                        ""
                        :
                        (mCase.getProvinceState() + ", ")) + mCase.getCountryRegion())
                :
                mCase.getCombinedKey()
        );

        holder.affectedCount.setText(mCase.getConfirmed() == null || mCase.getConfirmed().trim().isEmpty()
                ?
                "0"
                :
                new DecimalFormat().format(Long.parseLong(mCase.getConfirmed().replaceAll(",", "")))
        );

        holder.deathCount.setText(mCase.getDeaths() == null || mCase.getDeaths().trim().isEmpty()
                ?
                "0"
                :
                new DecimalFormat().format(Long.parseLong(mCase.getDeaths().replaceAll(",", "")))
        );

        holder.recoveredCount.setText(mCase.getRecovered() == null || mCase.getRecovered().trim().isEmpty()
                ?
                "0"
                :
                new DecimalFormat().format(Long.parseLong(mCase.getRecovered().replaceAll(",", "")))
        );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnCaseSelectListener != null) mOnCaseSelectListener.onCase(mCase);
            }
        });
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return responseFilter;
    }

    private Filter responseFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<DailyCase> filtered_Cases = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filtered_Cases.addAll(allCases);
            }
            else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (DailyCase dailyCase : allCases){
                    if(dailyCase.getCountryRegion() != null && !dailyCase.getCountryRegion().trim().isEmpty() && dailyCase.getCountryRegion().toLowerCase().contains(filterPattern)){
                        filtered_Cases.add(dailyCase);
                    }
                    else if(dailyCase.getProvinceState()!= null && !dailyCase.getProvinceState().trim().isEmpty() && dailyCase.getProvinceState().toLowerCase().contains(filterPattern)){
                        filtered_Cases.add(dailyCase);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filtered_Cases;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            cases.clear();
            cases.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public void setOnCaseSelectListener(OnCaseSelectListener mOnCaseSelectListener) {
        this.mOnCaseSelectListener = mOnCaseSelectListener;
    }

    public interface OnCaseSelectListener {
        void onCase(DailyCase response);
    }

    @Override
    public int getItemCount() {
        return cases.size();
    }
}
