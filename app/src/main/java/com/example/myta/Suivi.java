package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Suivi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi);
    }
    public void gofinish(View view) {

        //setContentView(R.layout.activity_results);
        RadioButton radio24 = (RadioButton) findViewById(R.id.radioButton24);
        RadioButton radio25 = (RadioButton) findViewById(R.id.radioButton25);

        RadioButton radio14 = (RadioButton) findViewById(R.id.radioButton14);
        RadioButton radio15 = (RadioButton) findViewById(R.id.radioButton15);


        RadioButton radio11 = (RadioButton) findViewById(R.id.radioButton11);
        RadioButton radio12 = (RadioButton) findViewById(R.id.radioButton12);
        Context context = getApplicationContext();

        CharSequence textToast = "You need to enter an answer";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, textToast, duration);

        if(radio24.isChecked() | radio25.isChecked()) {
            if(radio14.isChecked() | radio15.isChecked()) {
                if(radio11.isChecked() | radio12.isChecked()) {
                    Intent lecturechant = new Intent(this, Results.class);
                    startActivity(lecturechant);
                }
                else{
                    toast.show();
                }
            }
            else {
                toast.show();
            }
        }
        else{
            toast.show();
        }
    }
    public void goBackHeart(View view) {
        onBackPressed();
    }

}