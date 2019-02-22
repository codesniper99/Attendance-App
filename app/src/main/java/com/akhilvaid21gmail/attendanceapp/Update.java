package com.akhilvaid21gmail.attendanceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    EditText daysPresent,daysAbsent;
    String message="Nothing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");


        daysPresent=  (EditText)findViewById(R.id.pDays);
        daysAbsent=(EditText)findViewById(R.id.aDays);






    }

    public void updateClicked(View view)
    {

        SharedPreferences sharedPreferences=getSharedPreferences(message, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        int presentDays = Integer.parseInt(daysPresent.getText().toString());
        int absentDays = Integer.parseInt(daysAbsent.getText().toString());
        if(presentDays==0 && absentDays == 0)
        {
            Toast.makeText(this, "Too smart ,eh? ;) Both Can't be zero", Toast.LENGTH_SHORT).show();
            finish();

        }

        float percentage=((float)presentDays/(float)(absentDays+presentDays))*100;

        editor.putString("Subject",message.toString());
        editor.putInt("Days Present",presentDays);
        editor.putInt("Days Absent",absentDays);
        editor.putFloat("Percentage",percentage);
        editor.commit();

        Toast.makeText(this, "Subject Data updated", Toast.LENGTH_SHORT).show();
        finish();
    }




}
