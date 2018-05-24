package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

    public class SignUp extends Activity {
        EditText email1, name1, password, telemovel, age;
        Button btnSignUp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);


            name1 = (EditText)findViewById(R.id.name1);
            email1 = (EditText)findViewById(R.id.email1);
            password = (EditText)findViewById(R.id.password);
            telemovel = (EditText)findViewById(R.id.telemovel);
            age = (EditText)findViewById(R.id.age);

            btnSignUp = (Button) findViewById(R.id.btnSignUp);




        }
    }

