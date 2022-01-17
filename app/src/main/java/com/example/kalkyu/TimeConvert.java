package com.example.kalkyu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TimeConvert extends AppCompatActivity {

    private static final DecimalFormat df = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_convert);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle("Time Converter");
        ab.setDisplayHomeAsUpEnabled(true);

        // dropdown menu

        Spinner timeSpinner_1 = (Spinner) findViewById(R.id.timeSpinner_1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Time_Unit, R.layout.dropdown_selected_item);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        timeSpinner_1.setAdapter(adapter);

        Spinner timeSpinner_2 = (Spinner) findViewById(R.id.timeSpinner_2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Time_Unit, R.layout.dropdown_selected_item);
        adapter2.setDropDownViewResource(R.layout.dropdown_item);
        timeSpinner_2.setAdapter(adapter);

        // time conversions
        Button convert_btn = findViewById(R.id.convert_btn);
        convert_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String spin1 = timeSpinner_1.getSelectedItem().toString();
                String spin2 = timeSpinner_2.getSelectedItem().toString();


                TextView answer = (TextView) findViewById(R.id.answer);
                TextView longAnswer = (TextView) findViewById(R.id.longAnswer);
                EditText time = (EditText) findViewById(R.id.time);
                Double input = null;
                Double output = null;

                try {
                    input = Double.parseDouble(time.getText().toString());
                    if (input == null) {
                        Toast.makeText(getApplicationContext(), "Invalid! Conversion cannot be done.", Toast.LENGTH_SHORT).show();
                    }

                    switch (spin1) {
                        case "Second":
                            switch (spin2) {
                                case "Minute":
                                    output = input / 60;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " seconds * (1 minute / 60 seconds) = " + (df.format(output)) + " minute/s");
                                    break;
                                case "Hour":
                                    output = input / 3600;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " seconds * (1 minute / 60 seconds) * (1 hour / 60 minutes) = " + (df.format(output)) + " hour/s");
                                    break;
                                case "Day":
                                    output = input / 86400;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " seconds * (1 minute / 60 seconds) * (1 hour / 60 minutes) * (1 day / 24 hours) = " + (df.format(output)) + " day/s");
                                    break;
                                case "Week":
                                    output = input / 604800;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " seconds * (1 minute / 60 seconds) * (1 hour / 60 minutes) * (1 day / 24 hours) * (1 week / 7 days)  = " + (df.format(output)) + " week/s");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same time unit", Toast.LENGTH_SHORT).show();
                            }
                            break;

                        case "Minute":
                            switch (spin2) {
                                case "Second":
                                    output = input * 60;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " minutes * (60 seconds / 1 minute) = " + (df.format(output)) + " second/s");
                                    break;
                                case "Hour":
                                    output = input / 60;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " minutes * (1 hour / 60 minutes) = " + (df.format(output)) + " hour/s");
                                    break;
                                case "Day":
                                    output = input / 1440;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " minutes * (1 hour / 60 minutes) * (1 day / 24 hours) = " + (df.format(output)) + " day/s");
                                    break;
                                case "Week":
                                    output = input / 10080;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " minutes * (1 hour / 60 minutes) * (1 day / 24 hours) * (1 week / 7  days) = " + (df.format(output)) + " second/s");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same time unit", Toast.LENGTH_SHORT).show();
                            }
                            break;

                        case "Hour":
                            switch (spin2) {
                                case "Second":
                                    output = input * 3600;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " hours * (60 minutes / 1 hour) * (60 seconds / 1 minute) = " + (df.format(output)) + " second/s");
                                    break;
                                case "Minute":
                                    output = input * 60;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " hours * (60 minutes / 1 hour) = " + (df.format(output)) + " minute/s");
                                    break;
                                case "Day":
                                    output = input / 24;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " hours * (1 day / 24 hours) = " + (df.format(output)) + " day/s");
                                    break;
                                case "Week":
                                    output = input / 168;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " hours * (1 day / 24 hours) * (1 week / 7 days) = " + (df.format(output)) + " week/s");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same time unit", Toast.LENGTH_SHORT).show();
                            }
                            break;

                        case "Day":
                            switch (spin2) {
                                case "Second":
                                    output = input * 86400;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " day/s * (24 hours / 1 day) * (60 minutes / 1 hour) * (60 seconds / 1 minute) = " + (df.format(output)) + " seconds");
                                    break;
                                case "Minute":
                                    output = input * 1440;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " day/s * (24 hours / 1 day) * (60 minutes / 1 hour) = " + (df.format(output)) + " minutes");
                                    break;
                                case "Hour":
                                    output = input * 24;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " day/s * (24 hours / 1 day) = " + (df.format(output)) + " hours");
                                    break;
                                case "Week":
                                    output = input / 7;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " day/s * (1 week / 7 days) = " + (df.format(output)) + " week/s");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same time unit", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "Week":
                            switch (spin2) {
                                case "Second":
                                    output = input * 604800;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " week/s * (7 days / 1 week) * (24 hours / 1 day) * (60 minutes / 1 hour) * (60 seconds / 1 minute) = " + (df.format(output)) + " seconds");
                                    break;
                                case "Minute":
                                    output = input * 10080;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " week/s * (7 days / 1 week)  * (24 hours / 1 day) * (60 minutes / 1 hour) = " + (df.format(output)) + " minutes");
                                    break;
                                case "Hour":
                                    output = input * 168;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " week/s * (7 days / 1 week)  * (24 hours / 1 day) = " + (df.format(output)) + " hours");
                                    break;
                                case "Day":
                                    output = input * 7;
                                    answer.setText(String.valueOf(df.format(output)));
                                    longAnswer.setText(input + " week/s * (7 days / 1 week) = " + (df.format(output)) + " days");
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "Error: Same time unit", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "Please input time value", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}