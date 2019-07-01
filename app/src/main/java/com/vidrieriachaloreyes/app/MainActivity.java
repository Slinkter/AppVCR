package com.vidrieriachaloreyes.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

    }


    @Override
    protected void onStart() {
        super.onStart();
        if (mUser != null) {
            Log.e("OnStart",mUser.getEmail());
        } else {
            Log.e("OnStart", "usuario null ");
            goToLogin();
        }
    }

    private void goToLogin() {
        Intent goLogin = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(goLogin);
        finish();
    }
}
