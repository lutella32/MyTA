package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
                //if(person.getAge().equals("more60")) {
                if (false == person.getCheckpoint() | false == person.getDoctor() | false ==person.getAppointment()) {

                        TextView text1 = findViewById(R.id.textView12);
                        text1.setText("you need to see a doctor to check your heart");
                    if (true == person.getDiab() | true == person.getCardiacDisease() | true == person.getHypertension() | true == person.getCholestPb() ) {

                        TextView text2 = findViewById(R.id.textView13);
                        text2.setText("you need to see a keep a healthy life style");

                    }
                    }
                else {
                    if (true == person.getDiab() | true == person.getCardiacDisease() | true == person.getHypertension() | true == person.getCholestPb()) {

                        TextView text2 = findViewById(R.id.textView12);
                        text2.setText("you need to see a keep a healthy life style");

                    } else {

                        TextView text2 = findViewById(R.id.textView13);
                        text2.setText("you are good");

                    }
                }
               // }
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
}