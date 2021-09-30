package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Advice extends AppCompatActivity {
    Person person;

    TextView text29 ;
    TextView text30 ;
    TextView text32 ;
    TextView text31 ;
    EditText edit ;
    EditText edit2;
    Button calcul;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice2);
        processIntentData();

        Context context = getApplicationContext();
        CharSequence textToast = "You need to enter a weight and a size";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, textToast, duration);
        edit = findViewById(R.id.editTextNumberSigned);
        edit2 = findViewById(R.id.editTextNumberSigned2);

        edit2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Integer n=Integer.parseInt(edit2.getText().toString());
                if(!edit.getText().toString().equals("") & n>10) {
                    Calcul(view);

                }
                else{
                    toast.show();
                }
                return false;
            }
        });
        edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Integer n=Integer.parseInt(edit.getText().toString());
                if(!edit2.getText().toString().equals("") & n>=100) {
                    Calcul(view);

                }
                else{
                    toast.show();
                }
                return false;
            }
        });
        //setContentView(R.layout.activity_advice2);




    }
    public void Calcul(View view){
        text31 = findViewById(R.id.textView31);
        edit = findViewById(R.id.editTextNumberSigned);
        edit2 = findViewById(R.id.editTextNumberSigned2);
        Editable n = edit.getText();
        Editable n2 = edit2.getText();
        String taille = n.toString();

        String poids = n2.toString();
        Double dtaille = Double.parseDouble(taille);
        Double dpoids = Double.parseDouble(poids);
        Double IMC = (((dpoids/(dtaille*dtaille)))*10000);
        Integer IMCFINAL = IMC.intValue();
        String IMCF = String.valueOf(IMCFINAL);
        if (IMCFINAL<=18) {
            text31.setText(IMCF+"you are too thin");
        }
        if (IMCFINAL>=18 & IMCFINAL<=25) {
            text31.setText(IMCF+"you are GOOD");
        }
        if (IMCFINAL>=25 & IMCFINAL<=30) {
            text31.setText(IMCF+"you are overweight");
        }
        else{
            text31.setText(IMCF+"you are in obesity");

        }

    }
    private void processIntentData(){
        Intent intent = getIntent();
        if (intent != null){
            Person transferredPerson = intent.getParcelableExtra("FromResultToAdvice");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                //this.person.print();
                if(person.getImc().equals(Person.Imc.yes)){
                    text29 = findViewById(R.id.textView29);
                    text30 = findViewById(R.id.textView30);
                    text32 = findViewById(R.id.textView32);
                    text31 = findViewById(R.id.textView31);
                    edit = findViewById(R.id.editTextNumberSigned);
                    edit2 = findViewById(R.id.editTextNumberSigned2);
                    calcul = findViewById(R.id.button4);
                    text29.setVisibility(View.INVISIBLE);
                  text30.setVisibility(View.INVISIBLE);
                text32.setVisibility(View.INVISIBLE);
                   text31.setVisibility(View.INVISIBLE);
                   edit.setVisibility(View.INVISIBLE);
                        edit2.setVisibility(View.INVISIBLE);
                  calcul.setVisibility(View.INVISIBLE);
               }
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