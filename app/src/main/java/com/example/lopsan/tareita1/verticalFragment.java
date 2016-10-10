package com.example.lopsan.tareita1;

import android.content.Context;
import android.net.Uri;
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
import java.util.Arrays;


public class verticalFragment extends Fragment implements OnItemSelectedListener{

    EditText nombre;
    EditText direccion;
    EditText telefono;
    EditText correo;
    EditText contrasena;
    EditText contrasena2;
    Button clear;
    Button enviar;

    TextView selected;
    Spinner spinner;
    String[] users;

    public verticalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_vertical, container, false);
        nombre = (EditText) view.findViewById(R.id.edit_name);
        direccion = (EditText) view.findViewById(R.id.edit_address);
        telefono = (EditText) view.findViewById(R.id.edit_phone);
        correo = (EditText) view.findViewById(R.id.edit_email);
        contrasena = (EditText) view.findViewById(R.id.edit_password);
        contrasena2 = (EditText) view.findViewById(R.id.edit_confirm);
        clear = (Button) view.findViewById(R.id.no_se);
        enviar = (Button) view.findViewById(R.id.button);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        selected = (TextView)view.findViewById(R.id.selected);

        users = getResources().getStringArray(R.array.user);

        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(verticalFragment.this.getActivity(), android.R.layout.simple_spinner_item, users);
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
        //MenuInflater inflater = getActivity().getMenuInflater();
        //super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        String user;
        user = (String) parent.getItemAtPosition(position);
        selected.setText(
                this.getResources().getString(R.string.selected) + " " + Arrays.toString(users)
        );

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }



    protected void lanzarActividad(String name, String adres, String phone, String email, String pass) {
        Intent intent;
        intent  = new Intent(verticalFragment.this.getActivity(), Main2Activity.class);
        intent.putExtra("nombre", name);
        intent.putExtra("direccion", adres);
        intent.putExtra("telefono", phone);
        intent.putExtra("correo", email);
        intent.putExtra("contrasena", pass);
        this.startActivity(intent);
    }


}
