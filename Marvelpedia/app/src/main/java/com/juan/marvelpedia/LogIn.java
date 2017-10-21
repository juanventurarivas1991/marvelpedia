package com.juan.marvelpedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


//Clase  la cual permite entrar en la aplicacion

public class LogIn extends AppCompatActivity {
    private TextInputLayout LogInWrapper;
    private TextInputLayout passwordWrapper;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LogInWrapper = (TextInputLayout) findViewById(R.id.inputTextLayoutLoGin);
        LogInWrapper.setHint("LogIn");
        LogInWrapper.getEditText().setText("MasterUsal");


        passwordWrapper = (TextInputLayout) findViewById(R.id.inputTextLayoutPassword);
        passwordWrapper.setHint("Password");
        passwordWrapper.getEditText().setText("USAL2017");


        LogInWrapper.setErrorEnabled(false);
        passwordWrapper.setErrorEnabled(false);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String login = LogInWrapper.getEditText().getText().toString();
                String password = passwordWrapper.getEditText().getText().toString();

                if (!login.equals("MasterUsal")) {
                    LogInWrapper.setError("No es correcto");
                    LogInWrapper.setErrorEnabled(true);
                } else {
                    LogInWrapper.setErrorEnabled(false);
                }


                if (!password.equals("USAL2017")) {

                    passwordWrapper.setError("No es correcto");
                    passwordWrapper.setErrorEnabled(true);
                } else {

                    passwordWrapper.setErrorEnabled(false);
                }


                if (login.equals("MasterUsal") && password.equals("USAL2017")) {


                    startActivity(new Intent(LogIn.this, CharactersComics.class));
                }


            }
        });


    }
}
