package com.my.elyo.quienseune;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class GuardarUbicacion extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap m;
    LocationManager locationManager;
    Location l;
    boolean gps;
    private  Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_ubicacion);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("Seleccionar lugar");
        ab.setIcon(R.mipmap.ic_map_blue);
        c=this;
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa1);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        gps = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);

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
            if (gps) {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                //locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 5000, 10f, (LocationListener) this);
                locationManager = (LocationManager) this.c.getSystemService(LOCATION_SERVICE);
                if (locationManager != null) {
                    l = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                    if (l != null) {
                        m.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(l.getLatitude(), l.getLongitude()), 15));
                        A.S3 = String.valueOf(l.getLatitude());
                        A.S4 = String.valueOf(l.getLongitude());
                    }
                }
            }
        }
        catch(Exception ex){
            //Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
    public void guardarub(View view)
    {
        LatLng la =m.getCameraPosition().target;
        A.S3= String.valueOf(la.latitude);
        A.S4= String.valueOf(la.longitude);
        finish();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
