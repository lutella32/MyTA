package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Suivi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi);
    }
    public void gofinish(View view) {

        //setContentView(R.layout.activity_results);
        Intent lecturechant = new Intent(this, Results.class);
        startActivity(lecturechant);
    }
    public void goBackHeart(View view) {
        onBackPressed();
    }

}