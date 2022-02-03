package com.example.kalkyu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button calculator_btn;
    private Button speed_btn;
    private Button length_btn,
            weight_btn,
            volume_btn;
    private Button time_btn;
    private Button percentage_btn;
    private Button basenumber_btn;

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

        time_btn = (Button) findViewById(R.id.time_btn);
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimeCnvt();
            }
        });

        percentage_btn = (Button) findViewById(R.id.percentage_btn);
        percentage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPercentageCnvt();
            }
        });

        basenumber_btn = (Button) findViewById(R.id.basenumber_btn);
        basenumber_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBaseNumberCnvt();
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
    public void openTimeCnvt(){
        Intent changeView = new Intent(this, TimeConvert.class);
        startActivity(changeView);
    }
    public void openPercentageCnvt(){
        Intent changeView = new Intent(this, PercentageCnvt.class);
        startActivity(changeView);
    }

    public void openBaseNumberCnvt(){
        Intent changeView = new Intent(this,BaseNumberCnvt.class);
        startActivity(changeView);
    }

}