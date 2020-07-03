package com.rsr.covid_19.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

import com.rsr.covid_19.R;
import com.rsr.covid_19.adapter.CaseOverviewAdapter;
import com.rsr.covid_19.model.globalCases.CaseOverview;
import com.rsr.covid_19.model.globalCases.OverviewModel;
import com.rsr.covid_19.util.CenterZoomLayoutManager;
import com.rsr.covid_19.util.extension.AppExtension;
import com.rsr.covid_19.util.Constants;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ClickableViewAccessibility, SetTextI18n")
public class CaseOverviewFragment extends DialogFragment {

    private static final String TAG = CaseOverviewFragment.class.getSimpleName();
    private Context             mContext;
    private LinearLayoutCompat  toolBar;
    private AppCompatTextView   title;
    private AppCompatTextView   date;
    private RecyclerView        rcvCaseOverviews;
    private CaseOverviewAdapter overviewAdapter;

    public static CaseOverviewFragment show(@NonNull AppCompatActivity appCompatActivity, OverviewModel overview){
        CaseOverviewFragment fragment = new CaseOverviewFragment();
        if (overview != null) {
            Bundle args = new Bundle();
            args.putSerializable(Constants.CASE_OVERVIEW_BUNDLE_KEY, overview);
            fragment.setArguments(args);
        }
        fragment.show(appCompatActivity.getSupportFragmentManager(), TAG);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setCancelable(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        AppExtension.halfScreenDialog(getDialog());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_case_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initId(view);

        if (getArguments() == null) return;
        OverviewModel overview = (OverviewModel) getArguments().getSerializable(Constants.CASE_OVERVIEW_BUNDLE_KEY);
        if (overview == null) return;
        init(overview);
        getArguments().remove(Constants.CASE_OVERVIEW_BUNDLE_KEY);
    }

    private void initId(View view) {
        toolBar = view.findViewById(R.id.toolBar);
        title = view.findViewById(R.id.title);
        date = view.findViewById(R.id.date);
        rcvCaseOverviews = view.findViewById(R.id.rcvCaseOverviews);
    }

    private void init(OverviewModel overview){
        toolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        CenterZoomLayoutManager layoutManager = new CenterZoomLayoutManager(mContext, RecyclerView.HORIZONTAL, false, .3f);
        rcvCaseOverviews.setLayoutManager(layoutManager);
        overviewAdapter = new CaseOverviewAdapter(mContext);
        rcvCaseOverviews.setAdapter(overviewAdapter);

        long country = overview.getAffectedCountries() == null ? 0 : overview.getAffectedCountries();
        long test = overview.getTests() == null ? 0 : overview.getTests();
        long affected = overview.getCases() == null ? 0 : overview.getCases();
        long todayAffected = overview.getTodayCases() == null ? 0 : overview.getTodayCases();
        long recovered = overview.getRecovered() == null ? 0 : overview.getRecovered();
        long critical = overview.getCritical() == null ? 0 : overview.getCritical();
        long death = overview.getDeaths() == null ? 0 : overview.getDeaths();
        long todayDeath = overview.getTodayDeaths() == null ? 0 : overview.getTodayDeaths();

        if(overview.getTitle() != null) title.setText(overview.getTitle());
        else if (overview.getUpdated() != null) title.setText(AppExtension.caseOverviewFormat(overview.getUpdated()));

        List<CaseOverview> caseOverviews = new ArrayList<>();

        if (country != 0) caseOverviews.add(new CaseOverview(R.raw.country, country, R.string.affectedCountry));
        if (test != 0) caseOverviews.add(new CaseOverview(R.raw.tested, test, R.string.peopleTested));
        if (affected != 0) caseOverviews.add(new CaseOverview(R.raw.affected, affected, todayAffected, R.string.peopleAffected));
        if (recovered != 0) caseOverviews.add(new CaseOverview(R.raw.recovered, recovered, R.string.peopleRecovered, getPercentage(affected, recovered)));
        if (critical != 0) caseOverviews.add(new CaseOverview(R.raw.critical, critical, R.string.peopleCritical));
        if (death != 0) caseOverviews.add(new CaseOverview(R.raw.death, death, todayDeath, R.string.peopleDied, getPercentage(affected, death)));

        overviewAdapter.setAdapterData(caseOverviews);

        if(overview.getUpdated() != null){
            date.setVisibility(View.VISIBLE);
            date.setText(mContext.getResources().getString(R.string.lastUpdated) + " " + AppExtension.lastUpdateFormat(overview.getUpdated()));
        }
    }

    private void setAdapter() {
        rcvCaseOverviews.setLayoutManager(new CenterZoomLayoutManager(mContext, RecyclerView.HORIZONTAL, false, .3f));
        overviewAdapter = new CaseOverviewAdapter(mContext);
        rcvCaseOverviews.setAdapter(overviewAdapter);
    }

    private String getPercentage(long total, long value){
        double percentage = (double) (value * 100) / total;
        return "(" + AppExtension.customDecimalFormat(percentage) + "%)";
    }

    private class OnScrollListener extends RecyclerView.OnScrollListener{
        private int itemCount;
        private LinearLayoutManager layoutManager;

        public OnScrollListener(int itemCount, LinearLayoutManager layoutManager) {
            this.itemCount = itemCount;
            this.layoutManager = layoutManager;
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int firstItemVisible = layoutManager.findFirstVisibleItemPosition();

            if (firstItemVisible > itemCount && firstItemVisible % itemCount == 0) {
                if (firstItemVisible > 0 && firstItemVisible % (itemCount - 1) == 0) {
                    // When position reaches end of the list, it should go back to the beginning
                    recyclerView.scrollToPosition(itemCount);
                } else if (firstItemVisible == itemCount - 1) {
                    recyclerView.scrollToPosition(1);
                } else if (firstItemVisible == 0) {
                    // When position reaches beginning of the list, it should go back to the end
                    recyclerView.scrollToPosition(itemCount * 2);
                    recyclerView.scrollToPosition(itemCount - 1);
                }
            }
        }
    }

    /**
     *  Context Bind
     **/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
