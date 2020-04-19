package com.gazeboindustries.appsistemapizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void StartRequest1(View view){
        Intent intent = new Intent(getApplicationContext(), Request.class);
        startActivity(intent);
    }

    public void StartRequest2(View view){
        Intent intent = new Intent(getApplicationContext(), Request2.class);
        startActivity(intent);
    }
}
