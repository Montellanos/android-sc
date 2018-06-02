package com.factorybyte.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;

public class IntroActivity extends AppIntro2 {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntro2Fragment.newInstance("Slide", "Description 1", R.drawable.intro_nurse, getResources().getColor(R.color.colorPrimaryDark)));


        addSlide(AppIntro2Fragment.newInstance("Slide 2", "Description 2", R.drawable.intro_player, getResources().getColor(R.color.colorPrimaryDark)));


        addSlide(AppIntro2Fragment.newInstance("Slide 3", "Description 3", R.drawable.intro_teache, getResources().getColor(R.color.colorPrimaryDark)));

        // OPTIONAL METHODS
        // Override bar/separator color.

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

    }


    @Override
    public void onSkipPressed(Fragment currentFragment) {
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        finish();
    }






}
