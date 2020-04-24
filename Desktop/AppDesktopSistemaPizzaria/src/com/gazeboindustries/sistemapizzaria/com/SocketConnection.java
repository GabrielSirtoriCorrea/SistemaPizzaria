/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazeboindustries.sistemapizzaria.com;

import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.apache.commons.io.IOUtils;

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
    InputStream in;
    
    public SocketConnection(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        
        this.client = new Socket(this.ip, this.port);
        out = new PrintStream(client.getOutputStream()); 
        in = new BufferedInputStream(client.getInputStream());
        
    }
    
    public String SendMessage(String message) throws JSONException, IOException {
       out.print(message);
       
       
        String json = IOUtils.toString(in, "UTF-8");
       
       
        return json;
        
        //JSONObject request1 = new JSONObject(jsonObj.get("1").toString());    
        /*System.out.println(jsonObj.toString());
        System.out.println(request1.get("client").toString());    */
        
    }
    
    public void Close() throws IOException{
        this.client.close();
    }
    
}
