package com.rsr.covid_19.model.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rsr.covid_19.network.NativeCaller;
import com.rsr.covid_19.network.RetrofitClient;
import com.rsr.covid_19.model.globalCases.GlobalCase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.rsr.covid_19.activity.HomeActivity.loader;

public class GlobalMapCasesViewModel extends ViewModel {

    private MutableLiveData<List<GlobalCase>>   globalCases;

    public GlobalMapCasesViewModel() {
        setCases();
    }

    private void setCases() {
        loader.setVisibility(View.VISIBLE);
        globalCases = new MutableLiveData<>();
        RetrofitClient.getRetroFitClient(new NativeCaller().getBaseUrl()).getAllCases()
                .enqueue(new Callback<List<GlobalCase>>() {
                    @Override
                    public void onResponse(Call<List<GlobalCase>> call, Response<List<GlobalCase>> casesResponse) {
                        if (casesResponse.isSuccessful()) {
                            loader.setVisibility(View.GONE);
                            globalCases.setValue(casesResponse.body());
                        } else {
                            loader.setVisibility(View.GONE);
                            globalCases.setValue(new ArrayList<>());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GlobalCase>> call, Throwable t) {
                        loader.setVisibility(View.GONE);
                        globalCases.setValue(new ArrayList<>());
                        t.printStackTrace();
                    }
                });
    }

    public MutableLiveData<List<GlobalCase>> getCases() {
        return globalCases;
    }
}