package com.example.lopsan.tareita1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.support.v7.widget.AppCompatButton;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Arrays;


public class horizontalFragment extends Fragment implements OnItemSelectedListener{

    EditText nombre;
    EditText direccion;
    EditText telefono;
    EditText correo;
    EditText contrasena;
    EditText contrasena2;
    Button clear;
    Button enviar;

    Spinner spinner;
    String[] users;
    String usuariopSelecctionado;

    public horizontalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_horizontal, container, false);
        nombre = (EditText) view.findViewById(R.id.edit_name);
        direccion = (EditText) view.findViewById(R.id.edit_address);
        telefono = (EditText) view.findViewById(R.id.edit_phone);
        correo = (EditText) view.findViewById(R.id.edit_email);
        contrasena = (EditText) view.findViewById(R.id.edit_password);
        contrasena2 = (EditText) view.findViewById(R.id.edit_confirm);
        clear = (Button) view.findViewById(R.id.no_se);
        enviar = (Button) view.findViewById(R.id.button);
        spinner = (Spinner) view.findViewById(R.id.spinner);

        //selected = (TextView)view.findViewById(R.id.selected);


        users = getResources().getStringArray(R.array.user);

        ArrayAdapter<CharSequence> adapter;

        adapter = new ArrayAdapter<CharSequence>(horizontalFragment.this.getActivity(), android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        clear.setOnClickListener(new OnClickListener() {
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        usuariopSelecctionado = parent.getItemAtPosition(position).toString();
        //String user;
        //user = (String) parent.getItemAtPosition(position);
        //selected.setText(
        //      this.getResources().getString(R.string.selected) + " " + usu
        //);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }



    protected void lanzarActividad(String name, String adres, String phone, String email, String pass) {
        Intent intent;
        intent  = new Intent(horizontalFragment.this.getActivity(), Main2Activity.class);
        intent.putExtra("nombre", name);
        intent.putExtra("direccion", adres);
        intent.putExtra("telefono", phone);
        intent.putExtra("correo", email);
        intent.putExtra("contrasena", pass);
        intent.putExtra("spinner", this.usuariopSelecctionado);

        this.startActivity(intent);
    }

    protected void lanzarMenuOption1() {
        Intent intento;
        intento = new Intent(horizontalFragment.this.getActivity(), Main3Activity.class);
        this.startActivity(intento);
    }

    protected void lanzarMenuOption2() {
        Intent intento;
        intento = new Intent(horizontalFragment.this.getActivity(), Main4Activity.class);
        this.startActivity(intento);
    }
    protected void lanzarMenuOption3() {
        Intent intento;
        intento = new Intent(horizontalFragment.this.getActivity(), Main5Activity.class);
        this.startActivity(intento);
    }



}
