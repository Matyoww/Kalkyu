package com.example.kalkyu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button
            calculator_btn,
            speed_btn,
            length_btn,
            weight_btn,
            volume_btn;

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

        length_btn = (Button) findViewById(R.id.length_btn);
        length_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLengthCnvt();
            }
        });

        weight_btn = (Button) findViewById(R.id.weight_btn);
        weight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeightCnvt();
            }
        });

        volume_btn = (Button) findViewById(R.id.volume_btn);
        volume_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVolumeCnvt();
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
    public void openLengthCnvt(){
        Intent changeView = new Intent(this, LengthCnvt.class);
        startActivity(changeView);
    }
    public void openWeightCnvt(){
        Intent changeView = new Intent(this, WeightCnvt.class);
        startActivity(changeView);
    }
    public void openVolumeCnvt(){
        Intent changeView = new Intent(this, VolumeCnvt.class);
        startActivity(changeView);
    }

}