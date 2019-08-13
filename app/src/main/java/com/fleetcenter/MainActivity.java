package com.fleetcenter;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mLoginInput;
    EditText mPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginInput = (EditText) findViewById(R.id.loginInput);
        mPasswordInput = (EditText) findViewById(R.id.passwordInput);

    }

    public void onLogin (View view){
        String login = mLoginInput.getText().toString();
        String password = mPasswordInput.getText().toString();

        BackgroundWork backgroundWork = new BackgroundWork(this);
        backgroundWork.execute("login", login, password);
    }
}
