package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class myheart extends AppCompatActivity {

    private Person person;
    public static final String TAG ="Starting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        processIntentData();
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

        //Cardiac disease
        RadioGroup CardiacD = findViewById(R.id.radioGroup4);

        //Cholesterol
        RadioGroup Cholest = findViewById(R.id.radioGroup2);

        //Diabete
        RadioGroup Diabete = findViewById(R.id.radioGroup5);

        //Hypertention
        RadioGroup Hypertension = findViewById(R.id.radioGroup);

        //Parent with cardiac problem
        RadioGroup CardiacParent = findViewById(R.id.radioGroup3);

        //IMC
        RadioGroup IMC = findViewById(R.id.radioGroup6);


        Context context = getApplicationContext();
        CharSequence textToast = "You need to enter an answer";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, textToast, duration);

        if(CardiacD.getCheckedRadioButtonId() != -1) {
            String CardiacValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
            if (CardiacValue.equals("yes")){ person.setCardiacDisease(true); }
            if (CardiacValue.equals("no")){ person.setCardiacDisease(false); }

            if (IMC.getCheckedRadioButtonId() != -1) {
                String IMCValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                if (IMCValue.equals("yes")){ person.setImc(Person.Imc.yes); }
                if (IMCValue.equals("no")){ person.setImc(Person.Imc.no); }
                if (IMCValue.equals("I don't know")){ person.setImc(Person.Imc.IDontKnow); }

                if(Hypertension.getCheckedRadioButtonId() != -1) {
                    String HTValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                    if (HTValue.equals("yes")){ person.setHypertension(true); }
                    if (HTValue.equals("no")){ person.setHypertension(false); }

                    if(CardiacParent.getCheckedRadioButtonId() != -1) {
                        String CPValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                        if (CPValue.equals("yes")){ person.setParentPb(Person.ParentPb.yes); }
                        if (CPValue.equals("no")){ person.setParentPb(Person.ParentPb.no); }
                        if (CPValue.equals("Maybe")){ person.setParentPb(Person.ParentPb.maybe); }

                        if(Cholest.getCheckedRadioButtonId() != -1) {
                            String CholestValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                            if (CholestValue.equals("yes")){ person.setCholestPb(true); }
                            if (Cholest.equals("no")){ person.setCholestPb(false); }

                            if(Diabete.getCheckedRadioButtonId() != -1) {
                                String DiabeteValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                                if (DiabeteValue.equals("yes")){ person.setDiab(true); }
                                if (DiabeteValue.equals("no")){ person.setDiab(false); }

                                Intent lecturechant = new Intent(this, Suivi.class);
                                lecturechant.putExtra("FromStartingToHeart", this.person);
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

    private void processIntentData(){
        Intent intent = getIntent();
        if(intent!=null){
            Person transferredPerson = intent.getParcelableExtra("FromNameToStarting");
            if (transferredPerson!=null){
                this.person = transferredPerson;
                this.person.print();
                Log.d(Starting.TAG, "Personne ok");
            }
            else{
                Log.d(Starting.TAG, "No person found after transfer from main");
            }
        }
        else{
            Log.d(Starting.TAG, "Error when transferrinf from main");
        }
    }
}