package com.factorybyte.demo;

import android.Manifest;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.factorybyte.demo.adapters.ViewPagerAdapter;
import com.factorybyte.demo.fragments.EducationFragment;
import com.factorybyte.demo.fragments.HealthFragment;
import com.factorybyte.demo.fragments.SportsFragment;
import com.factorybyte.demo.fragments.TravelFragment;
import com.factorybyte.demo.fragments.ViolenceFragment;
import com.factorybyte.demo.helpers.BottomNavigationViewHelper;


public class MainActivity extends AppCompatActivity {

    //definimos varibles
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private int indexPage = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showIntro();






        //conectamos con la vista
        navigationView = findViewById(R.id.navigation);

        BottomNavigationViewHelper.disableShiftMode(navigationView);



        initConfig();

        viewPager =  findViewById(R.id.viewPager);




        initializateView();

        //adaptador para los fragmentos

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_health:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_sports:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_education:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.navigation_violence:
                        viewPager.setCurrentItem(3);
                        return true;
                    case R.id.navigation_travel:
                        viewPager.setCurrentItem(4);
                        return true;

                }


                return false;
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });






    }

    private void initializateView() {


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        HealthFragment healthFragment = new HealthFragment();
        adapter.addFragment(healthFragment);


        SportsFragment sportsFragment = new SportsFragment();
        adapter.addFragment(sportsFragment);


        EducationFragment educationFragment = new EducationFragment();
        adapter.addFragment(educationFragment);

        ViolenceFragment violenceFragment = new ViolenceFragment();
        adapter.addFragment(violenceFragment);

        TravelFragment travelFragment = new TravelFragment();
        adapter.addFragment(travelFragment);


        viewPager.setAdapter(adapter);


        viewPager.setCurrentItem(indexPage);



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


        navigationView.setSelectedItemId(R.id.navigation_education);
    }
}
