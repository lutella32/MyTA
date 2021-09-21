package com.example.myta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        final EditText edit1= (EditText) findViewById(R.id.textinput);
      // EditText text = (EditText) edit1.getText();
      // String n=text.toString();
     //  if(n.equals("")){
            Log.d("start","h");
            Context context = getApplicationContext();
            CharSequence textToast = "You need to enter name";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, textToast, duration);
            toast.show();
       // }
     // else{
        setContentView(R.layout.activity_starting);
    //}
    }

}