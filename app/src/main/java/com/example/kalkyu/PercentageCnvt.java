package com.example.kalkyu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PercentageCnvt extends AppCompatActivity {

    private TextView OutputUnit, Unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.percentage_cnvt);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle("Percentage Calculator");
        ab.setDisplayHomeAsUpEnabled(true);

        //Calculation
        Button button_Calculate = findViewById(R.id.button_Calculate);
        button_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText percentInput = (EditText) findViewById(R.id.percentInput);
                Double userInput = Double.parseDouble(percentInput.getText().toString());
                EditText numberInput = (EditText) findViewById(R.id.numberInput);
                Double userInput2 = Double.parseDouble(numberInput.getText().toString());

                double answer = userInput2 * (userInput / 100);

                TextView textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);
                textViewAnswer.setText(String.valueOf(answer));
            }
        });
    }
}
