package com.runupstdio.culturenesia.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.runupstdio.culturenesia.Model.ProvinsiEnsiklopedi;
import com.runupstdio.culturenesia.Model.PulauEnsiklopedi;
import com.runupstdio.culturenesia.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ProvinsiAdapter extends ExpandableRecyclerViewAdapter<PulauViewHolder, ProvinsiViewHolder> {

    public ProvinsiAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public PulauViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pulau, parent, false);
        return new PulauViewHolder(v);
    }

    @Override
    public ProvinsiViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_provinsi, parent, false);
        return new ProvinsiViewHolder(v);
    }

    @Override
    public void onBindGroupViewHolder(PulauViewHolder holder, int flatPosition, ExpandableGroup group) {
        final PulauEnsiklopedi pulau = (PulauEnsiklopedi) group;
        holder.bind(pulau);
    }

    @Override
    public void onBindChildViewHolder(ProvinsiViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final ProvinsiEnsiklopedi provinsi = (ProvinsiEnsiklopedi) group.getItems().get(childIndex);
        holder.bind(provinsi);
    }
}

