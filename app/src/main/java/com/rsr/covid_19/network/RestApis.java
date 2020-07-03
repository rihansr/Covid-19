package com.rsr.covid_19.network;

import com.rsr.covid_19.model.dailyCases.DailyCase;
import com.rsr.covid_19.model.globalCases.GlobalCase;
import com.rsr.covid_19.model.countryCases.CountryCase;
import com.rsr.covid_19.model.globalCases.OverviewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApis {
    @GET("all")
    Call<OverviewModel> getGlobalOverview();

    @GET("confirmed")
    Call<List<GlobalCase>> getAllCases();

    @GET("daily/{date}")    /*date format: 2-14-2020*/
    Call<List<DailyCase>> getDailyCases(@Path("date") String date);

    @GET("countries/{country}/confirmed")
    Call<List<CountryCase>> getCountryCases(@Path("country") String country);

    @GET("countries/{country}")
    Call<OverviewModel> getCountryOverview(@Path("country") String country);
}
