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
        LatLng position1 = new LatLng(48.709761043232966, 44.510053639549795);
        LatLng position2 = new LatLng(48.70878643250946, 44.510809970206246);
        LatLng position3 = new LatLng(48.70850275147994, 44.51308444325477);
        LatLng position4 = new LatLng(48.70963854229059, 44.51364311256276);
        LatLng position5 = new LatLng(48.70839146783023, 44.51343825489168);
        LatLng position6 = new LatLng(48.708628308515785, 44.51488281071424);
        LatLng position7 = new LatLng(48.70554819260605, 44.518519212179385);



        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.i("DEBUG", "onMapReady");

                Marker marker  = googleMap.addMarker(new MarkerOptions().position(position1).title("Каланча Царицынской Пожарной Команды"));
                Marker marker2  = googleMap.addMarker(new MarkerOptions().position(position2).title("Комсомольский Сквер"));
                Marker marker3 = googleMap.addMarker(new MarkerOptions().position(position3).title("Новый экспериментальный театр"));
                Marker marker4  = googleMap.addMarker(new MarkerOptions().position(position4).title("Александро-Невский собор"));
                Marker marker5  = googleMap.addMarker(new MarkerOptions().position(position5).title("Памятник Александру Невскому"));
                Marker marker6  = googleMap.addMarker(new MarkerOptions().position(position6).title("Нулевой Километр"));
                Marker marker7  = googleMap.addMarker(new MarkerOptions().position(position7).title("Парк Победы"));



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