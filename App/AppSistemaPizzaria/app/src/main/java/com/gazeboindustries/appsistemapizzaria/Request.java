package com.gazeboindustries.appsistemapizzaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Request extends Activity {

    int contCheck = 0;
    CheckBox checkBrocolis;
    CheckBox checkFrango;
    CheckBox checkPortuga;
    CheckBox checkBig;
    CheckBox checkSmall;
    String Taste;
    String Type;
    String Address;
    EditText comments;
    String client;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request1);

        checkBrocolis = findViewById(R.id.Request1CheckBrocolis);
        checkFrango = findViewById(R.id.Request1CheckFrango);
        checkPortuga = findViewById(R.id.Request1CheckPortuga);
        checkBig = findViewById(R.id.CheckRequest1TypeGrande);
        checkSmall = findViewById(R.id.CheckRequest1TypePequena);

        comments = findViewById(R.id.Request1Comments);


    }

    public void SendRequest(View view){

        SecurityPreferences savedPreferences = new SecurityPreferences(this);

        if (checkBrocolis.isChecked()) contCheck+=1;
        if (checkFrango.isChecked()) contCheck+=1;
        if (checkPortuga.isChecked()) contCheck+=1;

        if (contCheck!=1) Toast.makeText(this,"Escolha apenas um sabor", Toast.LENGTH_SHORT).show();
        else{
            if (checkBrocolis.isChecked()) Taste = "Brocolis";
            else if (checkFrango.isChecked()) Taste = "Frango";
            else Taste = "Portuga";

            if (savedPreferences.getStoredString(Constants.ROAD_KEY) != null){
                client = savedPreferences.getStoredString(Constants.CLIENT_KEY);
                phone = savedPreferences.getStoredString(Constants.PHONE_KEY);
                String road = savedPreferences.getStoredString(Constants.ROAD_KEY);
                String number = savedPreferences.getStoredString(Constants.NUMBER_KEY);
                String neiboard = savedPreferences.getStoredString(Constants.NEIBOARD_KEY);
                String complement = savedPreferences.getStoredString(Constants.COMPLEMENT_KEY);

                Address = "Rua: " + road +"\n" +
                        "Número: " + number + "\n" +
                        "Bairro: " + neiboard + "\n" +
                        "Complemento: " + complement + "\n";

                if(checkBig.isChecked()){
                    Type = "Grande";

                    Pedido pedido = new Pedido(client, phone, Address, Type, "1", Taste, comments.getText().toString());
                    pedido.SendRequest();

                } else{
                    if (checkSmall.isChecked()){
                        Type = "Pequena";

                        Pedido pedido = new Pedido(client, phone, Address, Type, "1", Taste, comments.getText().toString());
                        pedido.SendRequest();

                    }else{
                        Toast.makeText(this, "Selecione um tipo de pizza", Toast.LENGTH_SHORT).show();
                    }
                }

            }else{
                Toast.makeText(this, "Coloque suas informações pessoais para enviar o pedido", Toast.LENGTH_SHORT).show();
            }


        }

    }

}
