package com.vidrieriachaloreyes.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vidrieriachaloreyes.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class F5 extends Fragment {

    Button btn_Cliente_Ingresar;
    TextView campo1,campo2;

    public F5() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,      Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_f5, container, false);

        campo1 = view.findViewById(R.id.et_mail_f5);
        campo2 = view.findViewById(R.id.et_password_f5);

        btn_Cliente_Ingresar = view.findViewById(R.id.btn_Cliente_Ingresar);
        btn_Cliente_Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (campo1.getText().toString().isEmpty() & campo2.getText().toString().isEmpty()){
                    Toast.makeText(view.getContext(), "Usuario y contraeña incorrecto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(view.getContext(), "Usuario no autorizado", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

}
