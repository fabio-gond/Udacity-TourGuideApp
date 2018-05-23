package com.example.fabio.tourguideapp;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Fragment containing the google map
 *
 * @link https://developers.google.com/maps/documentation/android-sdk/start
 */
public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String TAG = MapActivity.class.getSimpleName();
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
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

        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");

        // Add a marker and move the camera
        LatLng coordinates = addressToCoordinates(address);
        mMap.addMarker(new MarkerOptions().position(coordinates).title(name));

        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates));
    }

    /**
     * Convert an address in coordinates
     * address example: “48 Pirrama Rd, Pyrmont, NSW, Australia”
     */
    private LatLng addressToCoordinates(String address) {
        LatLng coordinates = new LatLng(0, 0);
        Geocoder geocoder = new Geocoder(this);
        List<Address> addresses = new ArrayList<>();
        try {
            addresses = geocoder.getFromLocationName(address, 1);
        } catch (Exception ex) {
            Log.e(TAG, "addressToCoordinates:  ", ex);
        }

        if (addresses.size() > 0) {
            coordinates = new LatLng(addresses.get(0).getLatitude(), addresses.get(0).getLongitude());
        }

        return coordinates;
    }
}
