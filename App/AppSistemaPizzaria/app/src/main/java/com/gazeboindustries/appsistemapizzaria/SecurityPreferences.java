package com.gazeboindustries.appsistemapizzaria;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {
    private SharedPreferences preferences;

    public SecurityPreferences(Context content) {
        this.preferences = content.getSharedPreferences("Dados", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value){
        this.preferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key){
        return this.preferences.getString(key, "");
    }

}
