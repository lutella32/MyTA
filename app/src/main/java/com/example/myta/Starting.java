package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Starting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
    }
    public void goHeart(View view) {

        //setContentView(R.layout.activity_myheart);
        Intent lecturechant = new Intent(this, myheart.class);
        startActivity(lecturechant);

    }


}