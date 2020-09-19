package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_error,tv_sign,tv_result;
    private EditText et_num1,et_num2;
    private Button btn_add,btn_sub,btn_mul,btn_div,btn_equl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn_equl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_sign.setText(btn_add.getText().toString());
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_sign.setText(btn_sub.getText().toString());
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_sign.setText(btn_mul.getText().toString());
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_sign.setText(btn_div.getText().toString());
            }
        });
    }

    private void validation() {
        String num1 = et_num1.getText().toString().trim();
        String num2 = et_num2.getText().toString().trim();

        if (num1.isEmpty()){
            et_num1.setError("Please enter number");
            et_num1.requestFocus();
        }else if (num2.isEmpty()){
            et_num2.setError("Please enter number");
            et_num2.requestFocus();
        }else {
            int number1 = Integer.parseInt(num1);
            int number2 = Integer.parseInt(num2);
            String result;
            if (tv_sign.equals("+")){
                result = String.valueOf(number1 + number2);
                tv_result.setText(result);
            }else if (tv_sign.equals("-")){
                if (number1 < number2){
                    tv_error.setText("Number1 is less then Number2");
                    tv_error.setVisibility(View.VISIBLE);
                }else {
                    result = String.valueOf(number1 - number2);
                    tv_result.setText(result);
                }
            }else if (tv_sign.equals("*")){
                result = String.valueOf(number1 * number2);
                tv_result.setText(result);
            }else if(tv_sign.equals("/")){
                if (num2.equals("0")){
                    tv_error.setText("Number is not divisibal by 0");
                    tv_error.setVisibility(View.VISIBLE);
                }else {
                    result = String.valueOf(number1 / number2);
                    tv_result.setText(result);
                }
            }
        }
    }

    private void init() {
        tv_error = findViewById(R.id.tv_error);
        tv_sign = findViewById(R.id.tv_sign);
        tv_result = findViewById(R.id.tv_result);

        et_num1 = findViewById(R.id.et_num1);
        et_num2 = findViewById(R.id.et_num2);

        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);
        btn_equl = findViewById(R.id.btn_eql);
    }
}