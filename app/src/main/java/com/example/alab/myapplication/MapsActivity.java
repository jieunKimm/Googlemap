package com.example.alab.myapplication;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.widget.Toast;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationSource.OnLocationChangedListener mapLocationListener=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        setUpMap();


    }

        private void setUpMapIfNeeded() {
            if(mMap==null){
                mMap =((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map))
                        .getMap();
                if(mMap != null){
                    setUpMap();
                }
            }
        }

    private void setUpMap(){


        mMap.addMarker(new MarkerOptions().position(new LatLng(22.338826, 114.172819)).title("ME").snippet("Consider yourself located").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_blue)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(22.337844, 114.173956)).title("Festival Grand Cinema").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_red)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.310790, 114.169184)).title("Broadway CinemathequeE").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_red)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.320481, 114.167676)).title("Dynasty Theatre").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_red)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.304078, 114.163091)).title("The Grand").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_red)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.296995, 114.171791)).title("UA iSQUARE").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_red)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.299298, 114.172849)).title("The One Broadway Theatre").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_red)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.295068, 114.168998)).title("Golden Harvest Grand Ocean Cinema").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker_red)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(22.338826, 114.172819), 12));

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        } else {

        }
    }


}
