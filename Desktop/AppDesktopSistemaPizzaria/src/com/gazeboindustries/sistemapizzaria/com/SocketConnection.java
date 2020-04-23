/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazeboindustries.sistemapizzaria.com;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

/**
 *
 * @author Gazebo
 */
public class SocketConnection {
    private String ip;
    private int port;
    private String message;
    private Socket client;
    PrintStream out;
    Scanner in;
    
    public SocketConnection(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        
        this.client = new Socket(this.ip, this.port);
        out = new PrintStream(client.getOutputStream()); 
        in = new Scanner(client.getInputStream());
        
    }
    
    public void SendMessage(String message) throws JSONException {
       out.print(message);
       
        while(in.hasNext()){
            //JSONObject jsonObj = new JSONObject(in.next());
        
            System.out.println(in.next());
            
        }
    }
    
    
}
