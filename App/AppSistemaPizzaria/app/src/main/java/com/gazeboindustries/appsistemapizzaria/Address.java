package com.gazeboindustries.appsistemapizzaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Address extends Activity {

    EditText client;
    EditText phone;
    EditText road;
    EditText number;
    EditText neiboard;
    EditText complement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        client = findViewById(R.id.txtAddressNome);
        phone = findViewById(R.id.txtAddressTelefone);
        road = findViewById(R.id.txtAddressRua);
        number = findViewById(R.id.txtAddressNumero);
        neiboard = findViewById(R.id.txtAddressBairro);
        complement = findViewById(R.id.txtAddressComplemento);

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

        if(savedPreferences.getStoredString(Constants.CLIENT_KEY) != null){
            client.setText(savedPreferences.getStoredString(Constants.CLIENT_KEY));
        }

        if(savedPreferences.getStoredString(Constants.PHONE_KEY) != null){
            phone.setText(savedPreferences.getStoredString(Constants.PHONE_KEY));
        }

    }

    public void SaveAddress(View view){
        SecurityPreferences savePreferences = new SecurityPreferences(this);

        savePreferences.storeString(Constants.PHONE_KEY, phone.getText().toString());
        savePreferences.storeString(Constants.CLIENT_KEY, client.getText().toString());
        savePreferences.storeString(Constants.ROAD_KEY, road.getText().toString());
        savePreferences.storeString(Constants.NUMBER_KEY, number.getText().toString());
        savePreferences.storeString(Constants.NEIBOARD_KEY, neiboard.getText().toString());
        savePreferences.storeString(Constants.COMPLEMENT_KEY, complement.getText().toString());

        Toast.makeText(this, "Informações salvas com sucesso", Toast.LENGTH_SHORT).show();

    }

}
