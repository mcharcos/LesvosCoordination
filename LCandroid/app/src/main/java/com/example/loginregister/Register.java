package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lcandroid.R;

public class Register extends ActionBarActivity implements View.OnClickListener{

    Button bregister;
    EditText etname, etusername,etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etname = (EditText) findViewById(R.id.etname);
        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        bregister= (Button) findViewById(R.id.bregister);

        bregister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bregister:
                String name = etname.getText().toString();
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                User user = new User(name,username,password);

                registerUser(user);
                break;
        }
    }

    private void registerUser(User user){
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeUserDataBackground(user,new GetUserCallback(){
            @Override
            public void done(User returnedUser){
                startActivity(new Intent(Register.this,Login.class));
            }
        });
    }
}
