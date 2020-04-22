package com.gazeboindustries.appsistemapizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();

        Button AddressButton = findViewById(R.id.btnAddress);

        SecurityPreferences savedPreferences = new SecurityPreferences(this);

        if (savedPreferences.getStoredString(Constants.ROAD_KEY) != null){
            String road = savedPreferences.getStoredString(Constants.ROAD_KEY);
            String number = savedPreferences.getStoredString(Constants.NUMBER_KEY);
            String neiboard = savedPreferences.getStoredString(Constants.NEIBOARD_KEY);
            String complement = savedPreferences.getStoredString(Constants.COMPLEMENT_KEY);

            AddressButton.setText("Rua: " + road +"\n" +
                    "Número: " + number + "\n" +
                    "Bairro: " + neiboard + "\n" +
                    "Complemento: " + complement + "\n");
        }

    }

    public void StartRequest1(View view){
        Intent intent = new Intent(getApplicationContext(), Request.class);
        startActivity(intent);
    }

    public void StartAddress(View view){
        Intent intent = new Intent(getApplicationContext(), Address.class);
        startActivity(intent);
    }
}
