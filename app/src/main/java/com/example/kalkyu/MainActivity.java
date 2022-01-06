package com.example.kalkyu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button calculator_btn;

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
    }

    public void openCalc(){
        Intent changeView = new Intent(this, BasicCalc.class);
        startActivity(changeView);
    }
}