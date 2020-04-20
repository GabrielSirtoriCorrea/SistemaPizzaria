package com.gazeboindustries.appsistemapizzaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Address extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        EditText road = findViewById(R.id.txtAddressRua);
        EditText number = findViewById(R.id.txtAddressNumero);
        EditText neiboard = findViewById(R.id.txtAddressBairro);
        EditText complement = findViewById(R.id.txtAddressComplemento);

        SecurityPreferences savedPreferences = new SecurityPreferences(this);

        if(savedPreferences.getStoredString(Constants.ROAD_KEY) != null){
            road.setText(savedPreferences.getStoredString(Constants.ROAD_KEY));
        }

        if(savedPreferences.getStoredString(Constants.NUMBER_KEY) != null){
            number.setText(savedPreferences.getStoredString(Constants.NUMBER_KEY));
        }

        if(savedPreferences.getStoredString(Constants.NEIBOARD_KEY) != null){
            neiboard.setText(savedPreferences.getStoredString(Constants.NEIBOARD_KEY));
        }

        if(savedPreferences.getStoredString(Constants.COMPLEMENT_KEY) != null){
            complement.setText(savedPreferences.getStoredString(Constants.COMPLEMENT_KEY));
        }

    }

    public void SaveAddress(View view){
        SecurityPreferences savePreferences = new SecurityPreferences(this);

        EditText road = findViewById(R.id.txtAddressRua);
        EditText number = findViewById(R.id.txtAddressNumero);
        EditText neiboard = findViewById(R.id.txtAddressBairro);
        EditText complement = findViewById(R.id.txtAddressComplemento);

        savePreferences.storeString(Constants.ROAD_KEY, road.getText().toString());
        savePreferences.storeString(Constants.NUMBER_KEY, number.getText().toString());
        savePreferences.storeString(Constants.NEIBOARD_KEY, neiboard.getText().toString());
        savePreferences.storeString(Constants.COMPLEMENT_KEY, complement.getText().toString());

    }

}
