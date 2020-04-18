package com.gazeboindustries.appsistemapizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void test(View view){
        SocketConnection connection = new SocketConnection();

        connection.execute("TESTE CONEXÃO SOCKET");
    }
}
