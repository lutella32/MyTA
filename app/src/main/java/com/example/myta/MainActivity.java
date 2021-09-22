package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(android.view.View v) {
        final TextInputEditText edit1= (TextInputEditText) findViewById(R.id.textinput);
        String texte = String.valueOf(edit1.getText());

       if(texte.equals("")){
            Log.d("start","h");
            Context context = getApplicationContext();
            CharSequence textToast = "You need to enter name";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, textToast, duration);
            toast.show();
        }
      else{
           Log.d("start","you are in start");
           Intent lecture = new Intent(this, Starting.class);
           startActivity(lecture);
         //  setContentView(R.layout.activity_starting);
      }
    }

    //Changements de page : next
//    public void goHeart(View view) {
//
//        //setContentView(R.layout.activity_myheart);
//        Intent lecturechant = new Intent(this, myheart.class);
//        startActivity(lecturechant);
//
//    }
//    public void goSuivi(View view) {
//        setContentView(R.layout.activity_suivi);
//    }
//    public void gofinish(View view) {
//        setContentView(R.layout.activity_results);
//    }

    //Retours à la page précédente
  //  public void goBackStart(View view) { onBackPressed(); }
  //  public void goBackHeart(View view) {onBackPressed();}
}