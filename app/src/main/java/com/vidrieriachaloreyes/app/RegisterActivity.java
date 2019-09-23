package com.vidrieriachaloreyes.app;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rengwuxian.materialedittext.MaterialEditText;

public class RegisterActivity extends AppCompatActivity {
    public static final String TAG = RegisterActivity.class.getSimpleName();
    MaterialEditText dni, name, email, password;
    private FirebaseAuth mAuth;
    private Animation animation;
    private Vibrator vib;

    private Button btn_registar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //
        dni = findViewById(R.id.et_dni_r);
        name = findViewById(R.id.et_fullName_r);
        email = findViewById(R.id.et_mail_r);
        password = findViewById(R.id.et_password_r);
        //
        btn_registar = findViewById(R.id.btn_registar);



        //
        btn_registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (verificarRegister()){
                    Log.e(TAG,email.getText().toString());
                    Log.e(TAG,password.getText().toString());
                    mAuth
                            .createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(RegisterActivity.this, "usuario creado", Toast.LENGTH_SHORT).show();
                                    goToLogin();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.e(TAG,e.getMessage());
                                    Toast.makeText(RegisterActivity.this, "Error al crear usuario", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });


    }



    public void btn_Registar(View view) {

        //-----------------------------------------
        // Register Activity




    }

    public void btn_Regresar(View view) {
        goToLogin();

    }

    private void goToLogin() {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }


    //

    private boolean verificarRegister() {
        Log.e(TAG, " verficarLogin");
        if (!checkDNI()) {
            dni.setAnimation(animation);
            dni.startAnimation(animation);
            vib.vibrate(120);
            return false;
        }
        if (!checkNAME()) {
            name.setAnimation(animation);
            name.startAnimation(animation);
            vib.vibrate(120);
            return false;
        }
        if (!checkEMAIL()) {
            email.setAnimation(animation);
            email.startAnimation(animation);
            vib.vibrate(120);
            return false;
        }
        if (!checkPWD()) {
            password.setAnimation(animation);
            password.startAnimation(animation);
            vib.vibrate(120);
            return false;
        }
        return true;
    }

    private boolean checkDNI() {
        if (dni.getText().toString().trim().isEmpty()) {
            dni.setError("Ingrese su dni");
            return false;
        }
        return true;
    }

    private boolean checkNAME() {
        if (name.getText().toString().trim().isEmpty()) {
            name.setError("Ingrese su nombre");
            return false;
        }
        return true;
    }

    private boolean checkEMAIL() {
        if (email.getText().toString().trim().isEmpty()) {
            email.setError("Ingrese su correo");
            return false;
        }
        return true;
    }

    private boolean checkPWD() {
        if (password.getText().toString().trim().isEmpty()) {
            password.setError("Ingrese su contraseña");
            return false;
        }
        return true;
    }


}
