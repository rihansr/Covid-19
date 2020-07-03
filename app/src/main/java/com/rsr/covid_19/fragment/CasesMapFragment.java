package com.rsr.covid_19.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.rsr.covid_19.R;
import com.rsr.covid_19.adapter.CountryAdapter;
import com.rsr.covid_19.model.countryCases.Country;
import com.rsr.covid_19.model.globalCases.GlobalCase;
import com.rsr.covid_19.model.viewModel.GlobalMapCasesViewModel;
import com.rsr.covid_19.util.Constants;
import com.rsr.covid_19.util.CustomSnackBar;
import com.rsr.covid_19.util.GpsUtils;
import com.rsr.covid_19.util.InstantAutoCompleteTextView;
import com.rsr.covid_19.util.extension.AppExtension;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

import static com.rsr.covid_19.activity.HomeActivity.infoBtn;
import static com.rsr.covid_19.activity.HomeActivity.loader;
import static com.rsr.covid_19.activity.HomeActivity.toolbarTitle;


/**
 * A simple {@link Fragment} subclass.
 */
public class CasesMapFragment extends Fragment implements OnMapReadyCallback {

    private Context                     context;
    private FrameLayout                 rootLayout;
    private GoogleMap                   mMap;
    private InstantAutoCompleteTextView countryInput;
    private View                        country_Popup_Anchor;
    private GlobalMapCasesViewModel     globalMapCasesViewModel;
    private boolean                     isGPS = false;

    public CasesMapFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cases_map, container, false);

        initId(view);

        init();

        return view;
    }

    private void initId(View view) {
        rootLayout = view.findViewById(R.id.rootLayout);
        countryInput = view.findViewById(R.id.searchCountry_Input);
        country_Popup_Anchor = view.findViewById(R.id.country_Popup_Anchor);
    }

    private void init() {
        loader.setVisibility(View.GONE);
        infoBtn.setEnabled(false);
        infoBtn.setVisibility(View.INVISIBLE);
        toolbarTitle.setText(context.getResources().getString(R.string.maps));

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) mapFragment.getMapAsync(this);
        globalMapCasesViewModel = new ViewModelProvider(this).get(GlobalMapCasesViewModel.class);

        setCountries();
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
                        LatLng latLng = new LatLng(country.getLatitude(), country.getLongitude());
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, Constants.DEFAULT_ZOOM));
                    }
                });
            }
        }, 1000);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            boolean isSuccess = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style)
            );
            if (!isSuccess) {
                Log.e("Hell", "Map style load failed!!!");
            }
        } catch (Resources.NotFoundException ex) {
            ex.printStackTrace();
        }

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setTrafficEnabled(false);
        mMap.setIndoorEnabled(false);
        mMap.setBuildingsEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.getUiSettings().setCompassEnabled(false);
        mMap.getUiSettings().setRotateGesturesEnabled(false);
        mMap.getUiSettings().setTiltGesturesEnabled(false);
        mMap.setMinZoomPreference(Constants.DEFAULT_MIN_ZOOM);
        mMap.setMaxZoomPreference(Constants.DEFAULT_MAX_ZOOM);

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker)   {
                View v = getLayoutInflater().inflate(R.layout.sample_snippet, null);

                AppCompatTextView countryName = v.findViewById(R.id.countryName);;
                AppCompatTextView affectedCount = v.findViewById(R.id.affectedCount);
                AppCompatTextView activeCount = v.findViewById(R.id.activeCount);
                AppCompatTextView deathCount = v.findViewById(R.id.deathCount);
                AppCompatTextView recoveredCount = v.findViewById(R.id.recoveredCount);

                String[] counts = marker.getSnippet().split("_");

                countryName.setText(marker.getTitle());
                affectedCount.setText(counts[0]);
                activeCount.setText(counts[1]);
                deathCount.setText(counts[2]);
                recoveredCount.setText(counts[3]);

                return v;
            }
            @Override
            public View getInfoContents(Marker marker) {
                return null;
            }

        });

        setLocation();
    }

    private void setLocation() {
        if(!isGooglePlayServicesAvailable()) return;

        turnGPSOn();

        if (Build.VERSION.SDK_INT >= 23){
            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, Constants.LOCATION_REQUEST);
                return ;
            }

            displayLocations();
        }
        else {
            displayLocations();
        }
    }

    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(context);
        if (ConnectionResult.SUCCESS == status) return true;
        else {
            if (googleApiAvailability.isUserResolvableError(status)){
                CustomSnackBar snackbar = new CustomSnackBar(context,
                        rootLayout,
                        getResources().getString(R.string.network_Error),
                        getResources().getString(R.string.retry),
                        CustomSnackBar.Duration.INDEFINITE
                );
                snackbar.show();
                snackbar.setOnDismissListener(new CustomSnackBar.OnDismissListener() {
                    @Override
                    public void onDismiss(Snackbar snackbar) {
                        isGooglePlayServicesAvailable();
                        snackbar.dismiss();
                    }
                });
            }
        }
        return false;
    }

    private void turnGPSOn(){
        new GpsUtils(context).turnGPSOn(new GpsUtils.onGpsListener() {
            @Override
            public void gpsStatus(boolean isGPSEnable) {
                // turn on GPS
                isGPS = isGPSEnable;
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        for (int i = 0; i < permissions.length; i++) {

            switch (requestCode) {
                case Constants.LOCATION_REQUEST:
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {

                        /* If user rejected the permission */
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                            if (! shouldShowRequestPermissionRationale(permissions[i])) {

                                /* If user also CHECKED "never ask again */
                                new AlertDialog.Builder(context, R.style.CustomDialogTheme)
                                        .setCancelable(true)
                                        .setTitle(context.getResources().getString(R.string.locationPermissionNecessary))
                                        .setMessage(context.getResources().getString(R.string.locationPermissionMessage))
                                        .setPositiveButton(context.getResources().getString(R.string.openSettings), new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + context.getPackageName()));
                                                intent.addCategory(Intent.CATEGORY_DEFAULT);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                context.startActivity(intent);
                                            }
                                        })
                                        .create()
                                        .show();
                            }
                        }
                    }
                    else {
                        displayLocations();
                    }
                    break;

                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == Constants.GPS_REQUEST) {
                isGPS = true;
            }
        }
    }

    private void displayLocations() {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(24, 90), Constants.DEFAULT_ZOOM));
        globalMapCasesViewModel.getCases().observe(getViewLifecycleOwner(), new Observer<List<GlobalCase>>() {
            @Override
            public void onChanged(List<GlobalCase> globalCases) {
                if(globalCases.isEmpty()) return;
                for(GlobalCase mCase : globalCases){
                    showMarker(mCase);
                }
            }
        });
    }

    private void showMarker(GlobalCase mCase) {
        if(mCase.getLat() == null || mCase.getLong() == null) return;

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(mCase.getLat(), mCase.getLong()))
                .title(mCase.getCombinedKey())
                .snippet(new DecimalFormat().format(mCase.getConfirmed())
                        + "_" +
                        new DecimalFormat().format(mCase.getActive())
                        + "_" +
                        new DecimalFormat().format(mCase.getDeaths())
                        + "_" +
                        new DecimalFormat().format(mCase.getRecovered()))
                .icon(getMarkerIconFromDrawable(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.ic_marker)))));
    }

    private BitmapDescriptor getMarkerIconFromDrawable(Drawable drawable) {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(56, 56, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, 56, 56);
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private void hideKeyboard() {
        final InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) imm.hideSoftInputFromWindow(Objects.requireNonNull(getView()).getWindowToken(), 0);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
