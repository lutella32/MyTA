package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Suivi extends AppCompatActivity {
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi);
        person = new Person();

        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromStartingToHeart");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
            }
            else {
                Log.d("Starting", "No Person found after transfer from Activity1");
            }
        }
        else {
            Log.d("starting", "Error when transferring from Activity1");
        }
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
            if(radio24.isChecked()){ person.setAppointment(true);}
            if(radio25.isChecked()){ person.setAppointment(false);}
            if(radio14.isChecked() | radio15.isChecked()) {
                if(radio14.isChecked()){ person.setCheckpoint(true);}
                if(radio15.isChecked()){ person.setCheckpoint(false);}
                if(radio11.isChecked() | radio12.isChecked()) {
                    if(radio11.isChecked()){ person.setDoctor(true);}
                    if(radio12.isChecked()){ person.setDoctor(false);}
                   // person.print();
                    Intent lecturechant = new Intent(this, Results.class);
                    lecturechant.putExtra("FromSuivitoResult", this.person);
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