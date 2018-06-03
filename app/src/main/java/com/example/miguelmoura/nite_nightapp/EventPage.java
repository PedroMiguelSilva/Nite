package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miguelmoura.nite_nightapp.Model.Event;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class EventPage extends Activity {
    TextView description, date, horario,clubName;
    ImageView image;

    private FirebaseDatabase database;
    private DatabaseReference eventList;

    private String test;

    Event eventChosen;

    private String eventId = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        description = findViewById(R.id.descricao);
        date =  findViewById(R.id.date);
        horario = findViewById(R.id.horario);
        image = findViewById(R.id.imagem);
        clubName = findViewById(R.id.clubName);

        database = FirebaseDatabase.getInstance();
        eventList = database.getReference("Event");

        if(getIntent() != null)
            eventId = getIntent().getStringExtra("eventId");
        if(!eventId.isEmpty()){
            loadEvent(eventId);
        }




    }

    private void loadEvent(final String eventId) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Event").child(eventId);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventChosen = dataSnapshot.getValue(Event.class);//h
                description.setText(eventChosen.getDescription());
                date.setText(eventChosen.getDate());
                horario.setText(eventChosen.getTime());
                Picasso.with(getBaseContext()).load(eventChosen.getImage()).into(image);
                clubName.setText(eventChosen.getContact());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
