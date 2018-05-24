package com.example.miguelmoura.nite_nightapp;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends Activity {
    EditText email, password;
    Button btnSignIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = (EditText) findViewById(R.id.email1);

        password = (EditText) findViewById(R.id.password);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);


        //Base de dados : ->
        //->

    //aqui tens de criar o listener para o botão, criar uma classe user, instanciar e verificar se o login é bem sucedido ou não.
        //podes fazer um toast tambem para mostrar se o login é bem feito ou não

    btnSignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context context = getApplicationContext();
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }
    });
    }

}
