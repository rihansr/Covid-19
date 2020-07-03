package com.rsr.covid_19.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rsr.covid_19.R;
import com.rsr.covid_19.adapter.DailyCaseAdapter;
import com.rsr.covid_19.model.dailyCases.DailyCase;
import com.rsr.covid_19.model.globalCases.OverviewModel;
import com.rsr.covid_19.model.viewModel.DailyCasesViewModel;
import com.rsr.covid_19.util.extension.AppExtension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import static com.rsr.covid_19.activity.HomeActivity.infoBtn;
import static com.rsr.covid_19.activity.HomeActivity.loader;
import static com.rsr.covid_19.activity.HomeActivity.toolbarTitle;

@SuppressLint("ClickableViewAccessibility")
public class DailyCasesFragment extends Fragment {

    private Context                 context;
    private AppCompatEditText       dateInput;
    private AppCompatEditText       searchInput;
    private DailyCasesViewModel     dailyCasesViewModel;
    private RecyclerView            casesRv;
    private long                    selectedDate = AppExtension.getDate();
    private OverviewModel           caseOverview = null;
    private DailyCaseAdapter        dailyCaseAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_daily_cases, container, false);

        initId(root);

        init();

        return root;
    }

    private void initId(View view) {
        searchInput = view.findViewById(R.id.searchCountry_Input);
        dateInput = view.findViewById(R.id.date_Input);
        dateInput.setInputType(InputType.TYPE_NULL);
        casesRv = view.findViewById(R.id.rcvDateCases);
    }

    private void init() {
        setAdapter();

        dateInput.setText(AppExtension.defaultDateFormat(AppExtension.getDate()));
        dailyCasesViewModel = new ViewModelProvider(this).get(DailyCasesViewModel.class);

        setCases();

        dateInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    datePicker();
                }
                return false;
            }
        });

        loader.setVisibility(View.GONE);
        toolbarTitle.setText(context.getResources().getString(R.string.dailyCases));
        infoBtn.setEnabled(true);
        infoBtn.setVisibility(View.VISIBLE);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(caseOverview == null) return;
                caseOverview.setTitle(AppExtension.caseOverviewFormat(selectedDate));
                CaseOverviewFragment.show((AppCompatActivity) context, caseOverview);
            }
        });
    }

    private void setAdapter() {
        casesRv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        dailyCaseAdapter = new DailyCaseAdapter(context);
        casesRv.setAdapter(dailyCaseAdapter);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dailyCaseAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void setCases(){
        dailyCasesViewModel.getCases().observe(getViewLifecycleOwner(), new Observer<List<DailyCase>>() {
            @Override
            public void onChanged(List<DailyCase> dailyCases) {
                if(dailyCases == null || dailyCases.isEmpty()){
                    dailyCaseAdapter.setAdapterData(new ArrayList<>());
                    caseOverview = null;
                    return;
                }

                dailyCaseAdapter.setAdapterData(dailyCases);

                long affected = 0;
                long death = 0;
                long recovered = 0;

                for(DailyCase dailyCase : dailyCases){
                    if(dailyCase.getConfirmed() != null && !dailyCase.getConfirmed().trim().isEmpty())
                        affected = affected + Long.parseLong(dailyCase.getConfirmed().replaceAll(",", ""));

                    if(dailyCase.getDeaths() != null && !dailyCase.getDeaths().trim().isEmpty())
                        death = death + Long.parseLong(dailyCase.getDeaths().replaceAll(",", ""));

                    if(dailyCase.getRecovered() != null && !dailyCase.getRecovered().trim().isEmpty())
                        recovered = recovered + Long.parseLong(dailyCase.getRecovered().replaceAll(",", ""));
                }

                caseOverview = new OverviewModel(affected, death, recovered);
            }
        });
    }

    private void datePicker() {
        final DatePicker datePicker = new DatePicker(context);
        final int currentDay = datePicker.getDayOfMonth();
        final int currentMonth = datePicker.getMonth();
        final int currentYear = datePicker.getYear();

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, monthOfYear, dayOfMonth);
                if(AppExtension.dateFormat(DailyCasesFragment.this.selectedDate).equals(AppExtension.dateFormat(selectedDate.getTimeInMillis()))) return;
                searchInput.setText(null);
                caseOverview = null;
                DailyCasesFragment.this.selectedDate = selectedDate.getTimeInMillis();
                dateInput.setText(AppExtension.defaultDateFormat(DailyCasesFragment.this.selectedDate));
                dailyCasesViewModel.refreshData(AppExtension.replaceDigits(AppExtension.dateFormat(DailyCasesFragment.this.selectedDate), false));
                setCases();
            }
        }, currentYear, currentMonth, currentDay);

        /**
         * Set Old Date
         **/
        if (!Objects.requireNonNull(dateInput.getText()).toString().isEmpty()) {

            String[] oldDate = AppExtension.dateFormat(selectedDate).split("-");
            int m = Integer.parseInt(oldDate[0].trim()) - 1;
            int d = Integer.parseInt(oldDate[1].trim());
            int y = Integer.parseInt(oldDate[2].trim());

            datePickerDialog.updateDate(y, m, d);
        }

        Calendar minDate = Calendar.getInstance();
        minDate.set(2020, 0, 22);
        datePickerDialog.getDatePicker().setMinDate(minDate.getTimeInMillis());
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()-86400000);
        datePickerDialog.show();
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
