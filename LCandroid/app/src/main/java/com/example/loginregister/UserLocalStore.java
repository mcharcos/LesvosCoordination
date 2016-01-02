package com.example.loginregister;

import android.content.SharedPreferences;
import android.content.Context;

/**
 * Created by miguelcharcosllorens on 12/29/15.
 */
public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocaDatabase;

    public UserLocalStore(Context context){
        userLocaDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocaDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String name = userLocaDatabase.getString("name", "");
        String username = userLocaDatabase.getString("username","");
        String password = userLocaDatabase.getString("password","");

        User storedUser = new User(name, username, password);

        return storedUser;
    }

    public void setUserLoggedIn(boolean loogedIn){
        SharedPreferences.Editor spEditor = userLocaDatabase.edit();
        spEditor.putBoolean("loggedIn",loogedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if (userLocaDatabase.getBoolean("loggedIn",false) == true){
            return true;
        } else {
            return false;
        }
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocaDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
