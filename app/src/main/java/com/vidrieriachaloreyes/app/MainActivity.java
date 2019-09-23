package com.vidrieriachaloreyes.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vidrieriachaloreyes.app.Fragment.F1;
import com.vidrieriachaloreyes.app.Fragment.F2;
import com.vidrieriachaloreyes.app.Fragment.F3;
import com.vidrieriachaloreyes.app.Fragment.F4;
import com.vidrieriachaloreyes.app.Fragment.F5;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    //
    F1 f1 = new F1();
    F2 f2 = new F2();
    F3 f3 = new F3();
    F4 f4 = new F4();
    F5 f5 = new F5();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_f1);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_f1:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f1).commit();
                return true;
            case R.id.navigation_f2:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f2).commit();
                return true;
            case R.id.navigation_f3:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f3).commit();
                return true;
            case R.id.navigation_f4:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f4).commit();
                return true;
            case R.id.navigation_f5:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f5).commit();
                return true;
        }
        return false;
    }
}
