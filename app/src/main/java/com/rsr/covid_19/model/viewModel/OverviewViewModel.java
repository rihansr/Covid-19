package com.rsr.covid_19.model.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rsr.covid_19.model.globalCases.OverviewModel;
import com.rsr.covid_19.network.NativeCaller;
import com.rsr.covid_19.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.rsr.covid_19.activity.HomeActivity.loader;

public class OverviewViewModel extends ViewModel {

    private MutableLiveData<OverviewModel> baseResponse;

    public OverviewViewModel() {
        loader.setVisibility(View.VISIBLE);
        baseResponse = new MutableLiveData<>();

        Call<OverviewModel> responses = RetrofitClient.getRetroFitClient(new NativeCaller().getOverviewUrl()).getGlobalOverview();
        responses.enqueue(new Callback<OverviewModel>() {
            @Override
            public void onResponse(Call<OverviewModel> call, Response<OverviewModel> response) {
                if(response.isSuccessful()){
                    loader.setVisibility(View.GONE);
                    baseResponse.setValue(response.body());
                }
                else {
                    loader.setVisibility(View.GONE);
                    baseResponse.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<OverviewModel> call, Throwable t) {
                loader.setVisibility(View.GONE);
                baseResponse.setValue(null);
                t.printStackTrace();
            }
        });
    }

    public MutableLiveData<OverviewModel> getData() {
        return baseResponse;
    }
}