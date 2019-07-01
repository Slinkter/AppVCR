package com.vidrieriachaloreyes.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    //
    private Button btnIngresar;
    private Button btnRegistrar;
    //
    private Animation animation;
    private Vibrator vib;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
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
        mAuth = FirebaseAuth.getInstance();
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

                if (verificarLogin()) {
                    String email = ed_login_email.getText().toString();
                    String pass = ed_login_pwd.getText().toString();
                    Log.e("mm", email);
                    Log.e("nn", pass);
                    gotoMainActivity(email, pass);
                }


            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegister);
            }
        });


    }

    private boolean verificarLogin() {
        Log.e("verficarLogin", " Start");
        if (!checkEmail()) {
            ed_login_email.setAnimation(animation);
            ed_login_email.startAnimation(animation);
            vib.vibrate(120);
            return false;
        }
        if (!checkPassword()) {
            ed_login_pwd.setAnimation(animation);
            ed_login_pwd.startAnimation(animation);
            vib.vibrate(120);
            return false;
        }
        return true;
    }

    private boolean checkEmail() {
        if (ed_login_email.getText().toString().trim().isEmpty()) {
            ed_login_email.setError("vacio");
            return false;
        }
        return true;
    }

    private boolean checkPassword() {
        if (ed_login_pwd.getText().toString().trim().isEmpty()) {
            ed_login_pwd.setError("vacio");
            return false;//el campo esta vacio
        }
        return true;
    }


    private void gotoMainActivity(String email, String password) {

        mAuth
                .signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent gotoMain = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(gotoMain);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
