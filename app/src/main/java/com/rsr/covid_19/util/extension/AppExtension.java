package com.rsr.covid_19.util.extension;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.FileProvider;

import com.google.gson.GsonBuilder;
import com.rsr.covid_19.R;
import com.rsr.covid_19.activity.HomeActivity;
import com.rsr.covid_19.model.countryCases.Country;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.rsr.covid_19.activity.HomeActivity.shimmerBanner;

public class AppExtension {

    public static void setLocale(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }

    public static String replaceDigits(String text, boolean convertToBengali){
        String[] English = {"0","1","2","3","4","5","6","7","8","9"};
        String[] Bengali = {"০","১","২","৩","৪","৫","৬","৭","৮","৯"};

        for(int i=0; i<English.length; i++){
            if(convertToBengali){
                text = text.replaceAll(English[i],Bengali[i]);
            }
            else {
                text = text.replaceAll(Bengali[i],English[i]);
            }
        }

        return text;
    }

    public static void customToast(Context context, String message){
        Toast customToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        customToast.setGravity(Gravity.BOTTOM,0,50);
        View toastView = customToast.getView();

        TextView textView = toastView.findViewById(android.R.id.message);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(14);
        toastView.setPadding(15,10,15,10);
        toastView.setBackgroundResource(R.drawable.shape_toast);

        customToast.show();
    }

    public static List<Country> getCountries(Context context){
        List<Country> countries = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("countries.json");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            countries = new ArrayList<>(Arrays.asList(new GsonBuilder().setPrettyPrinting().create().fromJson(new String(buffer, StandardCharsets.UTF_8), Country[].class)));
        }
        catch (IOException e) {
            e.printStackTrace();
            return countries;
        }

        return countries;
    }

    public static String customDecimalFormat(double number) {
        DecimalFormat df = new DecimalFormat("#.#");
        return (number % 1 == 0)  ? String.valueOf((int) number) : df.format(number);
    }

    public static void requestFocus(Activity activity, View view) {
        if (view.requestFocus()) {
            Objects.requireNonNull(activity.getWindow()).setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public static void hideKeyboard(Context mContext, View view) {
        if(view != null){
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }

    public static void halfScreenDialog(Dialog dialog){
        if (dialog == null) return;

        Window window = dialog.getWindow();
        if (window == null) return;

        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.windowAnimations = R.style.DialogSlideAnimation;
        window.setGravity(Gravity.BOTTOM);
        window.setAttributes(params);
    }

    public static Long getDate(){
        Calendar startCalenderTime = Calendar.getInstance();
        startCalenderTime.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
        startCalenderTime.set(Calendar.MONTH, Calendar.getInstance().get(Calendar.MONTH));
        startCalenderTime.set(Calendar.DAY_OF_MONTH, startCalenderTime.getActualMinimum(Calendar.DAY_OF_MONTH));
        startCalenderTime.set(Calendar.HOUR_OF_DAY, 0);
        startCalenderTime.set(Calendar.MINUTE, 0);
        startCalenderTime.set(Calendar.SECOND, 0);
        startCalenderTime.set(Calendar.MILLISECOND, 0);
        return startCalenderTime.getTimeInMillis();
    }

    public static String defaultDateFormat(long date) {
        return new SimpleDateFormat("d MMM, yyyy", Locale.getDefault()).format(date);
    }

    public static String caseOverviewFormat(long date) {
        return new SimpleDateFormat("EEE, MMM d, yyyy", Locale.getDefault()).format(date);
    }

    public static String lastUpdateFormat(long date) {
        return new SimpleDateFormat("MMM d, yyyy", Locale.getDefault()).format(date);
    }

    public static String dateFormat(long date) {
        return new SimpleDateFormat("M-d-yyyy", Locale.getDefault()).format(date);
    }

    public static void shareFile(Context context, File sharePath) {
        Uri uri;
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.parse("file://" + sharePath);
        }
        else {
            uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", new File(String.valueOf(sharePath)));
        }

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, context.getResources().getString(R.string.covid19));
        shareIntent.setType("*/*");
        context.startActivity(Intent.createChooser(shareIntent, context.getResources().getString(R.string.shareAPkVia)));
    }
}
