package com.runupstdio.culturenesia.Adapter;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.runupstdio.culturenesia.Model.ProvinsiEnsiklopedi;
import com.runupstdio.culturenesia.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ProvinsiViewHolder extends ChildViewHolder {

    private TextView namaProvinsi;
    private RoundedImageView imgProvinsi;
    private CardView CVProvinsi;

    public ProvinsiViewHolder(View itemView) {
        super(itemView);


        namaProvinsi = itemView.findViewById(R.id.nama_List_Provinsi);
        imgProvinsi = itemView.findViewById(R.id.img_List_Provinsi);
        CVProvinsi = itemView.findViewById(R.id.cardViewProvinsi);
    }

    public void bind(ProvinsiEnsiklopedi provinsi, ExpandableGroup group) {
        namaProvinsi.setText(provinsi.name);
        final String stringProvinsi = namaProvinsi.getText().toString();

        if (group.getTitle().equals("Pulau Jawa")) {
            imgProvinsi.setImageResource(R.drawable.jawa);
        } else if (group.getTitle().equals("Pulau Kalimantan")) {
            imgProvinsi.setImageResource(R.drawable.kalimantan);
        } else if (group.getTitle().equals("Kepulauan Maluku")) {
            imgProvinsi.setImageResource(R.drawable.kepulauan_maluku);
        } else if (group.getTitle().equals("Kepulauan Nusa Tenggara")) {
            imgProvinsi.setImageResource(R.drawable.kepulauan_nusa_tenggara);
        } else if (group.getTitle().equals("Pulau Papua")) {
            imgProvinsi.setImageResource(R.drawable.papua);
        } else if (group.getTitle().equals("Pulau Sulawesi")) {
            imgProvinsi.setImageResource(R.drawable.sulawesi);
        } else if (group.getTitle().equals("Pulau Sumatra")) {
            imgProvinsi.setImageResource(R.drawable.sumatra);
        }

//        namaProvinsi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent clickedProvinsi = new Intent(v.getContext(), ClickedPageActivity.class);
//                clickedProvinsi.putExtra("provinsi", stringProvinsi);
//                start
//            }
//        });
    }
}
