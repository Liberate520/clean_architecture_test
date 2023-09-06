package com.example.cleanarchitecturetest.data;

import android.content.Context;
import android.content.SharedPreferences;

public class StoragePref {

    private Context context;
    SharedPreferences sharedPreferences;

    public StoragePref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public boolean saveUserName(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.apply();
        return true;
    }

    public String loadUserName(){
        return sharedPreferences.getString("name", "default name");
    }
}
