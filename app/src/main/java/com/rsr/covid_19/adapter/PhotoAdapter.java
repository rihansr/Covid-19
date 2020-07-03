package com.rsr.covid_19.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.rsr.covid_19.R;
import com.rsr.covid_19.util.PhotoView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private Context         mContext;
    private List<String>    photoPaths = new ArrayList<>();

    public PhotoAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setPhotoPaths(List<String> photoPaths) {
        this.photoPaths = photoPaths;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_photo, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView photoHolder;

        private ViewHolder(View v) {
            super(v);
            photoHolder = v.findViewById(R.id.photoHolder);
        }
    }

    @Override
    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    public void onBindViewHolder(@NonNull final PhotoAdapter.ViewHolder holder, final int position) {
        final String photoPath = photoPaths.get(position);
        if (photoPath != null && !photoPath.isEmpty()) holder.photoHolder.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load(photoPath)
                .override((int) mContext.getResources().getDimension(R.dimen.icon_Size_Extra_Large),
                        (int) mContext.getResources().getDimension(R.dimen.icon_Size_Extra_Large))
                .error(R.drawable.ic_placeholder)
                .fallback(R.drawable.ic_placeholder)
                .into(holder.photoHolder);

        holder.photoHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (photoPath != null && !photoPath.isEmpty()) new PhotoView(mContext, photoPath).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoPaths.size();
    }
}
