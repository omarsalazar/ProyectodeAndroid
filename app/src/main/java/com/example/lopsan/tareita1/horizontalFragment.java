package com.example.lopsan.tareita1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;



public class horizontalFragment extends Fragment {

    public horizontalFragment() {
        // Required empty public constructor
    }

    EditText nombre;
    EditText direccion;
    EditText telefono;
    EditText correo;
    EditText contrasena;
    EditText contrasena2;
    Button clear;
    Button enviar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_horizontal, container, false);
        nombre = (EditText) view.findViewById(R.id.edit_name);
        direccion = (EditText) view.findViewById(R.id.edit_address);
        telefono = (EditText) view.findViewById(R.id.edit_phone);
        correo = (EditText) view.findViewById(R.id.edit_email);
        contrasena = (EditText) view.findViewById(R.id.edit_password);
        contrasena2 = (EditText) view.findViewById(R.id.edit_confirm);
        clear = (Button) view.findViewById(R.id.no_se);
        enviar = (Button) view.findViewById(R.id.button);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
                direccion.setText("");
                telefono.setText("");
                correo.setText("");
                contrasena.setText("");
                contrasena2.setText("");
            }
        });

        enviar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nombre.getText().toString();
                String d = direccion.getText().toString();
                String t = telefono.getText().toString();
                String e = correo.getText().toString();
                String c = contrasena.getText().toString();
                lanzarActividad(n,d,t,e,c);

            }
        });

        return view;

    }
    protected void lanzarActividad(String name, String adres, String phone, String email, String pass) {
        Intent intent;
        intent  = new Intent(horizontalFragment.this.getActivity(), Main2Activity.class);
        intent.putExtra("nombre", name);
        intent.putExtra("direccion", adres);
        intent.putExtra("telefono", phone);
        intent.putExtra("correo", email);
        intent.putExtra("contrasena", pass);
        this.startActivity(intent);
    }
}
