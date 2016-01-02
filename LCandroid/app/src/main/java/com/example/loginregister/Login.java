package com.example.loginregister;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.lcandroid.MainActivity;
import com.example.lcandroid.R;

public class Login extends ActionBarActivity implements View.OnClickListener {

    Button blogin;
    EditText etusername,etpassword;
    TextView tvregisterlink;
    UserLocalStore userLocalStore;

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

        userLocalStore = new UserLocalStore(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.blogin:
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                User user = new User(username, password);

                authenticate(user);
                break;
            case R.id.tvregisterlink:

                startActivity(new Intent(this,Register.class));
                break;
        }
    }

    private void authenticate(User user){
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.fetchUserDataBackground(user, new GetUserCallback() {

            @Override
            public void done(User returnedUser){
                if (returnedUser == null){
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);
                }
            }

        });
    }

    private void showErrorMessage(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Login.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok",null);
        dialogBuilder.show();
    }

    private void logUserIn(User returnedUser){
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);

        startActivity(new Intent(this, MainActivity.class));

    }
}
