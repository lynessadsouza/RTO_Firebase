package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button vehicle_reg;
    Button learn_lic;
    Button signals;
    Button feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        vehicle_reg=findViewById(R.id.button3);
        learn_lic=findViewById(R.id.button4);
        signals=findViewById(R.id.button7);
        feed=findViewById(R.id.button8);



        vehicle_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu.this,vehicle_registration.class);
                startActivity(i);
            }
        });

        learn_lic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu.this,learners_licence_screen.class);
                startActivity(i);
            }
        });

        signals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu.this,Signs.class);
                startActivity(i);
            }
        });

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu.this,feedback.class);
                startActivity(i);
            }
        });

    }
}
