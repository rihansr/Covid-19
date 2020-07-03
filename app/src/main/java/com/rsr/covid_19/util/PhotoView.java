package com.rsr.covid_19.util;

import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.ortiz.touchview.TouchImageView;
import com.rsr.covid_19.R;

public class PhotoView {

    private Context mContext;
    private String  image;

    public PhotoView(Context mContext, String image) {
        this.mContext = mContext;
        this.image = image;
    }

    public void show() {
        View view = View.inflate(mContext, R.layout.dialog_layout_photo_view, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext, R.style.FullScreenPhotoDialog);
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(true);

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        if(image == null) alertDialog.dismiss();

        TouchImageView photoHolder = view.findViewById(R.id.photoHolder);
        Glide.with(mContext)
                .load(image)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .error(R.drawable.ic_placeholder)          /* If given url shows any error */
                .fallback(R.drawable.ic_placeholder)       /* If pass a null url */
                .into(photoHolder);

        AppCompatImageButton backBtn = view.findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
