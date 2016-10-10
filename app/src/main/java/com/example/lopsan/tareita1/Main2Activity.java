package com.example.lopsan.tareita1;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    Bundle recibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recibe = getIntent().getExtras();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Configuration confi = getResources().getConfiguration();
        if(confi.orientation == Configuration.ORIENTATION_PORTRAIT){
            ResultadosVertical verti = new ResultadosVertical();
            verti.setArguments(recibe);
            ft.replace(android.R.id.content, verti);
        }
        else{
            ResultadosHorizontal hori = new ResultadosHorizontal();
            hori.setArguments(recibe);
            ft.replace(android.R.id.content, hori);
        }
        ft.commit();


    }
}
