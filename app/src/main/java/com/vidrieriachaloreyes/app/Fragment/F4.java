package com.vidrieriachaloreyes.app.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vidrieriachaloreyes.app.R;

import org.w3c.dom.Text;


public class F4 extends Fragment implements OnMapReadyCallback {


    private GoogleMap mMap;
    SupportMapFragment mapFragment;

    TextView tv_contancto_tel;
    TextView tv_contancto_gmail;



    public F4() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f4, container, false);
        tv_contancto_tel = view.findViewById(R.id.tv_contancto_tel);
        tv_contancto_gmail = view.findViewById(R.id.tv_contanto_gmail);



        tv_contancto_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:996537435"));
                startActivity(intent);
            }
        });


        tv_contancto_gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] recipients = {"juancarlos@vidrieriachaloreyes.com"};//Add multiple recipients here
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Presupuesto "); //Add Mail Subject
                intent.putExtra(Intent.EXTRA_TEXT, "Buenas , quisiera un presupuesto ...");//Add mail body
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");//Added Gmail Package to forcefully open Gmail App
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapFragment = (SupportMapFragment) getChildFragmentManager()  .findFragmentById(R.id.mapContacto);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        mMap.setTrafficEnabled(false);
        mMap.setIndoorEnabled(false);
        mMap.setBuildingsEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng arsi = new LatLng(-12.102684, -76.946141);
        mMap.addMarker(new MarkerOptions().position(arsi).title("Vidriería Chalo Reyes  E.I.R.L."));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arsi, 14.5f));

    }
}
