package com.example.myapplicationguide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Places> placesArrayList;
    private Context context;
    private ArrayList<Places> likedPlaces;

    // creating constructor for our adapter class
    public DataAdapter(ArrayList<Places> coursesArrayList, Context context) {
        this.placesArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.data_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        // setting data to our text views from our modal class.
        Places place  = placesArrayList.get(position);
        holder.idName.setText(place.getIdName());
        holder.detailsdata.setText(place.getDetailsdata());
        //holder.imgIDview.setImageResource(place.getImgId());
        Picasso.get().load(place.getImg()).into(holder.imgIDview);

        holder.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsActivity.class);
                double[] tmp = {place.getGeoPoint().getLatitude(), place.getGeoPoint().getLongitude()};
                Log.e("HHHHHHHHHHHHHHHHHHHHHHHHH", Double.toString(tmp[0]));
                intent.putExtra("coords", tmp );
                context.startActivity(intent);
            }
        });
        String ID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        FirebaseFirestore dp = FirebaseFirestore.getInstance();

        holder.liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //добавление в бд название и описание места

                String nameOfPlace = place.getIdName();

                dp.collection(ID).document(nameOfPlace).set(place).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Successfully", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(context, MainPlacesActivity.class);
                        context.startActivity(i);
                        notifyDataSetChanged();


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show();
                    }
                });
            }

        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return placesArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView idName;
        private final TextView detailsdata;
        private ImageView imgIDview;
        private FloatingActionButton fab;
        private  FloatingActionButton liked;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            idName = itemView.findViewById(R.id.idNameForLikedActivity);
            detailsdata = itemView.findViewById(R.id.DataDescribtionForLikedActivity);
            imgIDview = itemView.findViewById(R.id.imgIdForLikedActivity);
            fab = itemView.findViewById(R.id.onMapFabForLikedActivity);
            liked = itemView.findViewById(R.id.liked);
        }
    }
}
