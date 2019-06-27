package com.vidrieriachaloreyes.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    //
    private Button btnIngresar;
    private Button btnRegistrar;
    //
    private Animation animation;
    private Vibrator vib;
    private FirebaseAuth auth;
    //
    private EditText ed_login_email;
    private EditText ed_login_pwd;
    private CheckBox checkbox_session;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String PREF_NAME = "prefs";
    public static final String KEY_REMEMBER = "remeber";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        //
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //
        ed_login_email = findViewById(R.id.et_mail);
        ed_login_pwd = findViewById(R.id.et_password);
        checkbox_session = findViewById(R.id.checkbox_session);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent ac_registro = new Intent()
            }
        });



    }

    // metodo de guardar usuario y contraseña


}
