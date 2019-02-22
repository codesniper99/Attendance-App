package com.akhilvaid21gmail.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Subjects extends AppCompatActivity {

    String message="Nothing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        int flag=1;



        Button button4=(Button) findViewById(R.id.mathematicsButton);
        button4.setOnClickListener(

                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message="Mathematics";
                goToThirdActivity();

            }
        });


        Button button5=(Button) findViewById(R.id.dataStructuresButton);
        button5.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message="Data Structures";
                goToThirdActivity();

            }
        });


        Button button6=(Button) findViewById(R.id.discreteMathsButton);
        button6.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message="Discrete Maths";

                goToThirdActivity();

            }
        });


        Button button7=(Button) findViewById(R.id.englishButton);
        button7.setOnClickListener(

                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message="English";
                goToThirdActivity();

            }
        });


        Button button8=(Button) findViewById(R.id.electiveButton);
        button8.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message="Elective";goToThirdActivity();

            }
        });


        Button button9=(Button) findViewById(R.id.digitalLogicDesignButton);
        button9.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message="Digital Logic Design";
                goToThirdActivity();

            }
        });

    }


    private void goToThirdActivity()
    {
        Intent intent=new Intent(this,Show_Attendance.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }

}
