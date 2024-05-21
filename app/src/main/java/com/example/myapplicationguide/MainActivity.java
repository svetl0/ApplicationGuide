package com.example.myapplicationguide;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;


public class MainActivity  extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();

        // инициализация была выполнена в getTabHost
        // метод setup вызывать не нужно

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("Sing Up");
        tabSpec.setIndicator("Sing Up");
        tabSpec.setContent(new Intent(this,SingUp.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Log In");
        tabSpec.setIndicator("Log in");
        tabSpec.setContent(new Intent(this, Login.class));
        tabHost.addTab(tabSpec);
    }
}