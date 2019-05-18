package com.runupstdio.culturenesia;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nineoldandroids.view.ViewHelper;

public class ClickedPageActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {

    DatabaseReference dReference;
    TextView mProvinsi, mKeterangan, mDesc, mGeografis, suku1, suku2,
            bahasa, tarian1, tarian2, tarian3, senjata1,
            senjata2, rumah1, rumah2, wisata1, wisata2;
    ImageView imgProvinsi, imgSuku, imgTarian1, imgTarian2,
            imgSenjata, imgRumah, imgWisata1, imgWisata2;
    Bundle ini;
    String extras;
    Context mContext;
    private ObservableScrollView mScrollView;
    private View mToolbarView, mImageView;
    private int mParallaxImageHeight;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_page);
        mContext = this;
        ini = getIntent().getExtras();
        extras = ini.getString("provinsi");

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        mScrollView = findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);
        mToolbarView = findViewById(R.id.toolbar);
        mImageView = findViewById(R.id.img_Provinsi);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);
        setSupportActionBar((Toolbar) mToolbarView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(extras);

        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.colorPrimary)));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_btn);

        //TextView
        mProvinsi = findViewById(R.id.provinsi);
        mKeterangan = findViewById(R.id.keteranganProvinsi);
        mDesc = findViewById(R.id.desc);
        mGeografis = findViewById(R.id.geografis);
        suku1 = findViewById(R.id.suku_1);
        suku2 = findViewById(R.id.suku_2);
        bahasa = findViewById(R.id.bahasa);
        tarian1 = findViewById(R.id.tarian_1);
        tarian2 = findViewById(R.id.tarian_2);
        tarian3 = findViewById(R.id.tarian_3);
        senjata1 = findViewById(R.id.senjata_1);
        senjata2 = findViewById(R.id.senjata_2);
        rumah1 = findViewById(R.id.rumah_Adat_1);
        rumah2 = findViewById(R.id.rumah_Adat_2);
        wisata1 = findViewById(R.id.tempat_Wisata_1);
        wisata2 = findViewById(R.id.tempat_Wisata_2);

        //ImageView
        imgProvinsi = findViewById(R.id.img_Provinsi);
        imgSuku = findViewById(R.id.img_Suku);
        imgTarian1 = findViewById(R.id.img_Tarian_1);
        imgTarian2 = findViewById(R.id.img_Tarian_2);
        imgSenjata = findViewById(R.id.img_Senjata);
        imgRumah = findViewById(R.id.img_Rumah_Adat);
        imgWisata1 = findViewById(R.id.img_Tempat_Wisata_1);
        imgWisata2 = findViewById(R.id.img_Tempat_Wisata_2);

        setParentDB();

        loadData();

    }

    private void setParentDB() {
        if (extras.equals("Banten")){
            extras = "01";
        } else if (extras.equals("DKI Jakarta")){
            extras ="02";
        }
    }

    private void loadData() {
        dReference = FirebaseDatabase.getInstance().getReference().child("Provinsi").child(extras);
        dReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("load", extras);

                //String TextView
                String namaProvinsi = dataSnapshot.child("provinsi").getValue().toString();
                String ketProvinsi = dataSnapshot.child("pulau").getValue().toString();
                String desc = dataSnapshot.child("ketProvinsi").getValue().toString();
                String geografis = dataSnapshot.child("geografis").getValue().toString();
                String sukuProvinsi = dataSnapshot.child("suku1").getValue().toString();
                String ketSukuProvinsi = dataSnapshot.child("suku2").getValue().toString();
                String bahasaProvinsi = dataSnapshot.child("bahasa").getValue().toString();
                String tarianProvinsi1 = dataSnapshot.child("tarian1").getValue().toString();
                String tarianProvinsi2 = dataSnapshot.child("tarian2").getValue().toString();
                String ketTarianProvinsi = dataSnapshot.child("tarian3").getValue().toString();
                String senjataProvinsi = dataSnapshot.child("senjata1").getValue().toString();
                String ketSenjataProvinsi = dataSnapshot.child("senjata2").getValue().toString();
                String rumahProvinsi = dataSnapshot.child("rumahAdat1").getValue().toString();
                String ketRumahProvinsi = dataSnapshot.child("rumahAdat2").getValue().toString();
                String wisataProvinsi1 = dataSnapshot.child("wisata1").getValue().toString();
                String wisataProvinsi2 = dataSnapshot.child("wisata2").getValue().toString();

                //String ImageView
                String sImgProvinsi = dataSnapshot.child("imgProvinsi").getValue().toString();
                String sImgSuku = dataSnapshot.child("imgSuku").getValue().toString();
                String sImgTarian1 = dataSnapshot.child("imgTarian1").getValue().toString();
                String sImgTarian2 = dataSnapshot.child("imgTarian2").getValue().toString();
                String sImgSenjata = dataSnapshot.child("imgSenjata").getValue().toString();
                String sImgRumah = dataSnapshot.child("imgRumahAdat").getValue().toString();
                String sImgWisata1 = dataSnapshot.child("imgWisata1").getValue().toString();
                String sImgWisata2 = dataSnapshot.child("imgWisata2").getValue().toString();

                //TextView
                mProvinsi.setText(namaProvinsi);
                mKeterangan.setText("Provinsi yang terletak pada pulau " + ketProvinsi);
                mDesc.setText(desc);
                mGeografis.setText(geografis);
                suku1.setText(sukuProvinsi);
                suku2.setText(ketSukuProvinsi);
                bahasa.setText(bahasaProvinsi);
                tarian1.setText(tarianProvinsi1);
                tarian2.setText(tarianProvinsi2);
                tarian3.setText(ketTarianProvinsi);
                senjata1.setText(senjataProvinsi);
                senjata2.setText(ketSenjataProvinsi);
                rumah1.setText(rumahProvinsi);
                rumah2.setText(ketRumahProvinsi);
                wisata1.setText(wisataProvinsi1);
                wisata2.setText(wisataProvinsi2);

                //ImageView
                Glide.with(mContext)
                        .asBitmap()
                        .load(sImgProvinsi)
                        .into(imgProvinsi);

                Glide.with(mContext)
                        .asBitmap()
                        .load(sImgSuku)
                        .into(imgSuku);

                Glide.with(mContext)
                        .asBitmap()
                        .load(sImgTarian1)
                        .into(imgTarian1);

                Glide.with(mContext)
                        .asBitmap()
                        .load(sImgTarian2)
                        .into(imgTarian2);

                Glide.with(mContext)
                        .asBitmap()
                        .load(sImgSenjata)
                        .into(imgSenjata);

                Glide.with(mContext)
                        .asBitmap()
                        .load(sImgRumah)
                        .into(imgRumah);

                Glide.with(mContext)
                        .asBitmap()
                        .load(sImgWisata1)
                        .into(imgWisata1);
                Glide.with(mContext)
                        .asBitmap()
                        .load(sImgWisata2)
                        .into(imgWisata2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.colorPrimary);
        float alpha = Math.min(1, (float)scrollY / mParallaxImageHeight);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        if ((alpha == 1)) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        } else {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_btn);
        }
        ViewHelper.setTranslationY(mImageView, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}
