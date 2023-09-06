package com.example.cleanarchitecturetest.data;

import android.content.Context;

import com.example.cleanarchitecturetest.domain.Repository;
import com.example.cleanarchitecturetest.domain.entety.User;

public class UserRepositoryImpl implements Repository {
    private Context context;
    private StoragePref storagePref;

    public UserRepositoryImpl(Context context) {
        this.context = context;
        storagePref = new StoragePref(context);
    }

    public boolean saveUser(User user){
        return storagePref.saveUserName(user.getName());
    }

    public User loadUser(){
        String name = storagePref.loadUserName();
        return new User(name);
    }
}
