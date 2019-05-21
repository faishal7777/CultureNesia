package com.runupstdio.culturenesia;


import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment implements View.OnClickListener {

    CarouselView sliderLayout;
    CarouselView mCarousel2;
    int[] sampleImages = {R.drawable.quote1, R.drawable.quote3, R.drawable.quote2};
    int[] sampleImages2 = {R.drawable.pahlawan1, R.drawable.pahlawan2};
    ConstraintLayout mJawatimur, mJakarta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beranda, container, false);

        sliderLayout = v.findViewById(R.id.imageSlider);
        mCarousel2 = v.findViewById(R.id.carousel2);
        mJawatimur = v.findViewById(R.id.jawatimur);
        mJakarta = v.findViewById(R.id.jakarta);

        sliderLayout.setPageCount(sampleImages.length);
        sliderLayout.setImageListener(imageListener);
        mCarousel2.setPageCount(sampleImages2.length);
        mCarousel2.setImageListener(imageListener2);
        mJawatimur.setOnClickListener(this);
        mJakarta.setOnClickListener(this);

        return v;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    ImageListener imageListener2 = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages2[position]);
        }
    };

    @Override
    public void onClick(View v) {
        Intent letsgo = new Intent(v.getContext(), ClickedPageActivity.class);
        switch (v.getId()){
            case R.id.jawatimur:
                letsgo.putExtra("provinsi", "Jawa Timur");
                break;
            case R.id.jakarta:
                letsgo.putExtra("provinsi", "DKI Jakarta");
                break;
        }
        startActivity(letsgo);
    }
}
