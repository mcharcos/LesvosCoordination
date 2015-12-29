package com.example.lcandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginregister.Login;

public class MainActivity extends ActionBarActivity  implements View.OnClickListener{

    Button blogout;
    EditText etname, etusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText) findViewById(R.id.etname);
        etusername = (EditText) findViewById(R.id.etusername);
        blogout= (Button) findViewById(R.id.blogin);

        blogout.setOnClickListener(this);
    }

    /* I removed this based on the login-register tutorial at https://www.youtube.com/watch?v=x0I5vJfaRIU
       but we may want to add it later
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.blogout:

                startActivity(new Intent(this,Login.class));

                break;
        }
    }
}
