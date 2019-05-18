package com.runupstdio.culturenesia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.runupstdio.culturenesia.Adapter.ProvinsiAdapter;
import com.runupstdio.culturenesia.Model.ProvinsiEnsiklopedi;
import com.runupstdio.culturenesia.Model.PulauEnsiklopedi;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnsiklopediFragment extends Fragment{

    RecyclerView rv_Search;
    RecyclerView rv_Ensiklopedi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ensiklopedi, container, false);

        rv_Ensiklopedi = view.findViewById(R.id.rv_Ensiklopedi);
        rv_Ensiklopedi.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Initialize your Firebase app
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Reference to your entire Firebase database
        DatabaseReference parentReference = database.getReference().child("Ensiklopedi");

        //reading data from firebase
        parentReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<PulauEnsiklopedi> pulau = new ArrayList<>();
                for (final DataSnapshot snapshot : dataSnapshot.getChildren()){

                    final String ParentKey = snapshot.getKey().toString();

                    snapshot.child("Ensiklopedi").getValue();

                    DatabaseReference childReference =
                            FirebaseDatabase.getInstance().getReference().child("Ensiklopedi").child(ParentKey);
                    childReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            final List<ProvinsiEnsiklopedi> provinsi = new ArrayList<>();


                            for (DataSnapshot snapshot1:dataSnapshot.getChildren())
                            {
                                final String ChildValue =  snapshot1.getValue().toString();

                                snapshot1.child("Ensiklopedi").getValue();

                                provinsi.add(new ProvinsiEnsiklopedi(ChildValue));

                            }

                            pulau.add(new PulauEnsiklopedi(ParentKey, provinsi));

                            ProvinsiAdapter adapter = new ProvinsiAdapter(pulau);

                            rv_Ensiklopedi.setAdapter(adapter);

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            System.out.println("Failed to read value." + error.toException());
                        }

                    });}}

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        rv_Search = view.findViewById(R.id.rv_Search);
        rv_Search.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
