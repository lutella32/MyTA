package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Starting extends AppCompatActivity {

    private Person person;
    public static final String TAG ="Starting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        processIntentData();
        setContentView(R.layout.activity_starting);
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



    public void goHeart(View view) {
        RadioButton woman = (RadioButton) findViewById(R.id.radioButton);
        RadioButton man = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton less = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton between = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton more = (RadioButton) findViewById(R.id.radioButton5);
        if (!(man.isChecked() | woman.isChecked())) {
            Context context = getApplicationContext();
            CharSequence textToast = "You need to enter an answer";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, textToast, duration);
            toast.show();
        } else {
            if (!(woman.isChecked()) && man.isChecked() ){
                person.setGenre(Person.Genre.man);
            }
            if(woman.isChecked() && !(man.isChecked())){
                person.setGenre(Person.Genre.woman);
            }
            Log.d("starting","you are in checked;");
            if (!(less.isChecked() | between.isChecked() | more.isChecked())) {
                Context context = getApplicationContext();
                CharSequence textToast = "You need to enter an answer";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, textToast, duration);
                toast.show();

            } else {
                if (less.isChecked() && !( between.isChecked() && more.isChecked())){
                    person.setAge(Person.Age.LessThan40);
                }
                if (between.isChecked() && !( less.isChecked() && more.isChecked())){
                    person.setAge(Person.Age.between40and60);
                }
                if (more.isChecked() && !( less.isChecked() && between.isChecked())){
                    person.setAge(Person.Age.more60);
                }
                Log.d("starting","you are in checked;");

                Intent lecture= new Intent(this, myheart.class);
                lecture.putExtra("FromNameToStarting", this.person);
                startActivity(lecture);

            }

        }
    }

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