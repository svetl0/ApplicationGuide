package com.example.myapplicationguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Tour1 extends AppCompatActivity {

    int c1 = 0;
    int c2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour1);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.map_container3, new MapTour1()).commit();
        ImageButton i1 = findViewById(R.id.img1tour1);
        ImageButton i2 = findViewById(R.id.img2tour1);
/*
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1%4 == 1){
                    i1.setImageResource(R.drawable.i1tour1);
                    c1 ++;
                }
                else if (c1%4 == 2){
                    i1.setImageResource(R.drawable.i2tour1);
                    c1 ++;
                }
                else if (c1%4 == 3){
                    i1.setImageResource(R.drawable.i3tour1);
                    c1 ++;
                }
                else if (c1%4 == 0){
                    i1.setImageResource(R.drawable.i4tour1);
                    c1 ++;
                }
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c2%4 == 1){
                    i2.setImageResource(R.drawable.i5tour1);
                    c2 ++;
                }
                else if (c2%4 == 2){
                    i2.setImageResource(R.drawable.i6tour1);
                    c2 ++;
                }
                else if (c2%4 == 3){
                    i2.setImageResource(R.drawable.i7tour1);
                    c2 ++;
                }
                else if (c2%4 == 0){
                    i2.setImageResource(R.drawable.i8tour1);
                    c2 ++;
                }
            }
        });
*/
    }
}