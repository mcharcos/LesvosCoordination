package com.example.loginregister;

/**
 * Created by miguelcharcosllorens on 12/29/15.
 */
public class User {

    String name, username;
    String password;

    public User (String name, String username, String password)
    {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User (String username, String password)
    {
        this.name = "";
        this.username = username;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
