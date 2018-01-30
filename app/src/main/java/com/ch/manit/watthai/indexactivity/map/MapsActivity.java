package com.ch.manit.watthai.indexactivity.map;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ch.manit.watthai.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView latTextView, lngTextView;
    private LocationManager locationManager;
    private Criteria criteria;
    private double latADouble, lngADouble;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        ImageButton back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //Bind Widget
        bindWidget();
        //Setup location
        setUpLocation();

        dialog = new ProgressDialog(MapsActivity.this);
        dialog.show();
        dialog.setMessage("Getting Coordinates");


    } // Main Method


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        locationManager.removeUpdates(locationListener);
        latADouble = 13.716630;
        lngADouble = 100.487487; //พิกัดฝั่งธนบุรี

        //ค้นหาจาก เบอร์ไอพีหรือจากเน็ตเวิค
        Location networkLocation = myFindLocation(LocationManager.NETWORK_PROVIDER);
        if(networkLocation != null){
            latADouble = networkLocation.getLatitude();
            lngADouble = networkLocation.getLongitude();
        }

        //ค้นหาจาก card gps
        Location gpsLocation = myFindLocation(LocationManager.GPS_PROVIDER);
        if(gpsLocation != null){
            latADouble = gpsLocation.getLatitude();
            lngADouble = gpsLocation.getLongitude();
        }
        latTextView.setText(String.format("%.7f", latADouble));
        lngTextView.setText(String.format("%.7f", lngADouble));
    } // Onresume


    @Override
    protected void onStop() {
        super.onStop();

        locationManager.removeUpdates(locationListener);
    }

    public Location myFindLocation(String strProvider) {

        Location location = null;

        if (locationManager.isProviderEnabled(strProvider)) {

            locationManager.requestLocationUpdates(strProvider, 1000, 10, locationListener);

        } else {
            Log.d("3JuneV1", "my Error");
        }


        return location;
    }

    public LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            dialog.show();
            latADouble = location.getLatitude();
            lngADouble = location.getLongitude();
            if (latADouble != 0 && lngADouble != 0) {
                latTextView.setText(String.format("%.7f", latADouble));
                lngTextView.setText(String.format("%.7f", lngADouble));
                dialog.dismiss();
            }
        }//onlocationchang

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void setUpLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
    }

    private void bindWidget() {

        latTextView = (TextView) findViewById(R.id.textView2);
        lngTextView = (TextView) findViewById(R.id.textView4);

    }//Bindwidget


    public void onZoom(View view) {
        if (view.getId() == R.id.Bzoomin) {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if (view.getId() == R.id.Bzoomout) {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    public void changeType(View view) {
        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        } else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.716630, 100.487487),12));

        //create marker
        double douLat = getIntent().getDoubleExtra("Lat", 13.716630);
        double douLng = getIntent().getDoubleExtra("Lng", 100.487487);
        String strTitle = getIntent().getStringExtra("Title");
        String strDetail = getIntent().getStringExtra("Detail");

        LatLng latLng = new LatLng(douLat, douLng);

        mMap.addMarker(new MarkerOptions()
        .position(latLng)
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        .title(strTitle)
        .snippet(strDetail));

    }//setupmap

}//main class

   // icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
   // icon(BitmapDescriptorFactory.fromResource(R.drawable.build1))