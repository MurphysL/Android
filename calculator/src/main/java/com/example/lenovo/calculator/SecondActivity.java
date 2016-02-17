package com.example.lenovo.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 * SecondActivity
 *
 * @author: lenovo
 * @time: 2016/2/2 21:30
 */

public class SecondActivity extends Activity implements View.OnClickListener/*,
        GestureDetector.OnGestureListener,View.OnTouchListener*/{

    public final static String TAG = "Calculator";

    //30键
    private Button bt_0;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    private Button bt_5;
    private Button bt_6;
    private Button bt_7;
    private Button bt_8;
    private Button bt_9;
    private Button bt_PI;
    private Button bt_E;
    private Button bt_SIN;
    private Button bt_COS;
    private Button bt_TAN;
    private Button bt_LOG;
    private Button bt_LN;
    private Button bt_POINT;//小数点
    private Button bt_PLUS;//加
    private Button bt_MINUS;//减
    private Button bt_MULT;//乘
    private Button bt_DIVIDE;//除
    private Button bt_FACTORIAL;//阶乘
    private Button bt_POWER;//幂
    private Button bt_RADICAL;//根
    private Button bt_L_BRACKET;//左括号
    private Button bt_R_BRACKET;//右括号
    private Button bt_CLEAN;//清空
    private Button bt_DEL;//删除
    private Button bt_EQUAL;//等于

    private EditText et_INPUT;
    private EditText et_OUTPUT;

    private double pi = Math.PI;
    private static final double e_num = 2.7182818;

    GestureDetector gestureDetector;

    private static final int SWIPE_MIN_DISTANCE = 20;//滑动距离阙值
    private static final int SWIPE_THRESHOLD_VELOCITY = 10;//滑动速度阙值

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
    }

    /**
     * 初始化
     */
    private void init(){

        /*gestureDetector = new GestureDetector(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearlayout);
        layout.setOnTouchListener(this);
        layout.setLongClickable(true);*/

        //按键实例化
        bt_0 = (Button) findViewById(R.id.sbt_0);
        bt_1 = (Button) findViewById(R.id.sbt_1);
        bt_2 = (Button) findViewById(R.id.sbt_2);
        bt_3 = (Button) findViewById(R.id.sbt_3);
        bt_4 = (Button) findViewById(R.id.sbt_4);
        bt_5 = (Button) findViewById(R.id.sbt_5);
        bt_6 = (Button) findViewById(R.id.sbt_6);
        bt_7 = (Button) findViewById(R.id.sbt_7);
        bt_8 = (Button) findViewById(R.id.sbt_8);
        bt_9 = (Button) findViewById(R.id.sbt_9);
        bt_POINT = (Button) findViewById(R.id.sbt_point);
        bt_EQUAL = (Button) findViewById(R.id.sbt_equal);
        bt_PLUS = (Button) findViewById(R.id.sbt_add);
        bt_MINUS = (Button) findViewById(R.id.sbt_decrease);
        bt_MULT = (Button) findViewById(R.id.sbt_mult);
        bt_DIVIDE = (Button) findViewById(R.id.sbt_division);
        bt_DEL = (Button) findViewById(R.id.sbt_DEL);
        bt_CLEAN = (Button) findViewById(R.id.sbt_Cd);
        bt_COS = (Button) findViewById(R.id.sbt_cos);
        bt_TAN = (Button) findViewById(R.id.sbt_tan);
        bt_SIN = (Button) findViewById(R.id.sbt_sin);
        bt_FACTORIAL = (Button) findViewById(R.id.sbt_factorial);
        bt_L_BRACKET = (Button) findViewById(R.id.sbt_leftbracket);
        bt_R_BRACKET = (Button) findViewById(R.id.sbt_rightbracket);
        bt_POWER = (Button) findViewById(R.id.sbt_power);
        bt_RADICAL = (Button) findViewById(R.id.sbt_radical);
        bt_PI = (Button) findViewById(R.id.sbt_π);
        bt_E = (Button) findViewById(R.id.sbt_e);
        bt_LOG = (Button) findViewById(R.id.sbt_log);
        bt_LN = (Button) findViewById(R.id.sbt_ln);
        et_INPUT = (EditText) findViewById(R.id.et_input3);
        et_OUTPUT = (EditText) findViewById(R.id.et_input4);

        //绑定监听器
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
        bt_COS.setOnClickListener(this);
        bt_TAN.setOnClickListener(this);
        bt_SIN.setOnClickListener(this);
        bt_LN.setOnClickListener(this);
        bt_LOG.setOnClickListener(this);
        bt_R_BRACKET.setOnClickListener(this);
        bt_L_BRACKET.setOnClickListener(this);
        bt_E.setOnClickListener(this);
        bt_PI.setOnClickListener(this);
        bt_RADICAL.setOnClickListener(this);
        bt_POWER.setOnClickListener(this);
        bt_FACTORIAL.setOnClickListener(this);

        /*//解决按键冲突
        et_INPUT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        et_OUTPUT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

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

        bt_COS.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_SIN.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_TAN.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_LN.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_LOG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_R_BRACKET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_L_BRACKET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_E.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_PI.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_RADICAL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_POWER.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bt_FACTORIAL.setOnTouchListener(new View.OnTouchListener() {
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
        });*/
    }

    /**
     * 按键点击
     * @param v
     */
    @Override
    public void onClick(View v) {

        Log.i(TAG , "--------onClick2--------");

        //把对象转换成String类型
        String str2 = et_INPUT.getText().toString();

        switch ( v.getId() ){
            case R.id.sbt_0:
            case R.id.sbt_1:
            case R.id.sbt_2:
            case R.id.sbt_3:
            case R.id.sbt_4:
            case R.id.sbt_5:
            case R.id.sbt_6:
            case R.id.sbt_7:
            case R.id.sbt_8:
            case R.id.sbt_9:
            case R.id.sbt_cos:
            case R.id.sbt_sin:
            case R.id.sbt_tan:
            case R.id.sbt_ln:
            case R.id.sbt_leftbracket:
            case R.id.sbt_rightbracket:
            case R.id.sbt_radical:
            case R.id.sbt_π:
            case R.id.sbt_e:
            case R.id.sbt_power:
            case R.id.sbt_point:
                et_INPUT.setText( str2 + ((Button) v).getText() );
                break;

            case R.id.sbt_log:
                et_INPUT.setText( str2 + ((Button) v).getText() + '(');
                break;
            case R.id.sbt_factorial:
                et_INPUT.setText( str2 + ((Button) v).getText() + ' ');
                break;
            case R.id.sbt_add:
            case R.id.sbt_decrease:
            case R.id.sbt_mult:
            case R.id.sbt_division:
                et_INPUT.setText(str2 + ((Button) v).getText());
                break;
            case R.id.sbt_Cd:
                et_INPUT.setText("");
                et_OUTPUT.setText("");
                break;
            case R.id.sbt_DEL:
                if(str2 != null && !str2.equals("")){
                    //截取字符串
                    if(delNumber(str2) == 3){
                        if(str2.length() > 3){
                            et_INPUT.setText(str2.substring(0,str2.length() - 3));
                        }else if (str2.length() == 3){
                            et_INPUT.setText("");
                        }
                    }else if(delNumber(str2) == 2){
                        if(str2.length() > 2){
                            et_INPUT.setText(str2.substring(0, str2.length() - 2));
                        }else if (str2.length() == 2){
                            et_INPUT.setText("");
                        }
                    }else if (delNumber(str2) == 1){
                        if (str2.length() > 1) {
                            et_INPUT.setText(str2.substring(0, str2.length() - 1));
                        }else if (str2.length() == 1) {
                            et_INPUT.setText("");
                        }
                    }
                }
            case R.id.sbt_equal:
                getResult2();
                break;
            default:
                break;
        }
    }

    /**
     * 运算结果
     */
    private void getResult2() {

        Log.i(TAG, "-----------------------------------------------------------------------");
        Log.i(TAG, "--------getResult2--------");
        Log.i(TAG, "-----------------------------------------------------------------------");

        int rank = 0;//括号优先级
        int temp = 0;//符号优先级

        int plus_minus_flag = 1;// flag为正负数的计数器，1为正数，-1为负数
        char operator[]  = new char[200];// operator[]保存运算符
        int opRank[] = new int[200];;// 运算符的优先级
        int maxOp = 0;
        double number[] = new double[200];//保存数字
        int maxNum = 0;
        String num;//记录数字
        char ch;

        String str2 = et_INPUT.getText().toString();

        // 替换算式中的运算符
        str2 = str2.replaceAll("sin", "s");
        str2 = str2.replaceAll("cos", "c");
        str2 = str2.replaceAll("tan", "t");
        str2 = str2.replaceAll("log", "l");
        str2 = str2.replaceAll("ln", "n");

        StringTokenizer expToken = new StringTokenizer(str2 , "+-*/()sctln!√^ " );//第一个参数就是要分隔的String，第二个是分隔字符集合

        Log.i(TAG, "--------开始计算--------");

        //直接按等号
        if (str2 == null || str2.equals("")) {
            return;
        }


        //遍历字符串
        for(int i = 0;i < str2.length();i ++){

            char c = str2.charAt(i);

            //判断正负数
            if(i == 0) {
                if (c == '-') {
                    plus_minus_flag = -1;
                }
            }else if( str2.charAt(i - 1) == '(' && c == '-'){
                plus_minus_flag = -1;
            }

            //取得数字
            if(c >= '0' && c <= '9' || c == '.' || c == 'e' || c == 'π'){

                Log.i(TAG , "--------数字--------");

                //取得符号后的整个数字
                num = expToken.nextToken();
                Log.i(TAG ,"expToken:" + num);

                ch = c;
                Log.i(TAG ,c + "--->" + i);

                while(i < str2.length() && (ch <= '9' && ch >= '0' || ch == '.' || ch == 'e' || ch == 'π')){
                    ch = str2.charAt(i++);
                }
                Log.i(TAG , c + "--->" + i);
                if ( i >= str2.length() ) {
                    i -= 1;
                }else {
                    i -= 2;
                }

                Log.i(TAG , c + "--->" + i);

                //为.
                if (num .compareTo(".") == 0) {
                    
                    number[maxNum ++] = 0;
                }else{
                    //字符串转换为double类型
                    if(num.compareTo("e" ) == 0|| num.compareTo("π") == 0){
                        if(num.compareTo("e" ) == 0) {
                            number[maxNum] = (double)e_num;
                        }else{
                            number[maxNum] = (double)pi;
                            Log.i( TAG , "number" + "[" + maxNum + "]" + ":" + number[maxNum]);
                        }
                    }else {
                        number[maxNum] = Double.parseDouble(num) * plus_minus_flag;
                    }
                    Log.i( TAG , "number" + "[" + maxNum + "]" + ":" + number[maxNum]);
                    maxNum++;
                    //正负标识初始化
                    plus_minus_flag = 1;
                }
            }

            Log.i(TAG, "--------优先级--------");
            //------[ 1 + 2 * 5 * ( 6 - ( - 7 * 2 )) / 1 ]------
            //------    1   2   2 r4  5 r8    10 -r8 2    ------
            if(c == '(')
                rank += 4;
            if(c == ')')
                rank -= 4;
            if(c == '-' && plus_minus_flag == 1 || c == '+' || c == '*' || c == '/' ||
                    c == 's' || c == 'c' || c == 't' || c == 'l' || c == 'n' || c == '!' || c == '√' || c == '^'){
                switch (c){
                    case '+':
                    case '-':
                        temp = 1 + rank;
                        break;
                    case '*':
                    case '/':
                        temp = 2 + rank;
                        break;
                    case '^':
                    case '√':
                        temp = 4 + rank;
                        break;
                    case 's':
                    case 'c':
                    case 't':
                    case 'l':
                    case 'n':
                    case '!':
                        temp = 3 + rank;
                        break;
                    default:
                        break;
                }
                Log.i(TAG, "--------符号运算--------");
                //------[ 1 + 2 * 5 * ( 6 - ( - 7 * 2 )) / 1 ]------
                //------    1   2   2 r4  5 r8    10 -r8 2    ------

                //如果当前符号优先级大于堆栈顶部元素，则直接入栈
                //排除数字干扰
                if( maxOp == 0 || opRank[ maxOp - 1 ] < temp ){
                    Log.i(TAG, "--------入栈--------");
                    opRank[maxOp] = temp;
                    Log.i(TAG , "opRank[maxOp]:" + opRank[maxOp]);
                    operator[maxOp] = c;
                    Log.i(TAG , "operator[maxOp]:" + operator[maxOp]);
                    maxOp++;
                    //否则将堆栈中运算符逐个取出，直到当前堆栈顶部运算符的优先级小于当前运算符
                }else{
                    Log.i(TAG, "--------出栈--------");
                    while (maxOp > 0 && opRank[ maxOp - 1 ] >= temp) {
                        switch (operator[ maxOp - 1 ]) {
                            case '+':
                                Log.i(TAG , "--------加--------");
                                number[ maxNum - 2 ] += number[ maxNum - 1 ];
                                break;
                            case '-':
                                Log.i(TAG , "--------减--------");
                                number[ maxNum - 2 ] -= number[ maxNum - 1];
                                break;
                            case '*':
                                Log.i(TAG , "--------乘--------");
                                number[ maxNum - 2 ] *= number[ maxNum - 1 ];
                                break;
                            case '/':
                                Log.i(TAG , "--------除--------");
                                if(number[ maxNum - 1 ] == 0){
                                    et_INPUT.setText("");
                                    showError(1);
                                    return;
                                }
                                number[ maxNum - 2 ] /= number[ maxNum - 1 ];
                                break;
                            case '√':
                                Log.i(TAG , "--------根--------");
                                if(number[ maxNum - 2 ] == 0 || (number[ maxNum - 1 ] < 0 && number[ maxNum - 2 ] % 2 == 0)){
                                    showError(2);
                                    return;
                                }
                                number[ maxNum - 2 ] = Math.pow(number[ maxNum - 1 ] , 1 / number[ maxNum - 2 ]);
                                break;
                            case '^':
                                Log.i(TAG , "--------次方--------");
                                number[ maxNum - 2 ] = Math.pow(number[ maxNum - 2 ] , number[ maxNum - 1 ]);
                                break;
                            case 's':
                                Log.i(TAG , "--------sin--------");
                                number[ maxNum - 1 ] = Math.sin((number[ maxNum - 1 ] / 180) * pi);
                                maxNum++;
                                break;
                            case 'c':
                                Log.i(TAG , "--------cos--------");
                                number[ maxNum - 1 ] = Math.cos((number[ maxNum - 1 ] / 180) * pi);
                                maxNum++;
                                break;
                            case 't':
                                Log.i(TAG , "--------tan--------");
                                if ((Math.abs(number[ maxNum - 1 ]) / 90) % 2 == 1) {
                                    showError(2);
                                    return;
                                }
                                number[ maxNum - 1 ] = Math.tan((number[ maxNum - 1 ] / 180) * pi);
                                maxNum++;
                                break;
                            case 'n':
                                Log.i(TAG , "--------ln--------");
                                if (number[ maxNum - 1 ] <= 0) {
                                    showError(2);
                                    return;
                                }
                                number[ maxNum - 1 ] = Math.log(number[ maxNum - 1 ]);
                                maxNum++;
                                break;
                            case 'l':
                                Log.i(TAG , "--------log--------");
                                if (number[ maxNum - 1 ] <= 0) {
                                    showError(2);
                                    return;
                                }
                                number[ maxNum - 2 ] = myLog(number[maxNum - 2], number[maxNum - 1]);
                                maxNum++;
                                break;
                            case '!':
                                Log.i(TAG , "--------阶乘--------");
                                if (number[maxNum - 1] < 0) {
                                    showError(2);
                                    return;
                                }
                                double sum = 1;
                                for (int j = 1; j <= number[maxNum - 1]; j++) {
                                    sum = sum * j;
                                }
                                Log.i(TAG , "maxNum:" + maxNum);
                                number[maxNum - 1] = sum;
                                maxNum++;
                                break;
                            default:
                                break;
                        }
                        maxNum--;
                        maxOp--;
                    }
                    opRank[maxOp] = temp;
                    operator[maxOp] = c;
                    maxOp++;
                }
            }
        }
        while (maxOp > 0){
            switch (operator[ maxOp - 1 ]) {
                case '+':
                    Log.i(TAG , "--------加--------");
                    number[ maxNum - 2 ] += number[ maxNum - 1 ];
                    break;
                case '-':
                    Log.i(TAG , "--------减--------");
                    number[ maxNum - 2 ] -= number[ maxNum - 1];
                    break;
                case '*':
                    Log.i(TAG , "--------乘--------");
                    number[ maxNum - 2 ] *= number[ maxNum - 1 ];
                    break;
                case '/':
                    Log.i(TAG , "--------除--------");
                    if(number[ maxNum - 1 ] == 0){
                        et_INPUT.setText("");
                        showError(1);
                        return;
                    }
                    number[ maxNum - 2 ] /= number[ maxNum - 1 ];
                    break;
                case '√':
                    Log.i(TAG , "--------根--------");
                    if(number[ maxNum - 2 ] == 0 || (number[ maxNum - 1 ] < 0 && number[ maxNum - 2 ] % 2 == 0)){
                        showError(2);
                        return;
                    }
                    number[ maxNum - 2 ] = Math.pow(number[ maxNum - 1 ] , 1 / number[ maxNum - 2 ]);
                    break;
                case '^':
                    Log.i(TAG , "--------次方--------");
                    number[ maxNum - 2 ] = Math.pow(number[ maxNum - 2 ] , number[ maxNum - 1 ]);
                    break;
                case 's':
                    Log.i(TAG , "--------sin--------");
                    number[ maxNum - 1 ] = Math.sin((number[ maxNum - 1 ] / 180) * pi);
                    maxNum++;
                    break;
                case 'c':
                    Log.i(TAG , "--------cos--------");
                    number[ maxNum - 1 ] = Math.cos((number[ maxNum - 1 ] / 180) * pi);
                    maxNum++;
                    break;
                case 't':
                    Log.i(TAG , "--------tan--------");
                    if ((Math.abs(number[ maxNum - 1 ]) / 90) % 2 == 1) {
                        showError(2);
                        return;
                    }
                    number[ maxNum - 1 ] = Math.tan((number[ maxNum - 1 ] / 180) * pi);
                    maxNum++;
                    break;
                case 'n':
                    Log.i(TAG , "--------ln--------");
                    if (number[ maxNum - 1 ] <= 0) {
                        showError(2);
                        return;
                    }
                    number[ maxNum - 1 ] = Math.log(number[ maxNum - 1 ]);
                    maxNum++;
                    break;
                case 'l':
                    Log.i(TAG , "--------log--------");
                    if (number[ maxNum - 1 ] <= 0) {
                        showError(2);
                        return;
                    }
                    number[ maxNum - 2 ] = myLog(number[maxNum - 2], number[maxNum - 1]);
                    maxNum++;
                    break;
                case '!':
                    Log.i(TAG , "--------阶乘--------");
                    if (number[maxNum - 1] < 0) {
                        showError(2);
                        return;
                    }
                    double sum = 1;
                    for (int j = 1; j <= number[maxNum - 1]; j++) {
                        sum = sum * j;
                    }
                    Log.i(TAG , "maxNum:" + maxNum);
                    number[maxNum - 1] = sum;
                    maxNum++;
                    break;
                default:
                    break;
            }
            maxNum--;
            maxOp--;
        }

        Log.i(TAG, "--------INPUT--------");
        et_OUTPUT.setText(round(number[0]));
    }

    /**
     * 控制格式
     * @param n
     * @return
     */
    public String round(double n) {
        DecimalFormat format = new DecimalFormat("0.##########");
        return format.format(n);
    }

    /**
     * 判断DEL的字数
     * @param str2
     * @return
     */
    private int delNumber(String str2) {
        if ((str2.charAt(str2.length() - 1) == 'n' && str2.charAt(str2.length() - 2) == 'i' && str2.charAt(str2.length() - 3) == 's')
                || (str2.charAt(str2.length() - 1) == 's' && str2.charAt(str2.length() - 2) == 'o' && str2.charAt(str2.length() - 3) == 'c')
                || (str2.charAt(str2.length() - 1) == 'n' && str2.charAt(str2.length() - 2) == 'a' && str2.charAt(str2.length() - 3) == 't')
                || (str2.charAt(str2.length() - 1) == 'g' && str2.charAt(str2.length() - 2) == 'o' && str2.charAt(str2.length() - 3) == 'l')) {
            return 3;
        } else if ((str2.charAt(str2.length() - 1) == 'n' && str2.charAt(str2.length() - 2) == 'l')
                || (str2.charAt(str2.length() - 1) == '!' && str2.charAt(str2.length() - 2) == 'n')){
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * myLog
     * @param base
     * @param value
     * @return
     */
    private double myLog(double base, double value){
        return Math.log(value) / Math.log(base);
    }

    /**
     * 错误提示
     * @param code
     */
    public void showError(int code) {
        switch (code) {
            case 1:
                Toast.makeText(this,"零不能作除数",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this,"用法错误",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /*@Override
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
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        Log.i(TAG, "--------onFling--------");

        if((e1.getX() - e2.getX()) > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
        {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "简单计算器", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }*/
}
