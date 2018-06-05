package com.factorybyte.demo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.factorybyte.demo.models.Doctor;
import com.factorybyte.demo.viewholders.DoctorsViewHolder;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;


import com.factorybyte.demo.R;

public class DoctorsRecyclerViewAdapter extends FirestoreRecyclerAdapter<Doctor, DoctorsViewHolder>{



    public DoctorsRecyclerViewAdapter(@NonNull FirestoreRecyclerOptions<Doctor> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull DoctorsViewHolder holder, int position, @NonNull Doctor model) {

        holder.setDoctorName(model.getName());
        holder.setImageView(model.getImage());
        holder.setButton(model.getTelephone());
    }

    @NonNull
    @Override
    public DoctorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.desing_health, parent, false);
        return new DoctorsViewHolder(view);
    }
}
