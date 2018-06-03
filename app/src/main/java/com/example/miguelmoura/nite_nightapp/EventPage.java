package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EventPage extends Activity {
    TextView description, date, clubNname, horario;
    ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        description = (TextView) findViewById(R.id.description);
        date = (TextView) findViewById(R.id.date);
        horario = (TextView) findViewById(R.id.horario);


    }
}
