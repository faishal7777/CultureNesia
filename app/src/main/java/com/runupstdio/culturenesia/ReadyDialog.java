package com.runupstdio.culturenesia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class ReadyDialog extends DialogFragment {

    Button mOke;
    int idLevel = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_ready, null);
        builder.setView(view);

        mOke = view.findViewById(R.id.btn_Oke_Checkout);
        mOke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuiz = new Intent(getActivity(), QuizActivity.class);
                if(idLevel == 1) {
                    startQuiz.putExtra("level", "1");
                    startActivity(startQuiz);
                } else if (idLevel == 2){
                    startQuiz.putExtra("level", "2");
                    startActivity(startQuiz);
                } else if(idLevel == 3) {
                    startQuiz.putExtra("level", "3");
                    startActivity(startQuiz);
                } else if(idLevel == 4) {
                    startQuiz.putExtra("level", "4");
                    startActivity(startQuiz);
                }
                getDialog().dismiss();
            }
        });
        return builder.create();
    }

    public void setType(int idLevel){
        this.idLevel = idLevel;
    }
}
