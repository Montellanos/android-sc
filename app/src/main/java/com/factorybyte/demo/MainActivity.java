package com.factorybyte.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.factorybyte.demo.helpers.BottomNavigationViewHelper;


public class MainActivity extends AppCompatActivity {

    //definimos varibles
    private BottomNavigationView navigationView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showIntro();



        //conectamos con la vista
        navigationView = findViewById(R.id.navigation);

        BottomNavigationViewHelper.disableShiftMode(navigationView);

        textView = findViewById(R.id.titleApp);


        initConfig();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_health:
                        textView.setText(getResources().getString(R.string.navigation_health));
                        return true;
                    case R.id.navigation_sports:
                        textView.setText(getResources().getString(R.string.navigation_sports));
                        return true;
                    case R.id.navigation_education:
                        textView.setText(getResources().getString(R.string.navigation_education));
                        return true;
                    case R.id.navigation_violence:
                        textView.setText(getResources().getString(R.string.navigation_violence));
                        return true;
                    case R.id.navigation_travel:
                        textView.setText(getResources().getString(R.string.navigation_travel));
                        return true;

                }


                return false;
            }
        });






    }

    private void showIntro() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean control = pref.getBoolean("startFirsts", false);
                if (!control){
                    Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
                    startActivity(intent);
                    SharedPreferences.Editor e =pref.edit();
                    e.putBoolean("startFirsts", true);
                    e.apply();
                }

            }
        });

        thread.start();


    }

    private void initConfig() {

        textView.setText(getResources().getString(R.string.navigation_education));

        navigationView.setSelectedItemId(R.id.navigation_education);
    }
}
