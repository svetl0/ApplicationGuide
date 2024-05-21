package com.example.myapplicationguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class InfoActivity extends AppCompatActivity {

    PieChart pieChart;
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
                        R.color.автобус));
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
    }
}