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
        RadioButton radio3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton radio4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton radio5 = (RadioButton) findViewById(R.id.radioButton5);
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
            if (!(radio3.isChecked() | radio4.isChecked() | radio5.isChecked())) {
                Context context = getApplicationContext();
                CharSequence textToast = "You need to enter an answer";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, textToast, duration);
                toast.show();

            } else {
                Log.d("starting","you are in checked;");
                //setContentView(R.layout.activity_myheart);

                Intent lecture= new Intent(this, myheart.class);

                person.setAge(Person.Age.LessThan40);
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