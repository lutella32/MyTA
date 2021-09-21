package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class myheart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheart);
    }

    public void goSuivi(View view) {
        setContentView(R.layout.activity_starting);
    }
}