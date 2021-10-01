package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
      // person = new Person();

    }

    public void goSuivi(View view) {

        //Cardiac disease
        RadioGroup CardiacD = findViewById(R.id.radioGroup4);
        RadioButton button6 = findViewById(R.id.radioButton6);
        RadioButton button7 = findViewById(R.id.radioButton7);

        //Cholesterol
        RadioGroup Cholest = findViewById(R.id.radioGroup2);
        RadioButton button19 = findViewById(R.id.radioButton19);
        RadioButton button22 = findViewById(R.id.radioButton22);

        //Diabete
        RadioGroup Diabete = findViewById(R.id.radioGroup5);
        RadioButton button13 = findViewById(R.id.radioButton13);
        RadioButton button18 = findViewById(R.id.radioButton18);


        //Hypertention
        RadioGroup Hypertension = findViewById(R.id.radioGroup);
        RadioButton button20 = findViewById(R.id.radioButton20);
        RadioButton button21 = findViewById(R.id.radioButton21);
        //Parent with cardiac problem
        RadioGroup CardiacParent = findViewById(R.id.radioGroup3);
        RadioButton button9 = findViewById(R.id.radioButton9);
        RadioButton button8 = findViewById(R.id.radioButton8);
        RadioButton button10 = findViewById(R.id.radioButton10);
        //IMC
        RadioGroup IMC = findViewById(R.id.radioGroup6);
        RadioButton button16 = findViewById(R.id.radioButton16);
        RadioButton button17 = findViewById(R.id.radioButton17);
        RadioButton button23 = findViewById(R.id.radioButton23);

        Context context = getApplicationContext();
        CharSequence textToast = "You need to enter an answer";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, textToast, duration);


        if(button6.isChecked() | button7.isChecked()) {
           // String CardiacValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
            if(button6.isChecked()){person.setCardiacDisease(true);}
            if(button7.isChecked()){person.setCardiacDisease(false);}
            Log.d("buttoncardiac","yes");
           // if (CardiacValue.equals("yes")){ person.setCardiacDisease(true); }
           // if (CardiacValue.equals("no")){ person.setCardiacDisease(false); }

            if (button16.isChecked() | button17.isChecked() | button23.isChecked()) {
               // String IMCValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                Log.d("imc","yes");
                if (button16.isChecked()){ person.setImc(Person.Imc.yes); }
                if (button17.isChecked()){ person.setImc(Person.Imc.no); }
                if (button23.isChecked()){ person.setImc(Person.Imc.IDontKnow); }

                if(button20.isChecked() | button21.isChecked()) {
                    Log.d("ht","yes");
                   // String HTValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                    if (button20.isChecked()){ person.setHypertension(true); }
                    if (button21.isChecked()){ person.setHypertension(false); }

                    if(button9.isChecked() | button8.isChecked() | button10.isChecked()) {
                        Log.d("cpvalue","yes");
                       // String CPValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                        if (button9.isChecked()){ person.setParentPb(Person.ParentPb.yes); }
                        if (button8.isChecked()){ person.setParentPb(Person.ParentPb.no); }
                        if (button10.isChecked()){ person.setParentPb(Person.ParentPb.maybe); }

                        if(button19.isChecked() | button22.isChecked()) {
                            //String CholestValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                            Log.d("chol","yes");
                            if (button19.isChecked()){ person.setCholestPb(true); }
                            if (button22.isChecked()){ person.setCholestPb(false); }

                            if(button13.isChecked() | button18.isChecked()) {
                               // String DiabeteValue = ((RadioButton)findViewById(CardiacD.getCheckedRadioButtonId())).getText().toString();
                                Log.d("diabet","yes");
                                if (button13.isChecked()){ person.setDiab(true); }
                                if (button18.isChecked()){ person.setDiab(false); }
                               // person.print();
                                Intent lecturechant = new Intent(this, Suivi.class);
                                lecturechant.putExtra("FromSmyHeartToSuivi", this.person);
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

    public void goBackStart(View view) {
//        Intent lecturechant = new Intent(this, Starting.class);
//        lecturechant.putExtra("FromSmyHeartToSuivi", this.person);
//        startActivity(lecturechant);
        onBackPressed();

    }

    private void processIntentData(){
        Intent intent = getIntent();
        if(intent!=null){
            Person transferredPerson = intent.getParcelableExtra("FromStartingTomyHeart");
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