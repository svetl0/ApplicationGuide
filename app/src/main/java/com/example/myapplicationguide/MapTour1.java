package com.example.myapplicationguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
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

public class MapTour1 extends Fragment {

    MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_tour1, container, false);

        //initialize map
        mapView = (MapView) rootView.findViewById(R.id.mapForTour1);
        mapView.onCreate(savedInstanceState);
        LatLng position1 = new LatLng(48.70844906758717, 44.51521866838516);
        LatLng position2 = new LatLng(48.70622861757305, 44.51841433954959);
        LatLng position3 = new LatLng(48.74225250654351, 44.538078342275);
        LatLng position4 = new LatLng(48.74104403623461, 44.54191927875445);
        LatLng position5 = new LatLng(48.7416835782805, 44.538581269189535);
        LatLng position6 = new LatLng(48.74253563401823, 44.53897959648301);
        LatLng position7 = new LatLng(48.71568328669321, 44.532842697221135);
        LatLng position8 = new LatLng(48.7090310459032, 44.516737781878724);


        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.i("DEBUG", "onMapReady");

                Marker marker  = googleMap.addMarker(new MarkerOptions().position(position1).title("Площадь Павших Борцов"));
                Marker marker2  = googleMap.addMarker(new MarkerOptions().position(position2).title("Аллея Героев"));
                Marker marker3 = googleMap.addMarker(new MarkerOptions().position(position3).title("Мамаев Курган"));
                Marker marker4  = googleMap.addMarker(new MarkerOptions().position(position4).title("Площадь Стоявших Насмерть"));
                Marker marker5  = googleMap.addMarker(new MarkerOptions().position(position5).title("Площадь Скорби"));
                Marker marker6  = googleMap.addMarker(new MarkerOptions().position(position6).title("Зал воинской славы"));
                Marker marker7  = googleMap.addMarker(new MarkerOptions().position(position7).title("Мельница Гергардта"));
                Marker marker8 = googleMap.addMarker(new MarkerOptions().position(position8).title("Музей Память"));


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