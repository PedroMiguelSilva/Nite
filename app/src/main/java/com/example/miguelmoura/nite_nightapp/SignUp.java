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

import java.util.concurrent.TimeUnit;

public class SignUp extends Activity {
        private EditText email, userName, password, phoneNumber, birthYear;
        private Button btnSignUp;
        private User user;

        /* Start connection with data base */
        private final String TABLE_USER_NAME    = "User";
        private final String TABLE_EMAIL_NAME   = "Email";

        private FirebaseDatabase database               = FirebaseDatabase.getInstance();
        private final DatabaseReference table_user      = database.getReference(TABLE_USER_NAME);
        private final DatabaseReference table_email = database.getReference(TABLE_EMAIL_NAME);

        private static boolean isEmailUnique = true;

        private void updateEmailUnique(){

            table_email.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(!dataSnapshot.child(user.getEmail()).exists()){
                        isEmailUnique = true;
                    }
                    else
                        isEmailUnique = false;
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    isEmailUnique = false;
                }
            });
        }

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

            /* Button functionality */
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /* Waiting message */
                    final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                    mDialog.setMessage("Please wait");
                    mDialog.show();

                    /* Communication with the data base */
                    table_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            user = new User(userName.getText().toString(), email.getText().toString(), phoneNumber.getText().toString(), birthYear.getText().toString(), password.getText().toString());
                            user.formatEmail();
                            updateEmailUnique();

                            String answer = user.isValid();
                            mDialog.dismiss();
                            if(answer != "validUser"){
                                Toast.makeText(SignUp.this,"Error: Invalid " + answer, Toast.LENGTH_SHORT).show();
                            }
                            else{
                                /* Already exists a user */
                                if(dataSnapshot.child(user.getUserName()).exists()){
                                    Toast.makeText(SignUp.this,"Username already in use", Toast.LENGTH_SHORT).show();
                                }
                                /* Check if email is unique */
                                else if(isEmailUnique){

                                    table_user.child(user.getUserName()).setValue(user);
                                    table_email.child(user.getEmail()).setValue(new User(user.getUserName()));
                                    Intent homeIntent = new Intent(SignUp.this,Home.class);
                                    Session.currentUser = user;
                                    startActivity(homeIntent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(SignUp.this,"Email already in use", Toast.LENGTH_SHORT).show();
                                }
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

