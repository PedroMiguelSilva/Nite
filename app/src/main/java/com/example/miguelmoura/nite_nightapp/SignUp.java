package com.example.miguelmoura.nite_nightapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miguelmoura.nite_nightapp.Model.User;
import com.example.miguelmoura.nite_nightapp.Session.Session;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

    public class SignUp extends Activity {
        EditText email, userName, password, phoneNumber, birthYear;
        Button btnSignUp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            /* Initialize the Fields */
            userName    = findViewById(R.id.name1);
            email       = findViewById(R.id.email1);
            password    = findViewById(R.id.password);
            phoneNumber = findViewById(R.id.telemovel);
            birthYear   = findViewById(R.id.age);
            btnSignUp   = findViewById(R.id.btnSignUp);

            /* Start connection with data base */
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference table_user = database.getReference("User");

            /* Button functionality */
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /* Waiting message */
                    final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                    mDialog.setMessage("Please wait");
                    mDialog.show();

                    /* Comunication with the data base */
                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            /* Already exists a user */
                            if(dataSnapshot.child(userName.getText().toString()).exists()){
                                mDialog.dismiss();
                            }
                            else {
                                mDialog.dismiss();
                                User user = new User(userName.getText().toString(), email.getText().toString(), phoneNumber.getText().toString(), birthYear.getText().toString(), password.getText().toString());
                                table_user.child(userName.getText().toString()).setValue(user);
                                Toast.makeText(SignUp.this,"login successful", Toast.LENGTH_SHORT).show();
                                Intent homeIntent = new Intent(SignUp.this,Home.class);
                                Session.currentUser = user;
                                startActivity(homeIntent);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            mDialog.dismiss();
                            Toast.makeText(SignUp.this, "Canceled", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }
    }

