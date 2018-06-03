package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miguelmoura.nite_nightapp.Session.Session;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Settings extends Activity {
    Button btnExit, btnHelp, btnDelete, btnEditProfile, btnPrivacy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnDelete = findViewById(R.id.btnDelete);
        btnExit =  findViewById(R.id.btnExit);
        btnHelp = findViewById(R.id.btnHelp);
        btnEditProfile =  findViewById(R.id.btnEditProfile);
        btnPrivacy =  findViewById(R.id.btnPrivacy);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference user = firebaseDatabase.getReference("User");
                DatabaseReference email = firebaseDatabase.getReference("Email");

                Session.currentUser.formatEmail();
                email.child(Session.currentUser.getEmail()).removeValue();
                user.child(Session.currentUser.getUserName()).removeValue();

                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
               /* Intent intent = new Intent(Settings.this, Home.class);
                startActivity(intent);
*/

            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Help.class);
                startActivity(intent);


            }
        });
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, EditProfile.class);
                startActivity(intent);


            }
        });
        btnPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Privacy.class);
                startActivity(intent);


            }
        });



    }
}
