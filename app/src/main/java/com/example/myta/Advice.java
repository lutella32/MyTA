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
        person =  new Person();
        processIntentData();

        afficheInformation(person);

        Context context = getApplicationContext();
        CharSequence textToast = "You need to enter a weight and a size";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, textToast, duration);
        edit = findViewById(R.id.editTextNumberSigned);
        edit2 = findViewById(R.id.editTextNumberSigned2);

        edit2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                Log.d("test","avant if");
                //Integer n=Integer.parseInt(edit2.getText().toString());
                if(!edit.getText().toString().equals("") & !edit2.getText().toString().equals("")){


                    Log.d("test","dans if");
                    Calcul(view);

                }
                else{
                    toast.show();
                }
                return false;
            }
        });
        edit = findViewById(R.id.editTextNumberSigned);
        edit2 = findViewById(R.id.editTextNumberSigned2);
        edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if(!edit2.getText().toString().equals("")){
                        Log.d("test dans edit","dans if");
                        Calcul(view);
                    }
                return false;
            }
        });


    }
    public void Calcul(View view){
        text31 = findViewById(R.id.textView31);
        Log.d("method calcul","debut");
        edit = findViewById(R.id.editTextNumberSigned);
        String taille="";
        Editable n = edit.getText();
        taille = n.toString();
        Double dtaille = 0.0;
        dtaille= Double.parseDouble(taille);

        edit2 = findViewById(R.id.editTextNumberSigned2);
        String poids="";
        Editable n2 = edit2.getText();
        poids = n2.toString();
        Double dpoids =0.0;
        dpoids=Double.parseDouble(poids);

        String IMCF="";
        Double IMC=0.0;
        Log.d("method calcul","milieu");
        Integer IMCFINAL=0;


        IMC = (((dpoids/(dtaille*dtaille)))*10000);
        IMCFINAL = IMC.intValue();
        // IMCFINAL=30;
        IMCF = String.valueOf(IMCFINAL);

        Log.d("method calcul","milieu2");
        if (IMCFINAL<=18) {
            text31.setText(IMCF+" you are too thin");
        }
        if (IMCFINAL>18 & IMCFINAL<=25) {
            text31.setText(IMCF+" you are GOOD");
        }
        if (IMCFINAL>25 & IMCFINAL<=30) {
            text31.setText(IMCF+" you are overweight");
        }
        if (IMCFINAL>30) {
            text31.setText(IMCF+" you are in obesity");

        }
        Log.d("method calcul","fin");

    }
    public void afficheInformation(Person person){
                        TextView text1=findViewById(R.id.textView27);
                        TextView text2=findViewById(R.id.textView28);
                        if (false == person.getCheckpoint() & false == person.getDoctor() & false == person.getAppointment()) {

                            text1.setText("You need to see a doctor to check your heart");


                                    if (true == person.getDiab() | true == person.getCardiacDisease() | true == person.getHypertension() | true == person.getCholestPb()  | person.getParentPb().equals(Person.ParentPb.yes)){
                                        if(false==person.getSport()) {  text2.setText("You need to see a keep a healthy life style and do some sport");  }

                                        text2.setText("You need to see a keep a healthy life style");
                                        if(true==person.getSmoke()){
                                            text2.setText("You need to see a keep a healthy life style and do some sport. More you need to stop smoke, called : 3989");}
                                    }
                                    else {
                                        text2.setText("Maube you can do a ckeckpoint of heart enven if you don't have predisposition ");
                                    }

                        } else {

                            if (true == person.getCheckpoint() | true == person.getDoctor() | true == person.getAppointment()){
                                text1.setText("you see often your doctor, think do to sport");
                                if(true==person.getSport() & false==person.getSmoke()){text1.setText("you see often your doctor, and do sport it's good!");}


                                if (false == person.getDiab() | false == person.getCardiacDisease() | false == person.getHypertension() | false == person.getCholestPb()) {


                                    text2.setText("you need to see a keep a healthy life style");
                                    if(person.getParentPb().equals(Person.ParentPb.no) | person.getParentPb().equals(Person.ParentPb.yes)){
                                        text2.setText("you need to see a keep a healthy life style, and talk with your family");
                                    }

                                }
                            }
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

                    text29.setVisibility(View.INVISIBLE);
                  text30.setVisibility(View.INVISIBLE);
                text32.setVisibility(View.INVISIBLE);
                   text31.setVisibility(View.INVISIBLE);
                   edit.setVisibility(View.INVISIBLE);
                        edit2.setVisibility(View.INVISIBLE);

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
    public void goBackStart(View view) { onBackPressed(); }
}