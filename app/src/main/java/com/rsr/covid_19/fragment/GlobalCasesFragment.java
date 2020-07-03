package com.rsr.covid_19.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rsr.covid_19.R;
import com.rsr.covid_19.adapter.CountryAdapter;
import com.rsr.covid_19.adapter.GlobalCaseAdapter;
import com.rsr.covid_19.model.countryCases.Country;
import com.rsr.covid_19.model.countryCases.CountryCase;
import com.rsr.covid_19.model.globalCases.OverviewModel;
import com.rsr.covid_19.model.viewModel.GlobalCasesViewModel;
import com.rsr.covid_19.util.InstantAutoCompleteTextView;
import com.rsr.covid_19.util.SharedPreference;
import com.rsr.covid_19.util.extension.AppExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.rsr.covid_19.activity.HomeActivity.infoBtn;
import static com.rsr.covid_19.activity.HomeActivity.loader;
import static com.rsr.covid_19.activity.HomeActivity.toolbarTitle;


/**
 * A simple {@link Fragment} subclass.
 */
public class GlobalCasesFragment extends Fragment {

    private Context                     context;
    private InstantAutoCompleteTextView countryInput;
    private View                        country_Popup_Anchor;
    private RecyclerView                rcvCountryCases;
    private GlobalCaseAdapter           globalCaseAdapter;
    private GlobalCasesViewModel        globalCasesViewModel;
    private String                      selectedCountry = null;
    private OverviewModel               caseOverview;
    private SharedPreference            sp;

    public GlobalCasesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_global_cases, container, false);

        initId(view);

        init();

        return view;
    }

    private void initId(View view) {
        countryInput = view.findViewById(R.id.searchCountry_Input);
        country_Popup_Anchor = view.findViewById(R.id.country_Popup_Anchor);
        rcvCountryCases = view.findViewById(R.id.rcvCountryCases);
    }

    private void init() {
        sp = new SharedPreference(context);
        selectedCountry = sp.isLanguageEnglish() ? "Bangladesh" : "বাংলাদেশ";
        globalCasesViewModel = new ViewModelProvider(this).get(GlobalCasesViewModel.class);

        loader.setVisibility(View.GONE);
        toolbarTitle.setText(context.getResources().getString(R.string.globalCases));
        infoBtn.setEnabled(true);
        infoBtn.setVisibility(View.VISIBLE);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseOverview == null) return;
                caseOverview.setTitle(selectedCountry);
                CaseOverviewFragment.show((AppCompatActivity) context, caseOverview);
            }
        });

        setCountries();

        setAdapter();

        setCaseInfo();

        setCases();
    }

    private void setAdapter() {
        rcvCountryCases.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        globalCaseAdapter = new GlobalCaseAdapter(context);
        rcvCountryCases.setAdapter(globalCaseAdapter);
    }

    private void setCases() {
        globalCasesViewModel.getCases().observe(getViewLifecycleOwner(), new Observer<List<CountryCase>>() {
            @Override
            public void onChanged(List<CountryCase> countryCases) {
                if(countryCases == null || countryCases.isEmpty()){
                    globalCaseAdapter.setAdapterData(new ArrayList<>());
                    caseOverview = null;
                    return;
                }
                globalCaseAdapter.setAdapterData(countryCases);
            }
        });
    }

    private void setCaseInfo() {
        caseOverview = null;
        globalCasesViewModel.getCaseOverview().observe(getViewLifecycleOwner(), new Observer<OverviewModel>() {
            @Override
            public void onChanged(OverviewModel countryOverview) {
                if(countryOverview == null) return;
                GlobalCasesFragment.this.caseOverview = countryOverview;
            }
        });
    }

    private void setCountries() {
        List<Country> countries = AppExtension.getCountries(context);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countryInput.setThreshold(1);
                countryInput.setAdapter(new CountryAdapter(context, countries));
                countryInput.setDropDownAnchor(R.id.country_Popup_Anchor);
                countryInput.setDropDownBackgroundResource(R.drawable.shape_popup);
                countryInput.setDropDownHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                countryInput.setDropDownWidth(country_Popup_Anchor.getWidth());
                countryInput.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        hideKeyboard();
                        countryInput.clearFocus();
                        Country country = (Country) parent.getAdapter().getItem(position);
                        if (selectedCountry.equals(country.getCountryEn()) || selectedCountry.equals(country.getCountryBn())) return;
                        globalCasesViewModel.refreshData(country.getIso2());
                        selectedCountry = sp.isLanguageEnglish()? country.getCountryEn() : country.getCountryBn();
                        setCaseInfo();
                        setCases();
                    }
                });
            }
        }, 1000);
    }

    private void hideKeyboard() {
        final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
    }


    /**
     * Context bind
     **/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
