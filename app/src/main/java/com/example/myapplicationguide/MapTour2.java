package com.example.myapplicationguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapTour2 extends Fragment {

    MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_tour2, container, false);

        //initialize map
        mapView = (MapView) rootView.findViewById(R.id.mapForTour2);
        mapView.onCreate(savedInstanceState);
        LatLng position = new LatLng(37.77493, -122.41942);
        String markerText = "San Fransisco";
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.i("DEBUG", "onMapReady");
                Marker marker  = googleMap.addMarker(new MarkerOptions().position(position).title(markerText));

                //zoom to position with level 16
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, 16);
                googleMap.animateCamera(cameraUpdate);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}