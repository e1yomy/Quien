package com.my.elyo.quienseune;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;


public class VerUbicacion extends AppCompatActivity implements OnMapReadyCallback, LocationListener, Runnable {
    GoogleMap m;
    LocationManager locationManager;
    Location l;
    boolean gps;
    public Context c;
    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ubicacion);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Ubicacion del evento");
        ab.setIcon(R.mipmap.ic_map_blue);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa2);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        gps = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);
        c = this;
        t = new Thread();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            m = googleMap;
            m.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            m.getUiSettings().setZoomControlsEnabled(true);
            m.getUiSettings().setCompassEnabled(true);
            m.getUiSettings().setAllGesturesEnabled(true);
            m.getUiSettings().setScrollGesturesEnabled(true);
            m.getUiSettings().setZoomGesturesEnabled(true);
            if (ActivityCompat.checkSelfPermission(c, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(c, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            if (gps) {
                locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 5000, 10f, this);
                locationManager = (LocationManager) c.getSystemService(LOCATION_SERVICE);
                if (locationManager != null) {

                    l = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                    if (l != null) {
                        m.clear();
                        m.addMarker(new MarkerOptions().position(new LatLng(l.getLatitude(), l.getLongitude())).title("Tú").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_map_red)));
                        m.addMarker(new MarkerOptions().position(new LatLng(Double.valueOf(A.S3), Double.valueOf(A.S4))).title("Evento").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_map_blue)));
                        LatLngBounds.Builder builder = new LatLngBounds.Builder();
                        builder.include(new LatLng(l.getLatitude(),l.getLongitude()));
                        builder.include(new LatLng(Double.valueOf(A.S3),Double.valueOf(A.S4)));
                        LatLngBounds bounds = builder.build();
                        int width = getResources().getDisplayMetrics().widthPixels;
                        int height = getResources().getDisplayMetrics().heightPixels;
                        int padding = (int) (width * 0.10);
                        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
                        m.animateCamera(cu);
                    }
                }
            }

        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onLocationChanged(Location location) {
        l=location;
        m.clear();
        m.addMarker(new MarkerOptions().position(new LatLng(l.getLatitude(), l.getLongitude())).title("Tú").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_map_red)));
        m.addMarker(new MarkerOptions().position(new LatLng(Double.valueOf(A.S3), Double.valueOf(A.S4))).title("Evento").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_map_blue)));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(new LatLng(l.getLatitude(),l.getLongitude()));
        builder.include(new LatLng(Double.valueOf(A.S3),Double.valueOf(A.S4)));
        LatLngBounds bounds = builder.build();
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (width * 0.10);
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
        m.animateCamera(cu);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void run() {
        while (true) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
////////////////////////////////

                        /////////////////////////
                    }
                    catch (Exception ex){}
                }
            });

            try {
                Thread.sleep(2*1000);

            } catch (Exception e) {

            }
        }
    }
}
