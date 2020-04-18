package com.gazeboindustries.appsistemapizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SocketConnection connection = new SocketConnection();

        connection.execute("TESTE CONEXÃO SOCKET");

    }

    public void test(View view){
        SocketConnection connection = new SocketConnection();

        connection.execute("TESTE CONEXÃO SOCKET");
    }
}
