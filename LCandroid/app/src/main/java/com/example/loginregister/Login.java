package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.lcandroid.R;

public class Login extends ActionBarActivity implements View.OnClickListener {

    Button blogin;
    EditText etusername,etpassword;
    TextView tvregisterlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        tvregisterlink = (TextView) findViewById(R.id.tvregisterlink);
        blogin= (Button) findViewById(R.id.blogin);

        blogin.setOnClickListener(this);
        tvregisterlink.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.blogin:

                break;
            case R.id.tvregisterlink:

                startActivity(new Intent(this,Register.class));
                break;
        }
    }
}
