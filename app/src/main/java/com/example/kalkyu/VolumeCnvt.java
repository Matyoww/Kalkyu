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

public class VolumeCnvt extends AppCompatActivity {

    private TextView OutputUnit, Unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_cnvt);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle("Volume Converter");
        ab.setDisplayHomeAsUpEnabled(true);

        // Dropdown metric unit
        Spinner spinner = (Spinner) findViewById(R.id.spinner_from);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Volume_Unit, R.layout.dropdown_selected_item);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_cnvtTo);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Volume_Unit, R.layout.dropdown_selected_item);
        adapter2.setDropDownViewResource(R.layout.dropdown_item);
        spinner2.setAdapter(adapter);

        //Conversion
        Button btn_VolumeCnvt = findViewById(R.id.btn_Convert);
        btn_VolumeCnvt.setOnClickListener(new View.OnClickListener() {
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
                        case "Milliliter":
                            switch (unit2){
                                case "Liter":
                                    OutputResult(Input, 0.001, "L");
                                    break;
                                case "Cup":
                                    OutputResult(Input, 0.0042267528, "Cup");
                                    break;
                                case "Pint":
                                    OutputResult(Input, 0.0021133764, "pt");
                                    break;
                                case "Gallon":
                                    OutputResult(Input, 0.0002641721, "gal");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Liter":
                            switch (unit2){
                                case "Milliliter":
                                    OutputResult(Input, 1000.0, "mL");
                                    break;
                                case "Cup":
                                    OutputResult(Input, 4.2267528377, "Cups");
                                    break;
                                case "Pint":
                                    OutputResult(Input, 2.1133764189, "pt");
                                    break;
                                case "Gallon":
                                    OutputResult(Input, 0.2641720524, "gal");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Cup":
                            switch (unit2){
                                case "Milliliter":
                                    OutputResult(Input, 236.5882365, "mL");
                                    break;
                                case "Liter":
                                    OutputResult(Input, 0.2365882365, "L");
                                    break;
                                case "Pint":
                                    OutputResult(Input, 0.5283441, "pt");
                                    break;
                                case "Gallon":
                                    OutputResult(Input, 0.066043013, "gal");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Pint":
                            switch (unit2){
                                case "Milliliter":
                                    OutputResult(Input, 473.176473, "mL");
                                    break;
                                case "Liter":
                                    OutputResult(Input, 0.473176473, "L");
                                    break;
                                case "Cup":
                                    OutputResult(Input, 2.0, "Cups");
                                    break;
                                case "Gallon":
                                    OutputResult(Input, 0.125, "gal");
                                    break;
                                default: Toast.makeText(getApplicationContext(), "Error: Same speed unit", Toast.LENGTH_SHORT).show();
                            }

                            break;
                        case "Gallon":
                            switch (unit2){
                                case "Milliliter":
                                    OutputResult(Input, 3785.411784, "mL");
                                    break;
                                case "Liter":
                                    OutputResult(Input, 3.785411784, "L");
                                    break;
                                case "Cup":
                                    OutputResult(Input, 16.0, "Cups");
                                    break;
                                case "Pint":
                                    OutputResult(Input, 8.0, "pt");
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

        DecimalFormat df = new DecimalFormat("0.####");

        OutputUnit = (TextView)findViewById(R.id.txtViewUnit);
        Unit = (TextView)findViewById(R.id.txtViewUnit2);

        Double Result = InputVal * UnitVal;
        OutputUnit.setText(String.valueOf(df.format(Result)));
        Unit.setText(UnitName);

    }

}

