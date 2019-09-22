package com.vidrieriachaloreyes.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        init();

    }

    private void init() {

    }

    public void btn_Registar(View view) {
    }

    public void btn_Regresar(View view) {
        goToLogin();

    }

    private void goToLogin() {
        Intent i = new Intent(RegisterActivity.this ,LoginActivity.class);
        startActivity(i);
        finish();
    }


}
