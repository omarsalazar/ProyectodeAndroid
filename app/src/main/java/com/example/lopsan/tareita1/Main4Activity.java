package com.example.lopsan.tareita1;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

    Bundle recibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recibe = getIntent().getExtras();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Configuration confi = getResources().getConfiguration();
        if(confi.orientation == Configuration.ORIENTATION_PORTRAIT){
            Opcion2Fragment verti = new Opcion2Fragment();
            verti.setArguments(recibe);
            ft.replace(android.R.id.content, verti);
        }
        else{
            Opcion2FragmentHorizontal hori = new Opcion2FragmentHorizontal();
            hori.setArguments(recibe);
            ft.replace(android.R.id.content, hori);
        }
        ft.commit();

    }
}
