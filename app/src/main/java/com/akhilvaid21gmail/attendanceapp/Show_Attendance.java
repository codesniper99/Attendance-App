package com.akhilvaid21gmail.attendanceapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Show_Attendance extends AppCompatActivity {


    TextView attendanceData;
    Button updateButtonn;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__attendance);
        Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");
        attendanceData = (TextView) findViewById(R.id.attendanceData);
        updateButtonn=(Button)findViewById(R.id.updateButtonn);
        SharedPreferences sharedPreferences  = getSharedPreferences(message.toString(), Context.MODE_PRIVATE);
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
            attendanceData.setText("Subject = "+name + "\n\nDays Present = "+ pdays  + "\n\nDays Absent = "+ adays +"\n\nTotal Days = "+tdays+"\n\nPercentage = "+ percent +" %");

        }

    }


    public void updateButtonClicked(View view)
    {
        Intent intent=new Intent(this,Update.class);
        intent.putExtra("message", message);
        finish();
        startActivity(intent);

    }

}
