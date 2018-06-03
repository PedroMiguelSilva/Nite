package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class GPSUpdate extends AppCompatActivity {
    TextView textView;
    Button btnUpdateGps;
    //private Haversine have;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_update);
        btnUpdateGps = (Button) findViewById(R.id.btnUpdate);
        textView = (TextView) findViewById(R.id.currentCity);
        ActivityCompat.requestPermissions(GPSUpdate.this, new String[]{ android.Manifest.permission.ACCESS_FINE_LOCATION}, 123);


        btnUpdateGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                if(l != null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    if(Haversine.distance(lat, lon, Haversine.getPortoLat(), Haversine.getPortoLon()) < 30 )
                        Toast.makeText(getApplicationContext(), "Lat" + lat + "\nLon" + lon +"\nEncontra-se na cidade: Porto", Toast.LENGTH_LONG).show();
                    else Toast.makeText(getApplicationContext(), "Lat" + lat + "\nLon" + lon +"\nDe momento so estamos a operar no Porto. Pedimos desculpa", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}
