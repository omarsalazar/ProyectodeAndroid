package com.example.lopsan.tareita1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.lopsan.tareita1.horizontalFragment;
import com.example.lopsan.tareita1.verticalFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Configuration confi = getResources().getConfiguration();
        if(confi.orientation == Configuration.ORIENTATION_PORTRAIT){
            ft.replace(android.R.id.content, new verticalFragment());
        }
        else{
            ft.replace(android.R.id.content, new horizontalFragment());
        }
        ft.commit();

    }


}
