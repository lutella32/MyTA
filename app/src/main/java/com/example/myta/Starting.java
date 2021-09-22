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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
    }
    public void goHeart(View view) {
        RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radio3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton radio4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton radio5 = (RadioButton) findViewById(R.id.radioButton5);
        if (!(radio1.isChecked() | radio2.isChecked())) {
            Context context = getApplicationContext();
            CharSequence textToast = "You need to enter an answer";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, textToast, duration);
            toast.show();
        } else {
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
                Intent lecturechant = new Intent(this, myheart.class);
                startActivity(lecturechant);
            }

        }
    }


}