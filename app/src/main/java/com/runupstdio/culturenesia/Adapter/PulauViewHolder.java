package com.runupstdio.culturenesia.Adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.runupstdio.culturenesia.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class PulauViewHolder extends GroupViewHolder {

    private TextView namaPulau;

    public PulauViewHolder(View itemView) {
        super(itemView);

        namaPulau = itemView.findViewById(R.id.nama_Pulau);
    }

    @Override
    public void expand() {
        namaPulau.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_black_24dp, 0);
        Log.i("Adapter", "expand");
    }

    @Override
    public void collapse() {
        Log.i("Adapter", "collapse");
        namaPulau.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up_black_24dp, 0);
    }

    public void bind(ExpandableGroup group){
        namaPulau.setText(group.getTitle());
    }
}
