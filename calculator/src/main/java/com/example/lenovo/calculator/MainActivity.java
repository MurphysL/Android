package com.example.lenovo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_1;
    Button bt_2;
    Button bt_3;
    Button bt_4;
    Button bt_5;
    Button bt_6;
    Button bt_7;
    Button bt_8;
    Button bt_9;
    Button bt_0;
    Button bt_CLEAN;
    Button bt_DEL;
    Button bt_PLUS;
    Button bt_MINUS;
    Button bt_DIVIDE;
    Button bt_MULT;
    Button bt_POINT;
    Button bt_EQUAL;
    EditText et_INPUT;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_0 = (Button) findViewById(R.id.bt_0);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_4 = (Button) findViewById(R.id.bt_4);
        bt_5 = (Button) findViewById(R.id.bt_5);
        bt_6 = (Button) findViewById(R.id.bt_6);
        bt_7 = (Button) findViewById(R.id.bt_7);
        bt_8 = (Button) findViewById(R.id.bt_8);
        bt_9 = (Button) findViewById(R.id.bt_9);
        bt_POINT = (Button) findViewById(R.id.bt_point);
        bt_EQUAL = (Button) findViewById(R.id.bt_eq);
        bt_PLUS = (Button) findViewById(R.id.bt_add);
        bt_MINUS = (Button) findViewById(R.id.bt_decrease);
        bt_MULT = (Button) findViewById(R.id.bt_mult);
        bt_DIVIDE = (Button) findViewById(R.id.bt_division);
        bt_DEL = (Button) findViewById(R.id.bt_DEL);
        bt_CLEAN = (Button) findViewById(R.id.bt_C);
        et_INPUT = (EditText) findViewById(R.id.et_input);

        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_CLEAN.setOnClickListener(this);
        bt_EQUAL.setOnClickListener(this);
        bt_DEL.setOnClickListener(this);
        bt_POINT.setOnClickListener(this);
        bt_PLUS.setOnClickListener(this);
        bt_MINUS.setOnClickListener(this);
        bt_MULT.setOnClickListener(this);
        bt_DIVIDE.setOnClickListener(this);
        et_INPUT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String str = et_INPUT.getText().toString();
        switch (v.getId()){
            case R.id.bt_0:
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
            case R.id.bt_point:
                if(flag){
                    flag = false;
                    et_INPUT.setText("");
                }
                et_INPUT.setText(str + ((Button)v).getText());
                break;
            case R.id.bt_add:
            case R.id.bt_decrease:
            case R.id.bt_mult:
            case R.id.bt_division:
                if(flag){
                    flag = false;
                    et_INPUT.setText("");
                }
                et_INPUT.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.bt_C:
                flag = false;
                et_INPUT.setText("");
                break;
            case R.id.bt_DEL:
                if(str != null && str.equals("")){
                    et_INPUT.setText(str.substring(0,str.length() - 1));
                }
            case R.id.bt_eq:
                getResult();
                break;
            default:
                break;
        }
    }

    private void getResult() {
        String exp = et_INPUT.getText().toString();
        if (exp == null || exp.equals("")) {
            return;
        }
        if (!exp.contains(" ")) {
            return;
        }
        if(flag){
            flag = false;
            return;
        }
        flag = true;
        double result = 0;
        String s1 = exp.substring(0, exp.indexOf(" "));//运算符前面的字符串
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String s2 = exp.substring(exp.indexOf(" ") + 3);
        if (!s1.equals(" ") && !s2.equals(" ")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                result = d1 + d2;
            } else if (op.equals("-")) {
                result = d1 - d2;
            } else if (op.equals("*")) {
                result = d1 * d2;
            } else if (op.equals("/")) {

                if (d2 == 0) {
                    result = 0;
                } else {
                    result = d1 / d2;
                }
            }
            if (!s1.contains(".") && !s2.contains(".")) {
                int r = (int) result;
                et_INPUT.setText(r + "");
            } else {
                et_INPUT.setText(result + "");
            }
        } else if (!s1.equals(" ") && s2.equals(" ")) {
            et_INPUT.setText(exp);
        } else if (s1.equals(" ") && !s2.equals(" ")) {
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                result = 0 + d2;
            } else if (op.equals("-")) {
                result = 0 - d2;
            } else if (op.equals("*")) {
                result = 0;
            } else if (op.equals("/")) {
                result = 0;
            }
            if (!s2.contains(".")) {
                int r = (int) result;
                et_INPUT.setText(r + "");
            } else {
                et_INPUT.setText(result + "");
            }
        }else {
            et_INPUT.setText(exp);
        }
    }
}
