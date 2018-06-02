package com.factorybyte.demo;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.factorybyte.demo.helper.DisableSwiftBottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigation);

        DisableSwiftBottomNavigationView.disableShiftMode(navigationView);


    }
}
