package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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

        RadioButton radio27 = (RadioButton) findViewById(R.id.radioButton27);
        RadioButton radio28 = (RadioButton) findViewById(R.id.radioButton28);

        RadioButton radio29 = (RadioButton) findViewById(R.id.radioButton29);
        RadioButton radio30 = (RadioButton) findViewById(R.id.radioButton30);

        EditText number = (EditText) findViewById(R.id.editTextNumber);
        //Integer newN = (Integer) Integer.parseInt(number.getText().toString());

        RadioButton radio26 = (RadioButton) findViewById(R.id.radioButton26);
        RadioButton radio31 = (RadioButton) findViewById(R.id.radioButton31);

        Context context = getApplicationContext();
        CharSequence textToast = "You need to enter an answer";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, textToast, duration);

        if(radio27.isChecked() | radio28.isChecked()) {
            if(radio27.isChecked()){ person.setSendentary(true);}
            if(radio28.isChecked()){ person.setSendentary(false);}
            if(radio29.isChecked() | radio30.isChecked()) {
                if (radio29.isChecked()) {
                    person.setSport(true);
                }
                if (radio30.isChecked()) {
                    person.setSport(false);
                }
                if (!number.equals("")) {
                    person.setHowManySport(6);
                    if (radio26.isChecked() | radio31.isChecked()) {
                        if (radio26.isChecked()) {
                            person.setSmoke(true);
                        }
                        if (radio30.isChecked()) {
                            person.setSmoke(false);
                        }
                        Intent lecturechant = new Intent(this, Results.class);
                        lecturechant.putExtra("FromEnvtToResult", this.person);
                        startActivity(lecturechant);
                    }
                    else {
                        toast.show();
                    }
                }
                else {
                    toast.show();
                }
            }
            else {
                toast.show();
            }
        }
        else {
            toast.show();
        }

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