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

                // inside the on success method we are running a for loop
                // and we are getting the data from Firebase Firestore
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                    // after we get the data we are passing inside our object class.
                    SliderData sliderData = documentSnapshot.toObject(SliderData.class);
                    Log.e("FFFFFFFFFF", sliderData.getImgUrl());
                    SliderData model = new SliderData();

                    // below line is use for setting our
                    // image url for our modal class.
                    model.setImgUrl(sliderData.getImgUrl());

                    // after that we are adding that
                    // data inside our array list.
                    sliderDataArrayList1.add(model);

                    // after adding data to our array list we are passing
                    // that array list inside our adapter class.
                    SliderAdapter adapter = new SliderAdapter(TourActivity.this, sliderDataArrayList1);

                    // below line is for setting adapter
                    // to our slider view
                    sliderView1.setSliderAdapter(adapter);
                    sliderView1.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

                    // below line is for setting auto cycle duration.
                    sliderView1.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

                    // below line is for setting
                    // scroll time animation
                    sliderView1.setScrollTimeInSec(3);

                    // below line is for setting auto
                    // cycle animation to our slider
                    sliderView1.setAutoCycle(true);

                    // below line is use to start
                    // the animation of our slider view.
                    sliderView1.startAutoCycle();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // if we get any error from Firebase we are
                // displaying a toast message for failure
                Toast.makeText(TourActivity.this, "Fail to load slider data..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadImages2() {
        // getting data from our collection and after
        // that calling a method for on success listener.
        db.collection("sliderForTour2").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                // inside the on success method we are running a for loop
                // and we are getting the data from Firebase Firestore
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                    // after we get the data we are passing inside our object class.
                    SliderData sliderData = documentSnapshot.toObject(SliderData.class);
                    SliderData model = new SliderData();

                    // below line is use for setting our
                    // image url for our modal class.
                    model.setImgUrl(sliderData.getImgUrl());

                    // after that we are adding that
                    // data inside our array list.
                    sliderDataArrayList2.add(model);

                    // after adding data to our array list we are passing
                    // that array list inside our adapter class.
                    SliderAdapter adapter = new SliderAdapter(TourActivity.this, sliderDataArrayList2);

                    // below line is for setting adapter
                    // to our slider view
                    sliderView2.setSliderAdapter(adapter);
                    sliderView2.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

                    // below line is for setting auto cycle duration.
                    sliderView2.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

                    // below line is for setting
                    // scroll time animation
                    sliderView2.setScrollTimeInSec(3);

                    // below line is for setting auto
                    // cycle animation to our slider
                    sliderView2.setAutoCycle(true);

                    // below line is use to start
                    // the animation of our slider view.
                    sliderView2.startAutoCycle();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // if we get any error from Firebase we are
                // displaying a toast message for failure
                Toast.makeText(TourActivity.this, "Fail to load slider data..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadImages3() {
        // getting data from our collection and after
        // that calling a method for on success listener.
        db.collection("sliderForTour3").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                // inside the on success method we are running a for loop
                // and we are getting the data from Firebase Firestore
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                    // after we get the data we are passing inside our object class.
                    SliderData sliderData = documentSnapshot.toObject(SliderData.class);
                    SliderData model = new SliderData();

                    // below line is use for setting our
                    // image url for our modal class.
                    model.setImgUrl(sliderData.getImgUrl());

                    // after that we are adding that
                    // data inside our array list.
                    sliderDataArrayList3.add(model);

                    // after adding data to our array list we are passing
                    // that array list inside our adapter class.
                    SliderAdapter adapter = new SliderAdapter(TourActivity.this, sliderDataArrayList3);

                    // below line is for setting adapter
                    // to our slider view
                    sliderView3.setSliderAdapter(adapter);
                    sliderView3.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

                    // below line is for setting auto cycle duration.
                    sliderView3.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

                    // below line is for setting
                    // scroll time animation
                    sliderView3.setScrollTimeInSec(3);

                    // below line is for setting auto
                    // cycle animation to our slider
                    sliderView3.setAutoCycle(true);

                    // below line is use to start
                    // the animation of our slider view.
                    sliderView3.startAutoCycle();

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // if we get any error from Firebase we are
                // displaying a toast message for failure
                Toast.makeText(TourActivity.this, "Fail to load slider data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


