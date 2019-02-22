package com.akhilvaid21gmail.attendanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {



    EditText Input;
    TextView myText;
    EditText daysPresent,daysAbsent;


    public static final String DEFAULT="N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");


        Input=(EditText)findViewById(R.id.inputText);
        daysPresent=  (EditText)findViewById(R.id.daysPresent);
        daysAbsent=(EditText)findViewById(R.id.daysAbsent);
        myText= (TextView) findViewById(R.id.displayText);


    }
    //Print Database

    public void addButtonClicked(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences(Input.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        int presentDays = Integer.parseInt(daysPresent.getText().toString());
        int absentDays = Integer.parseInt(daysAbsent.getText().toString());
        float percentage=((float)presentDays/(float)(absentDays+presentDays))*100;

        editor.putString("Subject",Input.getText().toString());
        editor.putInt("Days Present",presentDays);
        editor.putInt("Days Absent",absentDays);
        editor.putFloat("Percentage",percentage);


        editor.commit();

        Toast.makeText(this, "Subject Data updated", Toast.LENGTH_SHORT).show();
        
    }
    //delete
    public void deleteButtonClicked(View view)
    {
        SharedPreferences sharedPreferences  = getSharedPreferences(Input.getText().toString(),Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Subject","DEFAULT");
        int pdays=sharedPreferences.getInt("Days Present",0);

        int adays=sharedPreferences.getInt("Days Absent",0);
        float percent=sharedPreferences.getFloat("Percentage", (float) 0.0);
        int tdays=adays+pdays;

        if(name.equals("DEFAULT"))
        {
            Toast.makeText(this, "Default data loaded", Toast.LENGTH_SHORT).show();

        }
else
        {
            Toast.makeText(this, "Subject "+name+" data loaded Successfully", Toast.LENGTH_SHORT).show();
            myText.setText("Subject = "+name + "\n\nDays Present = "+ pdays  + "\n\nDays Absent = "+ adays +"\n\nTotal Days = "+tdays+"\n\nPercentage = "+ percent +" %");

        }
    }

}
