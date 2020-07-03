package com.rsr.covid_19.fragment;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.gson.Gson;
import com.rsr.covid_19.R;
import com.rsr.covid_19.model.globalCases.OverviewModel;
import com.rsr.covid_19.model.viewModel.OverviewViewModel;
import com.rsr.covid_19.util.SharedPreference;
import com.rsr.covid_19.util.extension.AppExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.rsr.covid_19.activity.HomeActivity.infoBtn;
import static com.rsr.covid_19.activity.HomeActivity.toolbarTitle;
import static com.rsr.covid_19.util.Constants.isChartAnimationShowed;

public class OverviewFragment extends Fragment {

    private Context             context;
    private AppCompatTextView   affectedCount;
    private AppCompatTextView   affectedPercentage;
    private AppCompatTextView   recoveredCount;
    private AppCompatTextView   recoveredPercentage;
    private AppCompatTextView   deathCount;
    private AppCompatTextView   deathPercentage;
    private PieChart            pieChart;
    private OverviewViewModel   overviewViewModel;
    private SharedPreference    sp;

    public OverviewFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        initId(view);

        setPieChart();

        setPreferenceData();

        init();

        return view;
    }

    private void initId(View view){
        affectedCount = view.findViewById(R.id.affectedCount);
        affectedPercentage = view.findViewById(R.id.affectedPercentage);
        recoveredCount = view.findViewById(R.id.recoveredCount);
        recoveredPercentage = view.findViewById(R.id.recoveredPercentage);
        deathCount = view.findViewById(R.id.deathCount);
        deathPercentage = view.findViewById(R.id.deathPercentage);
        pieChart = view.findViewById(R.id.pieChart);
        sp = new SharedPreference(context);
        overviewViewModel = new ViewModelProvider(this).get(OverviewViewModel.class);
    }

    private void init(){
        infoBtn.setEnabled(true);
        infoBtn.setVisibility(View.VISIBLE);
        toolbarTitle.setText(context.getResources().getString(R.string.overview));
        overviewViewModel.getData().observe(getViewLifecycleOwner(), new Observer<OverviewModel>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(OverviewModel overviewResponse) {
                if(overviewResponse == null) return;

                String data = new Gson().toJson(overviewResponse);
                sp.setOverviewData(data);

                infoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        overviewResponse.setTitle(context.getResources().getString(R.string.globalOverview));
                        CaseOverviewFragment.show((AppCompatActivity) context, overviewResponse);
                    }
                });

                String getConfirmed = affectedCount.getText().toString().replace(",", "").trim();
                String getRecovered = recoveredCount.getText().toString().replace(",", "").trim();
                String getDeath = deathCount.getText().toString().replace(",", "").trim();

                long affected = overviewResponse.getCases() == null ? 0 : overviewResponse.getCases();
                long active = overviewResponse.getCases() == null ? 0 : overviewResponse.getActive();
                long recovered = overviewResponse.getRecovered() == null ? 0 : overviewResponse.getRecovered();
                long death = overviewResponse.getDeaths() == null ? 0 : overviewResponse.getDeaths();

                animateCounter(affectedCount, Long.parseLong(getConfirmed), affected);
                animateCounter(recoveredCount, Long.parseLong(getRecovered), recovered);
                animateCounter(deathCount, Long.parseLong(getDeath), death);

                affectedPercentage.setText(getPercentage(affected, active));
                deathPercentage.setText(getPercentage(affected, death));
                recoveredPercentage.setText(getPercentage(affected, recovered));

                pieChart.setVisibility(View.VISIBLE);
                pieChart.setCenterText(context.getResources().getString(R.string.totalAffected) + "\n" + new DecimalFormat().format(affected));
                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry(active, context.getResources().getString(R.string.active)));
                entries.add(new PieEntry(recovered, context.getResources().getString(R.string.recovered)));
                entries.add(new PieEntry(death, context.getResources().getString(R.string.deaths)));
                setPieDataSet(entries);
            }
        });
    }

    private void setPreferenceData() {
        if(sp.getOverviewData() == null) return;
        OverviewModel overviewResponse = new Gson().fromJson(sp.getOverviewData(), OverviewModel.class);

        long affected = overviewResponse.getCases() == null ? 0 : overviewResponse.getCases();
        long active = overviewResponse.getCases() == null ? 0 : overviewResponse.getActive();
        long recovered = overviewResponse.getRecovered() == null ? 0 : overviewResponse.getRecovered();
        long death = overviewResponse.getDeaths() == null ? 0 : overviewResponse.getDeaths();

        affectedCount.setText(new DecimalFormat().format(affected));
        recoveredCount.setText(new DecimalFormat().format(recovered));
        deathCount.setText(new DecimalFormat().format(death));

        affectedPercentage.setText(getPercentage(affected, active));
        deathPercentage.setText(getPercentage(affected, death));
        recoveredPercentage.setText(getPercentage(affected, recovered));

        pieChart.setVisibility(View.VISIBLE);
        pieChart.setCenterText(context.getResources().getString(R.string.totalAffected) + "\n" + new DecimalFormat().format(affected));
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(active, context.getResources().getString(R.string.active)));
        entries.add(new PieEntry(recovered, context.getResources().getString(R.string.recovered)));
        entries.add(new PieEntry(death, context.getResources().getString(R.string.deaths)));
        setPieDataSet(entries);
    }

    private void setPieChart() {
        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setDrawCenterText(true);
        pieChart.getLegend().setEnabled(false);
        pieChart.setRotationAngle(0);
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);
        pieChart.setHoleColor(R.color.colorPrimary);
        pieChart.setHoleRadius(45f);
        pieChart.setTransparentCircleRadius(55f);
        pieChart.setCenterTextColor(ContextCompat.getColor(context, R.color.font_Color_Light));
        pieChart.setCenterTextSize(13f);

        if(isChartAnimationShowed) return;
        pieChart.animateY(1000, Easing.EaseInOutQuad);
        isChartAnimationShowed = true;
    }

    private void setPieDataSet(ArrayList<PieEntry> entries) {
        PieDataSet dataSet = new PieDataSet(entries, context.getResources().getString(R.string.globalCases));
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(10f);
        dataSet.setColors(MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);
        pieChart.highlightValues(null);
        pieChart.invalidate();
    }

    private final int[] MATERIAL_COLORS = {rgb("#5A45F8"), rgb("#00C571"), rgb("#FD3951")};

    private int rgb(String hex) {
        int color = (int) Long.parseLong(hex.replace("#", ""), 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        return Color.rgb(r, g, b);
    }

    private void animateCounter(final AppCompatTextView view, long start, long end) {
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues((int)start, (int)end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setText(new DecimalFormat().format(animation.getAnimatedValue()));
            }
        });
        animator.setDuration(2000);
        animator.start();
    }

    private String getPercentage(long total, long value){
        double percentage = (double) (value * 100) / total;
        return AppExtension.customDecimalFormat(percentage) + "%";
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
