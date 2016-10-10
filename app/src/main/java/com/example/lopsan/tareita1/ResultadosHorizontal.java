package com.example.lopsan.tareita1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultadosHorizontal extends Fragment {


    public ResultadosHorizontal() {
        // Required empty public constructor
    }

    TextView nombrer;
    TextView direccionr;
    TextView telefonor;
    TextView correor;
    TextView contrasenar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultados_horizontal, container, false);
        Bundle datos = this.getArguments();
        String nombre = datos.getString("nombre");
        String direccion = datos.getString("direccion");
        String correo = datos.getString("correo");
        String telefono = datos.getString("telefono");
        String contrasena = datos.getString("contrasena");

        nombrer = (TextView) view.findViewById(R.id.edit_name);
        direccionr = (TextView) view.findViewById(R.id.edit_address);
        correor = (TextView) view.findViewById(R.id.edit_email);
        telefonor = (TextView) view.findViewById(R.id.edit_phone);
        contrasenar = (TextView) view.findViewById(R.id.edit_password);


        nombrer.setText("Este es tu nombre: " +nombre);
        direccionr.setText("Esta es su dirección: "+direccion);
        correor.setText("Este es su correo electronico: "+correo);
        telefonor.setText("Este es su telefono: "+telefono);
        contrasenar.setText("Esta es su contraseña: "+contrasena);

        return view;
        //text.append("tu edad es: " + nombre);

    }



}
