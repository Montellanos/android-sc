package com.factorybyte.demo.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.factorybyte.demo.R;
import com.factorybyte.demo.adapters.DoctorsRecyclerViewAdapter;
import com.factorybyte.demo.models.Doctor;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthFragment extends Fragment {


    private View rootView;
    private RecyclerView recyclerView;

    private DoctorsRecyclerViewAdapter adapter;


    private FirebaseFirestore table = FirebaseFirestore.getInstance();





    public HealthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_health, container, false);


        recyclerView = rootView.findViewById(R.id.recyclerView_health);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);



        //aqui pedimos la info

        Query query = table.collection("doctors");


        FirestoreRecyclerOptions<Doctor> options = new FirestoreRecyclerOptions.Builder<Doctor>()
                .setQuery(query, Doctor.class)
                .build();

        adapter = new DoctorsRecyclerViewAdapter(options);


        recyclerView.setAdapter(adapter);




        return rootView;
    }


    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
