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

public class LengthCnvt extends AppCompatActivity {


    private TextView OutputUnit, Unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_cnvt);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle("Length Converter");
        ab.setDisplayHomeAsUpEnabled(true);

        // Dropdown speed metric unit
        Spinner spinner = (Spinner) findViewById(R.id.spinner_from);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Length_Unit, R.layout.dropdown_selected_item);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_cnvtTo);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Length_Unit, R.layout.dropdown_selected_item);
        adapter2.setDropDownViewResource(R.layout.dropdown_item);
        spinner2.setAdapter(adapter);

        //Conversion
        Button btn_SpeedCnvt = findViewById(R.id.btn_Convert);
        btn_SpeedCnvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit1 = spinner.getSelectedItem().toString();
                String unit2 = spinner2.getSelectedItem().toString();

                EditText inputUnit = (EditText)findViewById(R.id.txt_input);
                Double Input = null;
                Double Output = null;

                try{
                    Input=Double.parseDouble(inputUnit.getText().toString());
                    if(Input==null){
                        Toast.makeText(getApplicationContext(), "Invalid! Conversion cannot be done.", Toast.LENGTH_SHORT).show();
                    }

                    switch (unit1){
                        case "Millimeter":
                            switch (unit2){
                                case "Centimeter":
                                    OutputResult(Input, 0.1, "cm");
                                    break;
                                case "Meter":
                                    OutputResult(Input, 0.001, "m");
                                    break;
                                case "Kilometer":
                                    OutputResult(Input, 0.000001, "km");
                                    break;
                                case "Inch":
                                    OutputResult(Input, 0.03937, "in");
                                    break;
                                case "Foot":
                                    OutputResult(Input, 0.003281, "ft");
                                    break;
                                case "Yard":
                                    OutputResult(Input, 0.0010936, "yd");
                                    break;
                                case "Mile":
                                    OutputResult(Input, 0.0000006214, "mi");
                                    break;
                                case "Nautical Mile":
                                    OutputResult(Input, 0.00000054, "nmi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Centimeter":
                            switch (unit2){
                                case "Millimeter":
                                    OutputResult(Input, 10.0, "mm");
                                    break;
                                case "Meter":
                                    OutputResult(Input, 0.01, "m");
                                    break;
                                case "Kilometer":
                                    OutputResult(Input, 0.00001, "km");
                                    break;
                                case "Inch":
                                    OutputResult(Input, 0.3937, "in");
                                    break;
                                case "Foot":
                                    OutputResult(Input, 0.03281, "ft");
                                    break;
                                case "Yard":
                                    OutputResult(Input, 0.010936, "yd");
                                    break;
                                case "Mile":
                                    OutputResult(Input, 0.000006214, "mi");
                                    break;
                                case "Nautical Mile":
                                    OutputResult(Input, 0.0000054, "nmi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Meter":
                            switch (unit2){
                                case "Millimeter":
                                    OutputResult(Input, 1000.0, "mm");
                                    break;
                                case "Centimeter":
                                    OutputResult(Input, 100.0, "cm");
                                    break;
                                case "Kilometer":
                                    OutputResult(Input, 0.001, "km");
                                    break;
                                case "Inch":
                                    OutputResult(Input, 39.37, "in");
                                    break;
                                case "Foot":
                                    OutputResult(Input, 3.281, "ft");
                                    break;
                                case "Yard":
                                    OutputResult(Input, 1.0936, "yd");
                                    break;
                                case "Mile":
                                    OutputResult(Input, 0.0006214, "mi");
                                    break;
                                case "Nautical Mile":
                                    OutputResult(Input, 0.00054, "nmi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Kilometer":
                            switch (unit2){
                                case "Millimeter":
                                    OutputResult(Input, 1000000.0, "mm");
                                    break;
                                case "Centimeter":
                                    OutputResult(Input, 100000.0, "cm");
                                    break;
                                case "Meter":
                                    OutputResult(Input, 1000.0, "m");
                                    break;
                                case "Inch":
                                    OutputResult(Input, 39370.0, "in");
                                    break;
                                case "Foot":
                                    OutputResult(Input, 3281.0, "ft");
                                    break;
                                case "Yard":
                                    OutputResult(Input, 1093.6, "yd");
                                    break;
                                case "Mile":
                                    OutputResult(Input, 0.6214, "mi");
                                    break;
                                case "Nautical Mile":
                                    OutputResult(Input, 0.54, "nmi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Inch":
                            switch (unit2){
                                case "Millimeter":
                                    OutputResult(Input, 25.4, "mm");
                                    break;
                                case "Centimeter":
                                    OutputResult(Input, 2.54, "cm");
                                    break;
                                case "Meter":
                                    OutputResult(Input, 0.0254, "m");
                                    break;
                                case "Kilometer":
                                    OutputResult(Input, 0.0000254, "km");
                                    break;
                                case "Foot":
                                    OutputResult(Input, 0.08333, "ft");
                                    break;
                                case "Yard":
                                    OutputResult(Input, 0.02778, "yd");
                                    break;
                                case "Mile":
                                    OutputResult(Input, 0.000015783, "mi");
                                    break;
                                case "Nautical Mile":
                                    OutputResult(Input, 0.000013715, "nmi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Foot":
                            switch (unit2){
                                case "Millimeter":
                                    OutputResult(Input, 304.8, "mm");
                                    break;
                                case "Centimeter":
                                    OutputResult(Input, 30.48, "cm");
                                    break;
                                case "Meter":
                                    OutputResult(Input, 0.3048, "m");
                                    break;
                                case "Kilometer":
                                    OutputResult(Input, 0.0003048, "km");
                                    break;
                                case "Inch":
                                    OutputResult(Input, 12.0, "in");
                                    break;
                                case "Yard":
                                    OutputResult(Input, 0.33333, "yd");
                                    break;
                                case "Mile":
                                    OutputResult(Input, 0.0001894, "mi");
                                    break;
                                case "Nautical Mile":
                                    OutputResult(Input, 0.00016458, "nmi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Yard":
                            switch (unit2){
                                case "Millimeter":
                                    OutputResult(Input, 914.4, "mm");
                                    break;
                                case "Centimeter":
                                    OutputResult(Input, 91.44, "cm");
                                    break;
                                case "Meter":
                                    OutputResult(Input, 0.9144, "m");
                                    break;
                                case "Kilometer":
                                    OutputResult(Input, 0.0009144, "km");
                                    break;
                                case "Inch":
                                    OutputResult(Input, 36.0, "in");
                                    break;
                                case "Foot":
                                    OutputResult(Input, 3.0, "ft");
                                    break;
                                case "Mile":
                                    OutputResult(Input, 0.0005682, "mi");
                                    break;
                                case "Nautical Mile":
                                    OutputResult(Input, 0.0004937, "nmi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Mile":
                            switch (unit2){
                                case "Millimeter":
                                    OutputResult(Input, 1609344.0, "mm");
                                    break;
                                case "Centimeter":
                                    OutputResult(Input, 160934.4, "cm");
                                    break;
                                case "Meter":
                                    OutputResult(Input, 1609.3, "m");
                                    break;
                                case "Kilometer":
                                    OutputResult(Input, 1.6093, "km");
                                    break;
                                case "Inch":
                                    OutputResult(Input, 63360.0, "in");
                                    break;
                                case "Foot":
                                    OutputResult(Input, 5280.0, "ft");
                                    break;
                                case "Yard":
                                    OutputResult(Input, 1760.0, "yd");
                                    break;
                                case "Nautical Mile":
                                    OutputResult(Input, 0.869, "nmi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Nautical Mile":
                            switch (unit2){
                                case "Millimeter":
                                    OutputResult(Input, 1852000.0, "mm");
                                    break;
                                case "Centimeter":
                                    OutputResult(Input, 185200.0, "cm");
                                    break;
                                case "Meter":
                                    OutputResult(Input, 1852.0, "m");
                                    break;
                                case "Kilometer":
                                    OutputResult(Input, 1.852, "km");
                                    break;
                                case "Inch":
                                    OutputResult(Input, 72913.0, "in");
                                    break;
                                case "Foot":
                                    OutputResult(Input, 6076.0, "ft");
                                    break;
                                case "Yard":
                                    OutputResult(Input, 2025.4, "yd");
                                    break;
                                case "Mile":
                                    OutputResult(Input, 1.1508, "mi");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
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

    public void OutputResult(Double InputVal, Double UnitVal, String UnitName){

        DecimalFormat df = new DecimalFormat("0.#######");

        OutputUnit = (TextView)findViewById(R.id.txtViewUnit);
        Unit = (TextView)findViewById(R.id.txtViewUnit2);

        Double Result = InputVal * UnitVal;
        OutputUnit.setText(String.valueOf(df.format(Result)));
        Unit.setText(UnitName);

    }

}
