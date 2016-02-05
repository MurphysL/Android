package com.example.lenovo.calculator;

import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        View.OnTouchListener,View.OnClickListener{

    public final static String TAG = "Calculator";

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

    GestureDetector gestureDetector;//手势检测

    boolean flag = false;//清空标识

    private static final int SWIPE_MIN_DISTANCE = 20;
    private static final int SWIPE_THRESHOLD_VELOCITY = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "--------onCreate--------");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = new GestureDetector(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearlayout);
        layout.setOnTouchListener(this);
        layout.setLongClickable(true);

        //实例化
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

        //按钮监听事件
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

        //解决按键冲突
        bt_CLEAN.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_EQUAL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_DEL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_POINT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_PLUS.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_DIVIDE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_MULT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_MINUS.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });


        bt_7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_0.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });
    }

    /**
     * 按键点击
     * @param v
     */
    @Override
    public void onClick(View v) {

       Log.i(TAG, "--------onClick--------");

        //把对象转换成String类型
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
                    str ="";
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
                    str ="";
                    et_INPUT.setText("");
                }
                et_INPUT.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.bt_C:
                flag = false;
                str ="";
                et_INPUT.setText("");
                break;
            case R.id.bt_DEL:
                if(str != null && !str.equals("")){
                    et_INPUT.setText(str.substring(0,str.length() - 1));
                }
            case R.id.bt_eq:
                getResult();
                break;
            default:
                break;
        }
    }

    /**
     * 运算结果
     */
    private void getResult() {

        Log.i(TAG, "--------getResult--------");

        String str = et_INPUT.getText().toString();
        if (str == null || str.equals("")) {
            return;
        }
        //是否包含空格,即无运算符
        if (!str.contains(" ")) {
            return;
        }
        if(flag){
            flag = false;
            return;
        }
        flag = true;
        double result = 0;
        String s1 = str.substring(0, str.indexOf(" "));//运算符前面的字符串
        String op = str.substring(str.indexOf(" ") + 1, str.indexOf(" ") + 2);
        String s2 = str.substring(str.indexOf(" ") + 3);
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
            if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {
                int r = (int) result;
                et_INPUT.setText(r + "");
            } else {
                et_INPUT.setText(result + "");
            }
        } else if (!s1.equals(" ") && s2.equals(" ")) {
            et_INPUT.setText(str);
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
            et_INPUT.setText(str);
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    /**
     * 手势判断
     */
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //e1 The first down motion event that started the fling.手势起点的移动事件
        //e2 The move motion event that triggered the current onFling.当前手势点的移动事件
        //velocityX The velocity of this fling measured in pixels per second along the x axis.每秒x轴方向移动的像素
        //velocityY The velocity of this fling measured in pixels per second along the y axis.每秒y轴方向移动的像素

        Log.i(TAG, "--------onFling--------");

        if((e1.getX() - e2.getX()) > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
        {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            Toast.makeText(this, "高级计算器", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Log.i(TAG, "--------onTouch--------");

        return gestureDetector.onTouchEvent(event);
    }
}
