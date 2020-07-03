package com.rsr.covid_19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.rsr.covid_19.R;
import com.rsr.covid_19.model.countryCases.Country;
import com.rsr.covid_19.util.SharedPreference;
import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    private List<Country> allCountries;

    public CountryAdapter(@NonNull Context context, List<Country> goodsTypes) {
        super(context, 0, goodsTypes);
        allCountries = new ArrayList<>(goodsTypes);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull final ViewGroup parent) {
        if(view == null) view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_spinner, parent, false);

        SharedPreference sp = new SharedPreference(getContext());

        AppCompatTextView itemName = view.findViewById(R.id.itemName);

        final Country country = getItem(position);

        if(country != null) itemName.setText(sp.isLanguageEnglish()? country.getCountryEn() : country.getCountryBn());

        return view;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Country> filteredCountries = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filteredCountries.addAll(allCountries);
            }
            else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (Country country : allCountries){
                    if(country.getCountryEn().toLowerCase().contains(filterPattern)
                            ||
                            country.getIso2().toLowerCase().contains(filterPattern)
                            ||
                            country.getIso3().toLowerCase().contains(filterPattern)) {

                        filteredCountries.add(country);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredCountries;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            clear();
            addAll((List) filterResults.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Country) resultValue).getCountryEn();
        }
    };
}
