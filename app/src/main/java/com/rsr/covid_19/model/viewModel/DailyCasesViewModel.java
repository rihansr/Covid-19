package com.rsr.covid_19.model.viewModel;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.rsr.covid_19.R;
import com.rsr.covid_19.activity.HomeActivity;
import com.rsr.covid_19.model.dailyCases.DailyCase;
import com.rsr.covid_19.network.NativeCaller;
import com.rsr.covid_19.network.RetrofitClient;
import com.rsr.covid_19.util.extension.AppExtension;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DailyCasesViewModel extends ViewModel {

    private MutableLiveData<List<DailyCase>> dateCases;
    private String selectedDate = AppExtension.replaceDigits(AppExtension.dateFormat(AppExtension.getDate()), false);

    public DailyCasesViewModel() {
        setCases();
    }

    private void setCases(){
        HomeActivity.setShimmer(R.layout.sample_daily_case_shimmer, 10, true);

        dateCases = new MutableLiveData<>();
        RetrofitClient.getRetroFitClient(new NativeCaller().getBaseUrl()).getDailyCases(selectedDate).enqueue(new Callback<List<DailyCase>>() {
            @Override
            public void onResponse(Call<List<DailyCase>> call, Response<List<DailyCase>> casesResponse) {
                if (casesResponse.isSuccessful()) {
                    HomeActivity.removeShimmer();
                    dateCases.setValue(casesResponse.body());
                } else {
                    HomeActivity.removeShimmer();
                    dateCases.setValue(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<List<DailyCase>> call, Throwable t) {
                HomeActivity.removeShimmer();
                dateCases.setValue(new ArrayList<>());
                t.printStackTrace();
            }
        });
    }

    public void refreshData(String date){
        selectedDate = date;
        setCases();
    }

    public MutableLiveData<List<DailyCase>> getCases() {
        return dateCases;
    }
}