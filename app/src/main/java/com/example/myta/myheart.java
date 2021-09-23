package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class myheart extends AppCompatActivity {
    private Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheart);
        person = new Person();
        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromNameToStarting");
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

    public void goSuivi(View view) {

        RadioButton radio7 = (RadioButton) findViewById(R.id.radioButton7);
        RadioButton radio6 = (RadioButton) findViewById(R.id.radioButton6);

        RadioButton radio16 = (RadioButton) findViewById(R.id.radioButton16);
        RadioButton radio17 = (RadioButton) findViewById(R.id.radioButton17);
        RadioButton radio23 = (RadioButton) findViewById(R.id.radioButton23);

        RadioButton radio20 = (RadioButton) findViewById(R.id.radioButton20);
        RadioButton radio21 = (RadioButton) findViewById(R.id.radioButton21);

        RadioButton radio19 = (RadioButton) findViewById(R.id.radioButton19);
        RadioButton radio22 = (RadioButton) findViewById(R.id.radioButton22);

        RadioButton radio9 = (RadioButton) findViewById(R.id.radioButton9);
        RadioButton radio8 = (RadioButton) findViewById(R.id.radioButton8);
        RadioButton radio10 = (RadioButton) findViewById(R.id.radioButton10);

        RadioButton radio13 = (RadioButton) findViewById(R.id.radioButton13);
        RadioButton radio28 = (RadioButton) findViewById(R.id.radioButton18);
        Context context = getApplicationContext();
        CharSequence textToast = "You need to enter an answer";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, textToast, duration);

        if(radio7.isChecked() | radio6.isChecked()) {
            if (radio16.isChecked() | radio17.isChecked() | radio23.isChecked()) {
                if(radio20.isChecked() | radio21.isChecked()) {
                    if(radio9.isChecked()|radio8.isChecked() | radio10.isChecked()) {
                        if(radio19.isChecked() | radio22.isChecked()) {
                            if(radio13.isChecked() | radio28.isChecked()) {

                                Intent lecturechant = new Intent(this, Suivi.class);
                                startActivity(lecturechant);
                            }
                            else{
                                toast.show();
                            }
                        }
                        else{
                            toast.show();
                        }
                    }
                    else{
                        toast.show();
                    }
                }
                else{
                    toast.show();
                }
            }
            else{
                toast.show();
            }
        }
        else{
            toast.show();
        }
    }

    public void goBackStart(View view) { onBackPressed(); }
}