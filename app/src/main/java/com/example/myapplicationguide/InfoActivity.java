package com.example.myapplicationguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    PieChart pieChart;
    private SliderAdapter adapter;
    private ArrayList<SliderData> sliderDataArrayList;
    FirebaseFirestore db;
    private SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        pieChart = findViewById(R.id.piechart);
        pieChart.addPieSlice(
                new PieModel(
                        "Такси",
                        200,
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Троллейбус",
                        32,
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Трамвай",
                        32,
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel("Маршрутка",
                        40,
                        Color.parseColor("#29B6F6")));
        pieChart.addPieSlice(
                new PieModel(
                        "Автобус",
                        32,
                        Color.parseColor("#37177E")));
        Button toListButton = findViewById(R.id.ToPLacesButton);
        Button toToursButton = findViewById(R.id.ToToursButton);
        toListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, MainPlacesActivity.class);
                startActivity(i);
            }
        });
        toToursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, TourActivity.class);
                startActivity(i);
            }
        });
        sliderDataArrayList = new ArrayList<>();

        sliderView = findViewById(R.id.InfoSlider);
        db = FirebaseFirestore.getInstance();

        loadImages();
    }

    private void loadImages() {

        db.collection("slider").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                    SliderData sliderData = documentSnapshot.toObject(SliderData.class);
                    SliderData model = new SliderData();

                    model.setImgUrl(sliderData.getImgUrl());


                    sliderDataArrayList.add(model);


                    adapter = new SliderAdapter(InfoActivity.this, sliderDataArrayList);


                    sliderView.setSliderAdapter(adapter);


                    sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

                    sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);


                    sliderView.setScrollTimeInSec(3);

                    sliderView.setAutoCycle(true);


                    sliderView.startAutoCycle();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(InfoActivity.this, "Fail to load slider data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}