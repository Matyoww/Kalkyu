package com.example.kalkyu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class BasicCalc extends AppCompatActivity {

    private Button one_btn;
    private Button two_btn;
    private Button three_btn;
    private Button four_btn;
    private Button five_btn;
    private Button six_btn;
    private Button seven_btn;
    private Button eight_btn;
    private Button nine_btn;
    private Button zero_btn;
    private Button plus_btn;
    private Button minus_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;
    private Button clear_btn;
    private TextView result;
    private TextView info;
    String equation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calc);

        CalcView();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle("Basic Calculator");
        ab.setDisplayHomeAsUpEnabled(true);

        equal_btn.setOnClickListener(view -> {
            Double ans = null;
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

            try {
                ans = (double)engine.eval(equation);
            } catch (ScriptException e) {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }

            if(ans != null)
                result.setText(String.valueOf(ans.doubleValue()));
        });

        clear_btn.setOnClickListener(view -> {
            info.setText("");
            equation = "";
            result.setText("");
        });

        zero_btn.setOnClickListener(view -> {
            equation = equation + "0";
            info.setText(String.format("%s0", info.getText().toString()));
        });
        one_btn.setOnClickListener(view -> {
            equation = equation + "1";
            info.setText(String.format("%s1", info.getText().toString()));
        });
        two_btn.setOnClickListener(view -> {
            equation = equation + "2";
            info.setText(String.format("%s2", info.getText().toString()));
        });
        three_btn.setOnClickListener(view -> {
            equation = equation + "3";
            info.setText(String.format("%s3", info.getText().toString()));
        });
        four_btn.setOnClickListener(view -> {
            equation = equation + "4";
            info.setText(String.format("%s4", info.getText().toString()));
        });
        five_btn.setOnClickListener(view -> {
            equation = equation + "5";
            info.setText(String.format("%s5", info.getText().toString()));
        });
        six_btn.setOnClickListener(view -> {
            equation = equation + "6";
            info.setText(String.format("%s6", info.getText().toString()));
        });
        seven_btn.setOnClickListener(view -> {
            equation = equation + "7";
            info.setText(String.format("%s7", info.getText().toString()));
        });
        eight_btn.setOnClickListener(view -> {
            equation = equation + "8";
            info.setText(String.format("%s8", info.getText().toString()));
        });
        nine_btn.setOnClickListener(view -> {
            equation = equation + "9";
            info.setText(String.format("%s9", info.getText().toString()));
        });
        plus_btn.setOnClickListener(view -> {
            equation = equation + "+";
            info.setText(String.format("%s+", info.getText().toString()));
        });
        minus_btn.setOnClickListener(view -> {
            equation = equation + "-";
            info.setText(String.format("%s-", info.getText().toString()));
        });
        multiply_btn.setOnClickListener(view -> {
            equation = equation + "*";
            info.setText(String.format("%s*", info.getText().toString()));
        });
        divide_btn.setOnClickListener(view -> {
            equation = equation + "/";
            info.setText(String.format("%s/", info.getText().toString()));
        });
    }

    private void CalcView() {
        one_btn = (Button)findViewById(R.id.btn_1);
        two_btn = (Button)findViewById(R.id.btn_2);
        three_btn = (Button)findViewById(R.id.btn_3);
        four_btn = (Button)findViewById(R.id.btn_4);
        five_btn = (Button)findViewById(R.id.btn_5);
        six_btn = (Button)findViewById(R.id.btn_6);
        seven_btn = (Button)findViewById(R.id.btn_7);
        eight_btn = (Button)findViewById(R.id.btn_8);
        nine_btn = (Button)findViewById(R.id.btn_9);
        zero_btn = (Button)findViewById(R.id.btn_0);
        plus_btn = (Button)findViewById(R.id.btn_plus);
        minus_btn = (Button)findViewById(R.id.btn_minus);
        multiply_btn = (Button)findViewById(R.id.btn_multiply);
        divide_btn = (Button)findViewById(R.id.btn_divide);
        equal_btn = (Button)findViewById(R.id.btn_equal);
        clear_btn = (Button)findViewById(R.id.btn_clear);
        result = (TextView)findViewById(R.id.result);
        info = (TextView)findViewById(R.id.info);
    }
}