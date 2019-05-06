package com.runupstdio.culturenesia.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.runupstdio.culturenesia.Model.ProvinsiEnsiklopedi;
import com.runupstdio.culturenesia.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ProvinsiViewHolder extends ChildViewHolder {

    private TextView namaProvinsi;
    private RoundedImageView imgProvinsi;
    Context mContext;

    public ProvinsiViewHolder(View itemView) {
        super(itemView);

        namaProvinsi = itemView.findViewById(R.id.nama_List_Provinsi);
        imgProvinsi = itemView.findViewById(R.id.img_List_Provinsi);
    }

    public void bind(ProvinsiEnsiklopedi provinsi) {
        namaProvinsi.setText(provinsi.name);
        Glide.with(mContext)
                .asBitmap()
                .load(provinsi.img)
                .into(imgProvinsi);
    }
}
