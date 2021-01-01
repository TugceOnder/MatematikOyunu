package com.company.matatematikoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView result;
    Button again;
    Button exit;
    int scor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result=(TextView) findViewById(R.id.textViewresult);
        again=(Button) findViewById(R.id.buttonAgain);
        exit=(Button) findViewById(R.id.buttonexit);
        Intent intent = getIntent();
        scor=intent.getIntExtra("score",0);
        String userScore= String.valueOf(scor);
        result.setText("YOUR SCORE"+userScore);


        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Result.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}