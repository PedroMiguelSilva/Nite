package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MyProfile  extends Activity {
    TextView description, email, name;
    ImageView photo;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        name = findViewById(R.id.name);

        photo = findViewById(R.id.photo);

        description = findViewById(R.id.description);

        email = findViewById(R.id.email);
        
        edit = findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MyProfile.this, EditProfile.class);
                startActivity(intent);


            }
        });
    }


}
