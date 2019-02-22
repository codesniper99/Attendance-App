package com.akhilvaid21gmail.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Hope you enjoy this!", Toast.LENGTH_SHORT).show();

        Button button=(Button) findViewById(R.id.moveOnButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToSecondActivity();

            }
        });

    }

private void goToSecondActivity()
{

    Toast.makeText(this, "And here we go!", Toast.LENGTH_SHORT).show();
    Intent intent=new Intent(this,Subjects.class);

    startActivity(intent);
}


}
