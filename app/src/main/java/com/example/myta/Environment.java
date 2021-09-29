package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Environment extends AppCompatActivity {

    Person person;
    public static final String TAG ="Starting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        processIntentData();
        setContentView(R.layout.activity_environment);
    }

    public void goBackSuivi(View view) { onBackPressed(); }

    public void goToResult(View view) {
        person.setSport(true);
        person.setSmoke(true);
        person.setSendentary(true);
        person.setHowManySport(4);
        Intent lecturechant = new Intent(this, Results.class);
        lecturechant.putExtra("FromEnvtToResult", this.person);
        startActivity(lecturechant);
    }


    private void processIntentData(){
        Intent intent = getIntent();
        if (intent != null){
            Person transferredPerson = intent.getParcelableExtra("FromSuivitoEnvt");
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
}