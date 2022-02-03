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

public class WeightCnvt extends AppCompatActivity {

    private TextView OutputUnit, Unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_cnvt);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle("Weight Converter");
        ab.setDisplayHomeAsUpEnabled(true);

        // Dropdown speed metric unit
        Spinner spinner = (Spinner) findViewById(R.id.spinner_from);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Weight_Unit, R.layout.dropdown_selected_item);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_cnvtTo);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Weight_Unit, R.layout.dropdown_selected_item);
        adapter2.setDropDownViewResource(R.layout.dropdown_item);
        spinner2.setAdapter(adapter);

        //Conversion
        Button btn_WeightCnvt = findViewById(R.id.btn_Convert);
        btn_WeightCnvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit1 = spinner.getSelectedItem().toString();
                String unit2 = spinner2.getSelectedItem().toString();

                EditText inputUnit = (EditText)findViewById(R.id.txt_input);
                Double Input = null;

                try{
                    Input=Double.parseDouble(inputUnit.getText().toString());
                    if(Input==null){
                        Toast.makeText(getApplicationContext(), "Invalid! Conversion cannot be done.", Toast.LENGTH_SHORT).show();
                    }

                    switch (unit1){
                        case "Milligram":
                            switch (unit2){
                                case "Gram":
                                    OutputResult(Input, 0.001, "g");
                                    break;
                                case "Kilogram":
                                    OutputResult(Input, 0.000001, "kg");
                                    break;
                                case "Ounce":
                                    OutputResult(Input, 0.000035274, "oz");
                                    break;
                                case "Pound":
                                    OutputResult(Input, 0.0000022046, "lb");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Gram":
                            switch (unit2){
                                case "Milligram":
                                    OutputResult(Input, 1000.0, "mg");
                                    break;
                                case "Kilogram":
                                    OutputResult(Input, 0.001, "kg");
                                    break;
                                case "Ounce":
                                    OutputResult(Input, 0.035274, "oz");
                                    break;
                                case "Pound":
                                    OutputResult(Input, 0.00220462, "lb");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Kilogram":
                            switch (unit2){
                                case "Milligram":
                                    OutputResult(Input, 1000000.0, "mg");
                                    break;
                                case "Gram":
                                    OutputResult(Input, 1000.0, "g");
                                    break;
                                case "Ounce":
                                    OutputResult(Input, 35.27396195, "oz");
                                    break;
                                case "Pound":
                                    OutputResult(Input, 2.20462, "lb");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Ounce":
                            switch (unit2){
                                case "Milligram":
                                    OutputResult(Input, 28349.523125, "mg");
                                    break;
                                case "Gram":
                                    OutputResult(Input, 28.349523125, "g");
                                    break;
                                case "Kilogram":
                                    OutputResult(Input, 0.0283495231, "kg");
                                    break;
                                case "Pound":
                                    OutputResult(Input, 0.0625, "lb");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Pound":
                            switch (unit2){
                                case "Milligram":
                                    OutputResult(Input, 453592.37, "mg");
                                    break;
                                case "Gram":
                                    OutputResult(Input, 453.59237, "g");
                                    break;
                                case "Kilogram":
                                    OutputResult(Input, 0.45359237, "kg");
                                    break;
                                case "Ounce":
                                    OutputResult(Input, 16.0, "oz");
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

        DecimalFormat df = new DecimalFormat("0.######");

        OutputUnit = (TextView)findViewById(R.id.txtViewUnit);
        Unit = (TextView)findViewById(R.id.txtViewUnit2);

        Double Result = InputVal * UnitVal;
        OutputUnit.setText(String.valueOf(df.format(Result)));
        Unit.setText(UnitName);

    }

}
