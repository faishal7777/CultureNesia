package com.runupstdio.culturenesia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class QuizFragment extends Fragment implements View.OnClickListener {

    CardView mLevel1, mLevel2, mLevel3, mLevel4;
    public int level;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz, container, false);

        mLevel1 = v.findViewById(R.id.level1);
        mLevel2 = v.findViewById(R.id.level2);
        mLevel3 = v.findViewById(R.id.level3);
        mLevel4 = v.findViewById(R.id.level4);

        mLevel1.setOnClickListener(this);
        return v;
    }

    public void showDialog(){
        ReadyDialog popupDialog = new ReadyDialog();
        if(level == 1)
            popupDialog.setType(1);
        else if(level == 2)
            popupDialog.setType(2);
        else if(level == 3)
            popupDialog.setType(3);
        else if(level == 4)
            popupDialog.setType(4);
        popupDialog.show(getFragmentManager(),"reserve dialog");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.level1:
                level = 1;
                showDialog();
                break;
            case R.id.level2:
                level = 2;
                showDialog();
                break;
            case R.id.level3:
                level = 3;
                showDialog();
                break;
            case R.id.level4:
                level = 4;
                showDialog();
                break;

        }
    }
}
