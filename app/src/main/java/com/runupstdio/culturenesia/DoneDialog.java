package com.runupstdio.culturenesia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.runupstdio.culturenesia.Model.User;

public class DoneDialog extends DialogFragment {
    Button mDone;
    int score = 0;
    FirebaseUser user;
    FirebaseAuth auth;
    DatabaseReference reference;
    int scoreGetInt;
    TextView skorSaatIni;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_done, null);
        builder.setView(view);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        mDone = view.findViewById(R.id.btn_Oke);
        skorSaatIni = view.findViewById(R.id.score);
        skorSaatIni.setText(String.valueOf(score));
        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuiz = new Intent(getActivity(), BottomNavbarActivity.class);
                reference = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User userInfo = dataSnapshot.getValue(User.class);
                        String scoreGet = userInfo.getScore();
                        scoreGetInt = Integer.parseInt(scoreGet);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                if (score > scoreGetInt){
                    reference.child("score").setValue(String.valueOf(score));
                } else {

                }

                getDialog().dismiss();
                startActivity(startQuiz);
            }
        });
        return builder.create();
    }

    public void setNilai(int score){
        this.score = score;
    }
}
