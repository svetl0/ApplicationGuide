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


public class MapTour3 extends Fragment {

    MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_tour3, container, false);

        //initialize map
        mapView = (MapView) rootView.findViewById(R.id.mapForTour3);
        mapView.onCreate(savedInstanceState);
        LatLng position1 = new LatLng(48.71507761239745, 44.53293150509639);
        LatLng position2 = new LatLng(48.70897440763924, 44.516780697220696);
        LatLng position3 = new LatLng(48.52001150058183, 44.511176179772285);
        LatLng position4 = new LatLng(48.704503862462964, 44.51180671256251);
        LatLng position5 = new LatLng(48.704564083984096, 44.5086260511946);
        LatLng position6 = new LatLng(48.71219569683192, 44.5235605501199);
        LatLng position7 = new LatLng(48.71449226303943, 44.52446382790494);



        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.i("DEBUG", "onMapReady");

                Marker marker  = googleMap.addMarker(new MarkerOptions().position(position1).title("Музей-панорама Сталинградская битва"));
                Marker marker2  = googleMap.addMarker(new MarkerOptions().position(position2).title("Память"));
                Marker marker3 = googleMap.addMarker(new MarkerOptions().position(position3).title("Сарепта"));
                Marker marker4  = googleMap.addMarker(new MarkerOptions().position(position4).title("Краеведческий Музей"));
                Marker marker5  = googleMap.addMarker(new MarkerOptions().position(position5).title("Музей занимательных наук Эйнштейна"));
                Marker marker6  = googleMap.addMarker(new MarkerOptions().position(position6).title("Волгоградский музей изобразительных искусств им. И.И. Машкова"));
                Marker marker7  = googleMap.addMarker(new MarkerOptions().position(position7).title("Волгоградский планетарий"));


                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position1, 15);
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