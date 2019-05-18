package com.runupstdio.culturenesia;


import android.os.Bundle;
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
public class BerandaFragment extends Fragment {

    CarouselView sliderLayout;
    int[] sampleImages = {R.drawable.quote1, R.drawable.quote1, R.drawable.quote1, R.drawable.quote1};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beranda, container, false);

        sliderLayout = v.findViewById(R.id.imageSlider);
        sliderLayout.setPageCount(sampleImages.length);
        sliderLayout.setImageListener(imageListener);

        return v;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
