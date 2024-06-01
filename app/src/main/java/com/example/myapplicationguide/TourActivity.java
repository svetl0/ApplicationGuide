package com.example.myapplicationguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class TourActivity extends AppCompatActivity {

    private ArrayList<SliderData> sliderDataArrayList1;
    private ArrayList<SliderData> sliderDataArrayList2;
    private ArrayList<SliderData> sliderDataArrayList3;
    FirebaseFirestore db;
    private SliderView sliderView1;
    private SliderView sliderView2;
    private SliderView sliderView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        sliderDataArrayList1 = new ArrayList<>();
        sliderDataArrayList2 = new ArrayList<>();
        sliderDataArrayList3 = new ArrayList<>();


        sliderView1 = findViewById(R.id.imageSlider1);
        sliderView2 = findViewById(R.id.imageSlider2);
        sliderView3 = findViewById(R.id.imageSlider3);
        db = FirebaseFirestore.getInstance();

        loadImages1();
        loadImages2();
        loadImages3();

        CardView tour1 = findViewById(R.id.tour1);
        CardView tour2 = findViewById(R.id.tour2);
        CardView tour3 = findViewById(R.id.tour3);
        tour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TourActivity.this, Tour1.class) ;
                startActivity(i);
            }
        });
        tour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TourActivity.this, Tour2.class) ;
                startActivity(i);
            }
        });

        tour3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TourActivity.this, Tour3.class) ;
                startActivity(i);
            }
        });
    }
    private void loadImages1() {
        
        db.collection("sliderForTour1").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    SliderData sliderData = documentSnapshot.toObject(SliderData.class);
                    Log.e("FFFFFFFFFF", sliderData.getImgUrl());
                    SliderData model = new SliderData();

                    model.setImgUrl(sliderData.getImgUrl());

                    sliderDataArrayList1.add(model);
                    SliderAdapter adapter = new SliderAdapter(TourActivity.this, sliderDataArrayList1);

                    sliderView1.setSliderAdapter(adapter);
                    sliderView1.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

                    sliderView1.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

                    sliderView1.setScrollTimeInSec(3);

                    sliderView1.setAutoCycle(true);

                    sliderView1.startAutoCycle();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(TourActivity.this, "Fail to load slider data..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadImages2() {

        db.collection("sliderForTour2").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                    SliderData sliderData = documentSnapshot.toObject(SliderData.class);
                    SliderData model = new SliderData();

                    model.setImgUrl(sliderData.getImgUrl());


                    sliderDataArrayList2.add(model);

                    SliderAdapter adapter = new SliderAdapter(TourActivity.this, sliderDataArrayList2);

                    sliderView2.setSliderAdapter(adapter);
                    sliderView2.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

                    sliderView2.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

                    sliderView2.setScrollTimeInSec(3);
                    sliderView2.setAutoCycle(true);

                    sliderView2.startAutoCycle();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(TourActivity.this, "Fail to load slider data..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadImages3() {

        db.collection("sliderForTour3").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                    SliderData sliderData = documentSnapshot.toObject(SliderData.class);
                    SliderData model = new SliderData();

                    model.setImgUrl(sliderData.getImgUrl());

                    sliderDataArrayList3.add(model);

                    SliderAdapter adapter = new SliderAdapter(TourActivity.this, sliderDataArrayList3);

                    sliderView3.setSliderAdapter(adapter);
                    sliderView3.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);


                    sliderView3.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

                    sliderView3.setScrollTimeInSec(3);

                    sliderView3.setAutoCycle(true);

                    sliderView3.startAutoCycle();

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(TourActivity.this, "Fail to load slider data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


