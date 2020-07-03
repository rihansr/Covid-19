package com.rsr.covid_19.model.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.rsr.covid_19.R;
import com.rsr.covid_19.activity.HomeActivity;
import com.rsr.covid_19.model.countryCases.CountryCase;
import com.rsr.covid_19.model.globalCases.OverviewModel;
import com.rsr.covid_19.network.NativeCaller;
import com.rsr.covid_19.network.RetrofitClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GlobalCasesViewModel extends ViewModel {

    private MutableLiveData<List<CountryCase>>  countryCases;
    private MutableLiveData<OverviewModel>      caseOverview;
    private String                              selectedCountry = "BD";

    public GlobalCasesViewModel() {
        setCases();
    }

    private void setCases(){
        HomeActivity.setShimmer(R.layout.sample_global_case_shimmer, 6, true);

        caseOverview = new MutableLiveData<>();
        RetrofitClient.getRetroFitClient(new NativeCaller().getOverviewUrl()).getCountryOverview(selectedCountry)
                .enqueue(new Callback<OverviewModel>() {
                    @Override
                    public void onResponse(Call<OverviewModel> call, Response<OverviewModel> infoResponse) {
                        if (infoResponse.isSuccessful()) {
                            caseOverview.setValue(infoResponse.body());
                        }
                        else {
                            caseOverview.setValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<OverviewModel> call, Throwable t) {
                        caseOverview.setValue(null);
                        t.printStackTrace();
                    }
                });

        countryCases = new MutableLiveData<>();
        RetrofitClient.getRetroFitClient(new NativeCaller().getBaseUrl()).getCountryCases(selectedCountry)
                .enqueue(new Callback<List<CountryCase>>() {
                    @Override
                    public void onResponse(Call<List<CountryCase>> call, Response<List<CountryCase>> casesResponse) {
                        if (casesResponse.isSuccessful()) {
                            HomeActivity.removeShimmer();
                            countryCases.setValue(casesResponse.body());
                        } else {
                            HomeActivity.removeShimmer();
                            countryCases.setValue(new ArrayList<>());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CountryCase>> call, Throwable t) {
                        HomeActivity.removeShimmer();
                        countryCases.setValue(new ArrayList<>());
                        t.printStackTrace();
                    }
                });
    }

    public void refreshData(String country){
        selectedCountry = country;
        setCases();
    }

    public MutableLiveData<List<CountryCase>> getCases() {
        return countryCases;
    }

    public MutableLiveData<OverviewModel> getCaseOverview() {
        return caseOverview;
    }
}