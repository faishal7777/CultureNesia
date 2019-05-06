package com.runupstdio.culturenesia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.runupstdio.culturenesia.Adapter.ProvinsiAdapter;
import com.runupstdio.culturenesia.Model.ProvinsiEnsiklopedi;
import com.runupstdio.culturenesia.Model.PulauEnsiklopedi;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnsiklopediFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ensiklopedi, container, false);

        RecyclerView rv_Ensiklopedi = view.findViewById(R.id.rv_Ensiklopedi);
        rv_Ensiklopedi.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<PulauEnsiklopedi> pulau = new ArrayList<>();

        ArrayList<ProvinsiEnsiklopedi> pulau_jawa = new ArrayList<>();
        pulau_jawa.add(new ProvinsiEnsiklopedi("Jawa Timur", "https://picsum.photos/500"));
        pulau_jawa.add(new ProvinsiEnsiklopedi("Jawa Tengah", "https://picsum.photos/500"));
        pulau_jawa.add(new ProvinsiEnsiklopedi("Jawa Barat", "https://picsum.photos/500"));

        PulauEnsiklopedi mJawa = new PulauEnsiklopedi("Pulau Jawa", pulau_jawa);
        pulau.add(mJawa);

        ArrayList<ProvinsiEnsiklopedi> pulau_sumatra = new ArrayList<>();
        pulau_sumatra.add(new ProvinsiEnsiklopedi("Aceh", "https://picsum.photos/500"));
        pulau_sumatra.add(new ProvinsiEnsiklopedi("Sumaatra Barat", "https://picsum.photos/500"));
        pulau_sumatra.add(new ProvinsiEnsiklopedi("Riau", "https://picsum.photos/500"));

        PulauEnsiklopedi mSumatra = new PulauEnsiklopedi("Pulau Sumatra", pulau_sumatra);
        pulau.add(mSumatra);

        ProvinsiAdapter adapter = new ProvinsiAdapter(pulau);
        rv_Ensiklopedi.setAdapter(adapter);
        return view;
    }
}
