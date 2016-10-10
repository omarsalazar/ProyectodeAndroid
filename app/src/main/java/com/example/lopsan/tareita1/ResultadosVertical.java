package com.example.lopsan.tareita1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ResultadosVertical extends Fragment {

    public ResultadosVertical() {
        // Required empty public constructor
    }

    TextView nombrer;
    TextView direccionr;
    TextView telefonor;
    TextView correor;
    TextView contrasenar;
    TextView usuario_elegido;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultados_vertical, container, false);
        Bundle datos = this.getArguments();
        String nombre = datos.getString("nombre");
        String direccion = datos.getString("direccion");
        String correo = datos.getString("correo");
        String telefono = datos.getString("telefono");
        String contrasena = datos.getString("contrasena");
        String usuario = datos.getString("spinner");


        nombrer = (TextView) view.findViewById(R.id.edit_name);
        direccionr = (TextView) view.findViewById(R.id.edit_address);
        correor = (TextView) view.findViewById(R.id.edit_email);
        telefonor = (TextView) view.findViewById(R.id.edit_phone);
        contrasenar = (TextView) view.findViewById(R.id.edit_password);
        usuario_elegido = (TextView) view.findViewById(R.id.usuario_tipo);


        nombrer.setText("Este es tu nombre: " +nombre);
        direccionr.setText("Esta es su dirección: "+direccion);
        correor.setText("Este es su correo electronico: "+correo);
        telefonor.setText("Este es su telefono: "+telefono);
        contrasenar.setText("Esta es su contraseña: "+contrasena);
        usuario_elegido.setText(usuario);


        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

        //getActivity().getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.id_option1:
                lanzarMenuOption1();
                break;
            case R.id.id_option2:
                lanzarMenuOption2();
                break;
            case R.id.id_option3:
                lanzarMenuOption3();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
    protected void lanzarMenuOption1() {
        Intent intento;
        intento = new Intent(ResultadosVertical.this.getActivity(), Main3Activity.class);
        this.startActivity(intento);
    }

    protected void lanzarMenuOption2() {
        Intent intento;
        intento = new Intent(ResultadosVertical.this.getActivity(), Main4Activity.class);
        this.startActivity(intento);
    }
    protected void lanzarMenuOption3() {
        Intent intento;
        intento = new Intent(ResultadosVertical.this.getActivity(), Main5Activity.class);
        this.startActivity(intento);
    }


}
