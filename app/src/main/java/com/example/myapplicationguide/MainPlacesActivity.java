package com.example.myapplicationguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainPlacesActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_places);
        TabHost tabHost = getTabHost();


        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Места");
        tabSpec.setContent(new Intent(this, DataDetails.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Избранное");
        tabSpec.setContent(new Intent(this, LikedPlaces.class));
        tabHost.addTab(tabSpec);
    }
}