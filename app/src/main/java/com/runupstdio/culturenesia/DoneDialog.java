package com.runupstdio.culturenesia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class DoneDialog extends DialogFragment {
    Button mDone;
    int score = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_ready, null);
        builder.setView(view);

        mDone = view.findViewById(R.id.btn_Oke_Checkout);
        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuiz = new Intent(getActivity(), BottomNavbarActivity.class);
                startQuiz.putExtra("point", "1");
                startActivity(startQuiz);
                getDialog().dismiss();
            }
        });
        return builder.create();
    }

    public void setNilai(int score){
        this.score = score;
    }
}
