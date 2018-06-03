package com.factorybyte.demo.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.factorybyte.demo.R;

public class DoctorsViewHolder extends RecyclerView.ViewHolder {




    private TextView doctorName;


    public DoctorsViewHolder(View itemView) {
        super(itemView);
        this.doctorName = itemView.findViewById(R.id.health_title);
    }



    public void setDoctorName(String doctorName) {
        this.doctorName.setText(doctorName);
    }





}
