package com.runupstdio.culturenesia.Adapter;

import android.view.View;
import android.widget.TextView;

import com.runupstdio.culturenesia.Model.PulauEnsiklopedi;
import com.runupstdio.culturenesia.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class PulauViewHolder extends GroupViewHolder {

    private TextView namaPulau;

    public PulauViewHolder(View itemView) {
        super(itemView);

        namaPulau = itemView.findViewById(R.id.nama_Pulau);
    }

    public void bind(PulauEnsiklopedi pulau){
        namaPulau.setText(pulau.getTitle());
    }
}
