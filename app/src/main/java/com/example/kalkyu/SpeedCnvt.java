package com.example.kalkyu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.DecimalFormat;

public class SpeedCnvt extends AppCompatActivity {

    private static final DecimalFormat df = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle("Speed Converter");
        ab.setDisplayHomeAsUpEnabled(true);

        // Dropdown speed metric unit
        Spinner spinner = (Spinner) findViewById(R.id.spinner_speed1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Speed_Unit, R.layout.dropdown_selected_item);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_speed2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Speed_Unit, R.layout.dropdown_selected_item);
        adapter2.setDropDownViewResource(R.layout.dropdown_item);
        spinner2.setAdapter(adapter);

        //Conversion
        Button btn_SpeedCnvt = findViewById(R.id.btn_speedConvert);
        btn_SpeedCnvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit1 = spinner.getSelectedItem().toString();
                String unit2 = spinner2.getSelectedItem().toString();

                TextView OutputUnit = (TextView)findViewById(R.id.txtViewUnit);
                TextView SpeedUnit = (TextView)findViewById(R.id.txtViewUnit2);
                EditText inputUnit = (EditText)findViewById(R.id.txt_input);
                Double Input = null;
                Double Output = null;

                try{
                    Input=Double.parseDouble(inputUnit.getText().toString());
                    if(Input==null){
                        Toast.makeText(getApplicationContext(), "Invalid! Conversion cannot be done.", Toast.LENGTH_SHORT).show();
                    }

                    switch (unit1){
                        case "Miles per hour":
                            switch (unit2) {
                                case "Feet per second":
                                    Output = Input * 1.46667;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("fps");
                                    break;
                                case "Meters per second":
                                    Output = Input * 0.447039;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("mps");
                                    break;
                                case "Kilometers per hour":
                                    Output = Input * 1.60934;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("kph");
                                    break;
                                case "Knot":
                                    Output = Input * 0.868976;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("kn");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "Feet per second":
                            switch (unit2) {
                                case "Miles per hour":
                                    Output = Input * 0.681817;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("mph");
                                    break;
                                case "Meters per second":
                                    Output = Input * 0.3048;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("mps");
                                    break;
                                case "Kilometers per hour":
                                    Output = Input * 1.09728;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("kph");
                                    break;
                                case "Knot":
                                    Output = Input * 0.592484;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("kn");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "Meters per second":
                            switch (unit2) {
                                case "Miles per hour":
                                    Output = Input * 2.23694;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("mph");
                                    break;
                                case "Feet per second":
                                    Output = Input * 3.28084;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("fps");
                                    break;
                                case "Kilometers per hour":
                                    Output = Input * 3.6;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("kph");
                                    break;
                                case "Knot":
                                    Output = Input * 1.94384;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("kn");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "Kilometers per hour":
                            switch (unit2) {
                                case "Miles per hour":
                                    Output = Input * 0.621373;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("mph");
                                    break;
                                case "Meters per second":
                                    Output = Input * 0.277778;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("mps");
                                    break;
                                case "Feet per second":
                                    Output = Input * 0.911344;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("fps");
                                    break;
                                case "Knot":
                                    Output = Input * 0.539957;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("kn");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "Knot":
                            switch (unit2) {
                                case "Miles per hour":
                                    Output = Input * 1.15078;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("mph");
                                    break;
                                case "Meters per second":
                                    Output = Input * 0.514446;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("mps");
                                    break;
                                case "Kilometers per hour":
                                    Output = Input * 1.852;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("kph");
                                    break;
                                case "Feet per second":
                                    Output = Input * 1.68781;
                                    OutputUnit.setText(String.valueOf(df.format(Output)));
                                    SpeedUnit.setText("fps");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        default: Toast.makeText(getApplicationContext(), "Please input speed unit value", Toast.LENGTH_SHORT).show();

                            }
                    }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                }
                }
        });

    }
}

