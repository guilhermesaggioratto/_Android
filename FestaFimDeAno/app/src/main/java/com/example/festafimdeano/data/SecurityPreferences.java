package com.example.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.festafimdeano.View.DetailActivity;

public class SecurityPreferences {

    private SharedPreferences mSharedPreferences;

    //construtor
    public SecurityPreferences(Context mContext){
        this.mSharedPreferences = mContext.getSharedPreferences("FestaFimAno", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value)
    {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String GetStoredString(String key)
    {
        return this.mSharedPreferences.getString(key, "");
    }
}
