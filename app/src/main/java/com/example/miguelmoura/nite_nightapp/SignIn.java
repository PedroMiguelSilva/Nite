package com.example.miguelmoura.nite_nightapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miguelmoura.nite_nightapp.Model.User;
import com.example.miguelmoura.nite_nightapp.Session.Session;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SignIn extends Activity {
    EditText userName, password;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userName = (EditText) findViewById(R.id.email1);
        password = (EditText) findViewById(R.id.password);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
            mDialog.setMessage("Please wait");
            mDialog.show();

            table_user.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(userName.getText().toString()).exists()){
                        mDialog.dismiss();
                        User user = dataSnapshot.child(userName.getText().toString()).getValue(User.class);

                        if(user.getPassword().equals(password.getText().toString())){
                            Toast.makeText(SignIn.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(SignIn.this,Home.class);
                            Session.currentUser = user;
                            startActivity(homeIntent);
                            finish();
                        }
                        else {
                            Toast.makeText(SignIn.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        mDialog.dismiss();
                        Toast.makeText(SignIn.this, "User not exist", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    mDialog.dismiss();
                    Toast.makeText(SignIn.this, "Canceled", Toast.LENGTH_SHORT).show();
                }
            });
            mDialog.dismiss();
        }
    });
    }
}
