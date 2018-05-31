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
        face = findViewById(R.id.face);

        description = findViewById(R.id.description);

        email = findViewById(R.id.email);

        username = findViewById(R.id.username);

        btnEditUser = findViewById(R.id.btnEditUser);

        btnEditDes = findViewById(R.id.btnEditDes);

        btnEditEmail = findViewById(R.id.btnEditEmail);

        btnEditPhoto = findViewById(R.id.btnEditPhoto);
    }

}
