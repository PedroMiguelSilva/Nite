package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EditProfile extends Activity {
    Button btnEditDes, btnEditPhoto, btnEditEmail, btnEditUser;
    TextView email, description, username;
    ImageView face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.   activity_edit_profile);
        face = (ImageView) findViewById(R.id.face);

        description = (TextView) findViewById(R.id.description);

        email = (TextView) findViewById(R.id.email);

        username = (TextView) findViewById(R.id.username);

        btnEditUser = (Button) findViewById(R.id.btnEditUser);

        btnEditDes = (Button) findViewById(R.id.btnEditDes);

        btnEditEmail = (Button) findViewById(R.id.btnEditEmail);

        btnEditPhoto = (Button) findViewById(R.id.btnEditPhoto);
    }

}
