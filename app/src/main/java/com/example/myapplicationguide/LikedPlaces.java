package com.example.myapplicationguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class LikedPlaces extends AppCompatActivity {
    private RecyclerView courseRV;
    private ArrayList<Places> placeArrayList;
    private AdapterForLikedActivvity dataAdapter;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_places);

        courseRV = findViewById(R.id.ListForLIkedPlaces);

        FloatingActionButton toF = findViewById(R.id.tofeedback2);
        toF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LikedPlaces.this, FeedbackActivity.class);
                startActivity(i);
            }
        });

        FloatingActionButton toInfo = findViewById(R.id.backtoinfo2);
        toInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LikedPlaces.this, InfoActivity.class);
                startActivity(i);
            }
        });





        db = FirebaseFirestore.getInstance();
        placeArrayList = new ArrayList<>();
        courseRV.setHasFixedSize(true);
        courseRV.setLayoutManager(new LinearLayoutManager(this));
        dataAdapter = new AdapterForLikedActivvity(placeArrayList, this);

        courseRV.setAdapter(dataAdapter);
        String ID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);


        db.collection(ID)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.e("AAAAAA", document.getId() + " => " + document.getData());
                                Places p = document.toObject(Places.class);


                                placeArrayList.add(p);
                            }
                            dataAdapter.notifyDataSetChanged();
                        } else {
                            Log.w("a", "Error getting documents.", task.getException());
                        }
                    }
                });
    }



}