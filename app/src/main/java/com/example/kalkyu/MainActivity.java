package com.example.kalkyu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button calculator_btn;
    private Button speed_btn;
    private Button time_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator_btn = (Button) findViewById(R.id.calculator_btn);
        calculator_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalc();
            }
        });

        speed_btn = (Button) findViewById(R.id.speed_btn);
        speed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSpeedCnvt();
            }
        });

        time_btn = (Button) findViewById(R.id.time_btn);
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimeConvert();
            }
        });
    }

    public void openCalc(){
        Intent changeView = new Intent(this, BasicCalc.class);
        startActivity(changeView);
    }
    public void openSpeedCnvt(){
        Intent changeView = new Intent(this, SpeedCnvt.class);
        startActivity(changeView);
    }
    public void openTimeConvert(){
        Intent changeView = new Intent(this, TimeConvert.class);
        startActivity(changeView);
    }

}