package com.example.myapplicationguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataDetails extends AppCompatActivity {
    private RecyclerView courseRV;
    private ArrayList<Places> placeArrayList;
    private DataAdapter dataAdapter;
    private FirebaseFirestore db;
    ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_details);

        courseRV = findViewById(R.id.idRVdata);


        db = FirebaseFirestore.getInstance();


        FloatingActionButton toIn = findViewById(R.id.backtoinfo);
        toIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DataDetails.this, InfoActivity.class);
                startActivity(i);
            }
        });


        placeArrayList = new ArrayList<>();
        courseRV.setHasFixedSize(true);
        courseRV.setLayoutManager(new LinearLayoutManager(this));

        dataAdapter = new DataAdapter(placeArrayList, this);


        courseRV.setAdapter(dataAdapter);
        FloatingActionButton fb = findViewById(R.id.toFeedback);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataDetails.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });

        db.collection("Places")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.e("AAA", document.getId() + " => " + document.getData());
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