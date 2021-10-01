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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromEnvtToResult");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                this.person.print();

                TextView name = findViewById(R.id.textView22);
                name.setText(person.getName());

                TextView CD = findViewById(R.id.textView12);
                if (person.getCardiacDisease()==true){ CD.setText("Cardiac disease : yes"); }
                if (person.getCardiacDisease()==false){ CD.setText("Cardiac disease : no"); }

                TextView Ch = findViewById(R.id.textView23);
                if (person.getCholestPb()==true){ Ch.setText("Cholesterol problem : yes"); }
                if (person.getCholestPb()==false){ Ch.setText("Cholesterol problem : no"); }

                TextView D = findViewById(R.id.textView24);
                if (person.getDiab()==true){ D.setText("Diabete : yes"); }
                if (person.getDiab()==false){ D.setText("Diabete : no"); }

                TextView H = findViewById(R.id.textView25);
                if (person.getHypertension()==true){ H.setText("Hypertension : yes"); }
                if (person.getHypertension()==false){ H.setText("Hypertension : no"); }

                TextView PCD = findViewById(R.id.textView26);
                if (person.getParentPb().equals(Person.ParentPb.yes)){ PCD.setText("Parent with cardiac problem : yes"); }
                if (person.getParentPb().equals(Person.ParentPb.no)){ PCD.setText("Parent with cardiac problem  : no"); }
                if (person.getParentPb().equals(Person.ParentPb.maybe)){ PCD.setText("Parent with cardiac problem  : maybe"); }

                TextView IMC = findViewById(R.id.textView27);
                if (person.getImc().equals(Person.Imc.yes)){ IMC.setText("IMC known : yes"); }
                if (person.getImc().equals(Person.Imc.no)){ IMC.setText("IMC known : no"); }
                if (person.getImc().equals(Person.Imc.IDontKnow)){ IMC.setText("IMC known : I don't know"); }

                TextView Doc = findViewById(R.id.textView13);
                if (person.getDoctor()==true){ Doc.setText("You talked abour heart with your doctor : yes"); }
                if (person.getDoctor()==false){ Doc.setText("You talked abour heart with your doctor : no"); }

                TextView check = findViewById(R.id.textView28);
                if (person.getCheckpoint()==true){ check.setText("Heart checkpoint : yes"); }
                if (person.getCheckpoint()==false){ check.setText("Heart checkpoint : no"); }

                TextView cardio = findViewById(R.id.textView29);
                if (person.getAppointment()==true){ cardio.setText("Appointment with a cardiologist : yes"); }
                if (person.getAppointment()==false){ cardio.setText("Appointment with a cardiologist : no"); }

                TextView Sed = findViewById(R.id.textView14);
                if (person.getSendentary()==true){ Sed.setText("Sedentary work : yes"); }
                if (person.getSendentary()==false){ Sed.setText("Sedentary work : no"); }

                TextView sp = findViewById(R.id.textView30);
                if (person.getCheckpoint()==true){ sp.setText("Doing sport regularly : yes"); }
                if (person.getCheckpoint()==false){ sp.setText("Doing sport regularly : no"); }

                TextView sm = findViewById(R.id.textView31);
                if (person.getAppointment()==true){ sm.setText("Smoking : yes"); }
                if (person.getAppointment()==false){ sm.setText("Smoking : no"); }


              /*  if(person.getImc().equals(Person.Imc.yes)){
                    TextView textImc = findViewById(R.id.textView14);
                    textImc.setVisibility(View.INVISIBLE);
                    Button imc = findViewById(R.id.button2);
                    imc.setVisibility(View.INVISIBLE);
                }
                if(person.getParentPb().equals(Person.ParentPb.maybe)){
                    TextView textImc = findViewById(R.id.textView14);
                    textImc.setText("You should talk with your family about heart diseases");
                }
                if(person.getImc().equals(Person.Imc.no) | (person.getImc().equals(Person.Imc.IDontKnow))){
                    TextView text2 = findViewById(R.id.textView14);
                    text2.setText("you need to check your imc ");


                }*/


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
    public void gotoAdvice(View view) {

        Intent lecturechant = new Intent(this, Advice.class);
        lecturechant.putExtra("FromResultToAdvice", this.person);
        startActivity(lecturechant);
/*        String url = "https://www.imc.fr/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);*/
    }
    public void goBackEnvt(View view){
        onBackPressed();
    }

    public void finishing(View view) {

        finishAffinity();
        System.exit(0);
       // android.os.Process.killProcess(android.os.Process.myPid());
        }
}