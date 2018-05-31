package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends Activity {
    Button btnExit, btnHelp, btnDelete, btnEditProfile, btnPrivacy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnDelete =  (Button) findViewById(R.id.btnDelete);
        btnExit =  (Button) findViewById(R.id.btnExit);
        btnHelp =  (Button) findViewById(R.id.btnHelp);
        btnEditProfile =  (Button) findViewById(R.id.btnEditProfile);
        btnPrivacy =  (Button) findViewById(R.id.btnPrivacy);


        //Mudar este
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Home.class);
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
