package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    Person person;
    public enum Age{LessThan40, between40and60, more60};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // processIntentData();
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromSuivitoResult");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();
                if (person.getAge().equals(Person.Age.more60) | person.getAge().equals(Person.Age.between40and60)) {
                        if (false == person.getCheckpoint() | false == person.getDoctor() | false == person.getAppointment()) {

                            TextView text1 = findViewById(R.id.textView12);
                            text1.setText("you need to see a medecin to check your heart");
                            if (true == person.getDiab() | true == person.getCardiacDisease() | true == person.getHypertension() | true == person.getCholestPb() | person.getImc().equals(Person.Imc.no) | person.getParentPb().equals(Person.ParentPb.yes)) {

                                TextView text2 = findViewById(R.id.textView13);
                                text2.setText("you need to see a keep a healthy life style");

                            }
                        } else {
                            if(person.getImc().equals(Person.Imc.no) | (person.getImc().equals(Person.Imc.IDontKnow))){
                                TextView text2 = findViewById(R.id.textView13);
                                text2.setText("you need to check your imc on : https://www.imc.fr/");
                            }

                            if (false == person.getDiab() & false == person.getCardiacDisease() & false == person.getHypertension() & false == person.getCholestPb()) {

                                TextView text2 = findViewById(R.id.textView12);
                                text2.setText("you need to see a keep a healthy life style");

                            } else {

                                TextView text2 = findViewById(R.id.textView13);
                                text2.setText("you are good");

                            }
                        }
                }

                if(person.getAge().equals(Person.Age.LessThan40)) {
                    if (false == person.getCheckpoint() | false == person.getDoctor() | false == person.getAppointment()) {

                        TextView text1 = findViewById(R.id.textView12);
                        text1.setText("if you have shortness of breath during effort, maybe you need to check you heart");
                        if (true == person.getDiab() | true == person.getCardiacDisease() | true == person.getHypertension() | true == person.getCholestPb() | person.getImc().equals(Person.Imc.no) | person.getParentPb().equals(Person.ParentPb.yes)) {

                            TextView text2 = findViewById(R.id.textView13);
                            text2.setText("you need to see a keep a healthy life style");

                        }
                    } else {

                        if (false == person.getDiab() & false == person.getCardiacDisease() & false == person.getHypertension() & false == person.getCholestPb()) {

                            TextView text2 = findViewById(R.id.textView12);
                            text2.setText("you need to see a keep a healthy life style");

                        } else {

                            TextView text2 = findViewById(R.id.textView13);
                            text2.setText("you are good");

                        }
                    }
                }
                    if(person.getImc().equals(Person.Imc.yes)){
                        TextView textImc = findViewById(R.id.textView14);
                        textImc.setVisibility(View.INVISIBLE);
                        Button imc = findViewById(R.id.button2);
                        imc.setVisibility(View.INVISIBLE);


                    }
                    if(person.getParentPb().equals(Person.ParentPb.maybe)){
                        TextView textImc = findViewById(R.id.textView14);
                        textImc.setText("Talk with your family");
                    }
                    if(person.getImc().equals(Person.Imc.no) | (person.getImc().equals(Person.Imc.IDontKnow))){
                        TextView text2 = findViewById(R.id.textView14);
                        text2.setText("you need to check your imc ");


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

    public void site(View view) {
        String url = "https://fedecardio.org/je-me-teste/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void gotoIMC(View view) {
        String url = "https://www.imc.fr/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}