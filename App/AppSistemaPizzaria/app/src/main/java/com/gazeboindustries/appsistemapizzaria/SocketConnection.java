package com.gazeboindustries.appsistemapizzaria;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketConnection  extends AsyncTask<String, Integer, String>{
    //private String IP = "192.168.0.113";
    private String IP = "192.168.0.5";
    private int port = 3000;
    private Socket socket = null;
    private PrintWriter out = null;
    private Scanner in = null;
    private String Received = null;

    public SocketConnection(){

    }

    @Override
    protected String doInBackground(String... params) {
        try{
            this.socket = new Socket(IP, port);
            this.out = new PrintWriter(socket.getOutputStream(), true);
            //in = new Scanner(socket.getInputStream());

            this.out.println(params[0]);

            this.socket.close();

            return "1";
        }catch (IOException e){
            return "0";
        }
    }

    public String isReceived() {
        return Received;
    }

}
