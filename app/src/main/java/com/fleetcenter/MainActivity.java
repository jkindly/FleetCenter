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

public class MainActivity extends AppCompatActivity {

    private Button mNextQuoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mNextQuoteButton = findViewById(R.id.button);

//        mNextQuoteButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Następny cytat pedale", Snackbar.LENGTH_LONG).show();
//            }
//        });
    }
//
//    public void metoda(View view) {
//        Snackbar.make(view, "AHA", Snackbar.LENGTH_LONG).show();
//    }
}
