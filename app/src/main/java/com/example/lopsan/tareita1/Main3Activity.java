package com.example.lopsan.tareita1;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    Bundle recibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recibe = getIntent().getExtras();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Configuration confi = getResources().getConfiguration();
        if(confi.orientation == Configuration.ORIENTATION_PORTRAIT){
            Opcion1Fragment verti = new Opcion1Fragment();
            verti.setArguments(recibe);
            ft.replace(android.R.id.content, verti);
        }
        else{
            Opcion1FragmentHorizontal hori = new Opcion1FragmentHorizontal();
            hori.setArguments(recibe);
            ft.replace(android.R.id.content, hori);
        }
        ft.commit();

    }
}
