package com.gazeboindustries.appsistemapizzaria;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

public class Pedido {
    private String Client;
    private String phone;
    private String Address;
    private String PizzaType;
    private String QntdTastes;
    private String PizzaTaste1;
    private String Comments;
    private String TotalPrice;



    public Pedido(String client, String phone, String address, String pizzaType, String qntdTastes, String pizzaTaste1, String comments) {
        this.Client = client;
        this.phone = phone;
        this.Address = address;
        this.PizzaType = pizzaType;
        this.QntdTastes = qntdTastes;
        this.PizzaTaste1 = pizzaTaste1;
        this.Comments = comments;

        if (this.PizzaTaste1.equals("Brocolis")) this.TotalPrice = "10";
        else if (this.PizzaTaste1.equals("Frango")) this.TotalPrice = "15";
        else this.TotalPrice = "10";

    }

    public void SendRequest(){
        try{

            SocketConnection connection = new SocketConnection();

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("ID", "AppSendNewRequest");
            jsonObj.put("client", this.Client);
            jsonObj.put("phone", this.phone);
            jsonObj.put("address", this.Address);
            jsonObj.put("pizzaType", this.PizzaType);
            jsonObj.put("pizzaQntdTastes", this.QntdTastes);
            jsonObj.put("pizzaTaste1", this.PizzaTaste1);
            jsonObj.put("comments", this.Comments);
            jsonObj.put("totalPrice", this.TotalPrice);

            AsyncTask<String, Integer, String> response = connection.execute(String.valueOf(jsonObj));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
