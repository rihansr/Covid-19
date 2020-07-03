package com.rsr.covid_19.util;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import com.rsr.covid_19.R;

public class CustomSnackBar {

    public enum Duration {
        SHORT, LONG, INDEFINITE
    }

    public static Snackbar      snackbar;
    private Context             mContext;
    private View                layout;
    private String              message;
    private String              button;
    private Duration            duration;
    private OnDismissListener   mOnDismissListener;

    public CustomSnackBar(Context mContext, View layout, String message, Duration duration) {
        this.mContext = mContext;
        this.layout = layout;
        this.message = message;
        this.duration = duration;
    }

    public CustomSnackBar(Context mContext, View layout, String message, String button, Duration duration) {
        this.mContext = mContext;
        this.layout = layout;
        this.message = message;
        this.button = button;
        this.duration = duration;
    }

    public void show(){
        switch (duration){
            case SHORT : snackbar = Snackbar.make(layout, message, Snackbar.LENGTH_SHORT);
                break;
            case LONG : snackbar = Snackbar.make(layout, message, Snackbar.LENGTH_LONG);
                break;
            case INDEFINITE : snackbar = Snackbar.make(layout, message, Snackbar.LENGTH_INDEFINITE);
                break;
        }

        if(button != null){
            snackbar.setAction(button, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnDismissListener != null) mOnDismissListener.onDismiss(snackbar);
                    else snackbar.dismiss();
                }
            }).setActionTextColor(Color.WHITE);
        }

        Snackbar.SnackbarLayout s_layout = (Snackbar.SnackbarLayout) snackbar.getView();

        TextView textView = s_layout.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);

        s_layout.setBackground(mContext.getResources().getDrawable(R.drawable.shape_snackbar, null));

        snackbar.show();
    }

    public void dismiss(){
        snackbar.dismiss();
    }

    public void setOnDismissListener(OnDismissListener mOnDismissListener) {
        this.mOnDismissListener = mOnDismissListener;
    }

    public interface OnDismissListener {
        void onDismiss(Snackbar snackbar);
    }
}
