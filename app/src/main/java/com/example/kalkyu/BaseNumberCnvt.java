package com.example.kalkyu;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Stack;
import java.util.regex.Pattern;

public class BaseNumberCnvt extends AppCompatActivity {

    private EditText editTextDecimal;
    private EditText editTextBinary;
    private EditText editTextOctal;
    private EditText editTextHexa;
    private Button  buttonClear;

    private TextWatcher textWatcher;
    private String value;
    private View.OnFocusChangeListener onFocusChangeListener;
    private int focusedViewId;
    private TextView editText_hex;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_number_converter);

        editTextDecimal = (EditText) findViewById(R.id.etvDecimal);
        editTextBinary =  (EditText) findViewById(R.id.etvBinary);
        editTextOctal =   (EditText) findViewById(R.id.etvOctal);
        editTextHexa =    (EditText) findViewById(R.id.etvHexa);

        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(v -> clearFields());

        Toolbar myToolbar = findViewById(R.id.my_toolbar2);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle("Base Number Converter");
        ab.setDisplayHomeAsUpEnabled(true);

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                value = ((EditText)findViewById(focusedViewId)).getText().toString().trim();

                if(value.length()> 0){
                    convertNumber();
                }
//                calculate(2,editTextBinary);        // for base 2 (binary)
//                calculate(8,editTextOctal);        // for base 8 (octal)
//                calculate(16,editTextHexa);    // for base 16 (hexadecimal)
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

//            public void calculate(int base,EditText txtView)
//            {
//                if(editTextDecimal.getText().toString().trim().length()==0)
//                {
//                    txtView.setText("");
//                    return;
//                }
//                try
//                {
//                    Stack<Object> stack=new Stack<Object>();
//                    int number=Integer.parseInt(editTextDecimal.getText().toString());
//                    while (number>0)
//                    {
//                        int remainder=number%base; // find remainder
//                        if(remainder<10)
//                        // for remainder smaller than 10
//                        {
//                            stack.push(remainder);
//                            // push remainder in stack
//                        }
//                        else
//                        {
//                            switch (remainder)
//                            // for remainder larger than 9 (for hexadecimal values)
//                            {
//                                case 10:
//                                    stack.push("A");
//                                    break;
//                                case 11:
//                                    stack.push("B");
//                                    break;
//                                case 12:
//                                    stack.push("C");
//                                    break;
//                                case 13:
//                                    stack.push("D");
//                                    break;
//                                case 14:
//                                    stack.push("E");
//                                    break;
//                                case 15:
//                                    stack.push("F");
//                                    break;
//                            }
//                        }
//                        number/=base;
//                    }
//                    StringBuffer buffer=new StringBuffer();
//                    while (!stack.isEmpty())
//                    {
//                        buffer.append(stack.pop().toString());
//                    }
//                    txtView.setText(buffer.toString());
//                }
//                catch (Exception e)
//                {
//                    txtView.setText(e.getMessage());
//                }
//        };

    };

    onFocusChangeListener = new View.OnFocusChangeListener(){

        public void onFocusChange(View v,boolean hasFocus){
            if(hasFocus){

                focusedViewId =v.getId();

                ((EditText)findViewById(focusedViewId)).addTextChangedListener(textWatcher);
                Toast.makeText(getApplicationContext(),"Focus in",Toast.LENGTH_SHORT).show();
            }
            else{
                ((EditText)findViewById(focusedViewId)).removeTextChangedListener(textWatcher);
            }
        }
    };

     editTextDecimal.setOnFocusChangeListener(onFocusChangeListener);
     editTextBinary.setOnFocusChangeListener(onFocusChangeListener);
     editTextOctal.setOnFocusChangeListener(onFocusChangeListener);
     editTextHexa.setOnFocusChangeListener(onFocusChangeListener);

        editTextHexa.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void afterTextChanged(Editable s) {
                if(Pattern.compile("[^0-9A-Fa-f]").matcher(s).find()) {
                    String s2 = s.toString().replaceAll("[^0-9A-Fa-f]", "");
                    editTextHexa.setText(s2);
                    editTextHexa.setSelection(s2.length());
                }
            }
        });

}

    private void clearFields() {
        editTextBinary.setText("");
        editTextDecimal.setText("");
        editTextOctal.setText("");
        editTextHexa.setText("");
    }

    private void convertNumber(){
        try{
            long num=0;



            switch(focusedViewId){
                case R.id.etvDecimal:
                    num = Long.parseLong(value);
                    editTextBinary.setText(String.valueOf(Long.toBinaryString(num)));
                    editTextOctal.setText(String.valueOf(Long.toOctalString(num)));
                    editTextHexa.setText(String.valueOf(Long.toHexString(num)));
                    break;

                case R.id.etvBinary:
                    num = Long.parseLong(value,2);
                    editTextDecimal.setText(String.valueOf(num));
                    editTextOctal.setText(String.valueOf(Long.toOctalString(num)));
                    editTextHexa.setText(String.valueOf(Long.toHexString(num)));
                    break;
                case R.id.etvOctal:
                    num = Long.parseLong(value,8);
                    editTextDecimal.setText(String.valueOf(num));
                    editTextBinary.setText(String.valueOf(Long.toBinaryString(num)));
                    editTextHexa.setText(String.valueOf(Long.toHexString(num)));
                    break;
                case R.id.etvHexa:
                    num = Long.parseLong(value,16);
                    editTextDecimal.setText(String.valueOf(num));
                    editTextOctal.setText(String.valueOf(Long.toOctalString(num)));
                    editTextBinary.setText(String.valueOf(Long.toBinaryString(num)));
                    break;
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}