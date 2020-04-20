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
    private String PizzaTaste2;
    private String Comments;
    private String TotalPrice;



    public Pedido(String client, String phone, String address, String pizzaType, String qntdTastes, String pizzaTaste1, String pizzaTaste2, String comments, String totalPrice) {
        this.Client = client;
        this.phone = phone;
        this.Address = address;
        this.PizzaType = pizzaType;
        this.QntdTastes = qntdTastes;
        this.PizzaTaste1 = pizzaTaste1;
        this.PizzaTaste2 = pizzaTaste2;
        this.Comments = comments;
        this.TotalPrice = totalPrice;
    }

    public void SendRequest(){
        try{

            SocketConnection connection = new SocketConnection();

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("ID", "SendNewRequest");
            jsonObj.put("Client", this.Client);
            jsonObj.put("phone", this.phone);
            jsonObj.put("Address", this.Address);
            jsonObj.put("PizzaType", this.PizzaType);
            jsonObj.put("PizzaQntdTastes", this.QntdTastes);
            jsonObj.put("PizzaTaste1", this.PizzaTaste1);
            jsonObj.put("PizzaTaste2", this.PizzaTaste2);
            jsonObj.put("Comments", this.Comments);
            jsonObj.put("TotalPrice", this.TotalPrice);

            AsyncTask<String, Integer, String> response = connection.execute(String.valueOf(jsonObj));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
