package com.fleetcenter.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.fleetcenter.AppLogin;
import com.fleetcenter.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText mLoginInput;
    EditText mPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginInput = findViewById(R.id.loginInput);
        mPasswordInput = findViewById(R.id.passwordInput);

    }

    public void onLogin (View view){
        String login = mLoginInput.getText().toString();
        String password = mPasswordInput.getText().toString();

        AppLogin appLogin = new AppLogin(this, view);
        appLogin.execute(login, password);

        try {
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            assert inputMethodManager != null;
            inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
