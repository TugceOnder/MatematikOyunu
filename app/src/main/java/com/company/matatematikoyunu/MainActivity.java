package com.company.matatematikoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  Button toplama;
  Button cikarma;
  Button carpma;
  Button bolme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toplama=(Button) findViewById(R.id.buttontoplama);
        cikarma=(Button) findViewById(R.id.buttoncikarma);
        carpma=(Button) findViewById(R.id.buttoncarpma);
        bolme=(Button) findViewById(R.id.buttonbolme);

        toplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,game.class);
                startActivity(intent);
                finish();
            }
        });


        bolme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,gamefour.class);
                startActivity(intent);
                finish();
            }
        });

        cikarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,gametwo.class);
                startActivity(intent);
                finish();
            }
        });


        carpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,gamethree.class);
                startActivity(intent);
                finish();
            }
        });
    }
}