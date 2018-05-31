package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MyProfile  extends Activity {
    TextView description, email, name;
    ImageView photo;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        name = (TextView) findViewById(R.id.name);

        photo = (ImageView) findViewById(R.id.photo);

        description = (TextView) findViewById(R.id.description);

        email = (TextView) findViewById(R.id.email);
        
        edit = (Button) findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MyProfile.this, EditProfile.class);
                startActivity(intent);


            }
        });
    }


}
