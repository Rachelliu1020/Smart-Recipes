package com.example.rache.smartrecipes;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
    }

    public void customizeRecipe(final View v){
        final Intent intent_custom = new Intent(this, Customize_Activity.class);
        startActivity(intent_custom);
    }

    public void breakfastGallery(final View v){
        final Intent intent_bfGallery= new Intent(this, BreakfastGallery.class);
        startActivity(intent_bfGallery);
    }

    public void lunchGallery(final View v){
        final Intent intent_lunchGallery = new Intent(this, LunchGallery.class);
        startActivity(intent_lunchGallery);
    }

    public void dinnerGallery(final View v){
        final Intent intent_dinnerGallery = new Intent(this, DinnerGallery.class);
        startActivity(intent_dinnerGallery);
    }
}
