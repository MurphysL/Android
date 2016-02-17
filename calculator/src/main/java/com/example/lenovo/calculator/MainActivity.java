package com.example.lenovo.calculator;

import android.content.Intent;
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

import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        View.OnTouchListener,View.OnClickListener{

    public final static String TAG = "Calculator";

    //18键
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    private Button bt_5;
    private Button bt_6;
    private Button bt_7;
    private Button bt_8;
    private Button bt_9;
    private Button bt_0;
    private Button bt_CLEAN;
    private Button bt_DEL;
    private Button bt_PLUS;
    private Button bt_MINUS;
    private Button bt_DIVIDE;
    private Button bt_MULT;
    private Button bt_POINT;
    private Button bt_EQUAL;

    private EditText et_INPUT;
    private EditText et_OUTPUT;

    boolean flag;//清空标识

    private GestureDetector gestureDetector;//手势检测

    private static final int SWIPE_MIN_DISTANCE = 20;//滑动距离阙值
    private static final int SWIPE_THRESHOLD_VELOCITY = 10;//滑动速度阙值

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "--------onCreate--------");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    /**
     * 初始化
     */
    private void init(){
        Log.i(TAG, "--------init--------");

        flag = false;

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
        et_OUTPUT = (EditText) findViewById(R.id.et_input2);

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

        char c = ' ';

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
                if( str.length() >= 2 ) {
                    c = str.charAt(str.length() - 1);
                    if(c == '-' || c == '+' || c == '*' || c == '/') {
                        et_INPUT.setText(str + ((Button) v).getText());
                        autoGetResult();
                    }
                }else{
                    et_INPUT.setText(str + ((Button) v).getText());
                }
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
                et_INPUT.setText(str + ((Button) v).getText());
                break;
            case R.id.bt_C:
                flag = false;
                str ="";
                et_INPUT.setText("");
                et_OUTPUT.setText("");
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
     * 自动运算结果
     */
    private void autoGetResult() {

        Log.i(TAG, "--------autoGetResult--------");

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

        String str = et_INPUT.getText().toString();
        StringTokenizer expToken = new StringTokenizer(str , "+-*/" );//第一个参数就是要分隔的String，第二个是分隔字符集合

        Log.i(TAG, "--------开始计算--------");

        //直接按等号
        if (str == null || str.equals("")) {
            return;
        }

        //遍历字符串
        for(int i = 0;i < str.length();i ++){

            char c = str.charAt(i);

            //判断正负数
            if(i == 0) {
                if (c == '-') {
                    plus_minus_flag = -1;
                }
            }else if( str.charAt(i - 1) == '(' && c == '-'){
                plus_minus_flag = -1;
            }

            //取得数字
            if(c >= '0' && c <= '9' || c == '.'){

                Log.i(TAG , "--------数字--------");

                //取得符号后的整个数字
                num = expToken.nextToken();
                Log.i(TAG ,"expToken:" + num);

                ch = c;
                Log.i(TAG ,c + "--->" + i);

                while(i < str.length() && (ch <= '9' && ch >= '0' || ch == '.')){
                    ch = str.charAt(i++);
                }
                Log.i(TAG , c + "--->" + i);
                if ( i >= str.length() ) {
                    i -= 1;
                }else {
                    i -= 2;
                }

                Log.i(TAG , c + "--->" + i);

                //为.
                if (num .compareTo(".") == 0) {
                    number[maxNum ++] = 0;
                }
                // 将正负符号转移给数字
                else {
                    //字符串转换为double类型
                    number[maxNum] = Double.parseDouble(num) * plus_minus_flag;
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
                    default:
                        break;
                }

                Log.i(TAG, "--------符号运算--------");

                if( maxOp == 0 || opRank[ maxOp - 1 ] < temp ){
                    opRank[maxOp] = temp;
                    Log.i(TAG , "opRank[maxOp]:" + opRank[maxOp]);
                    operator[maxOp] = c;
                    Log.i(TAG , "operator[maxOp]:" + operator[maxOp]);
                    maxOp++;
                }else{
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
     * 运算结果
     */
    private void getResult() {

        Log.i(TAG, "--------getResult--------");

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

        String str = et_INPUT.getText().toString();
        StringTokenizer expToken = new StringTokenizer(str , "+-*/" );//第一个参数就是要分隔的String，第二个是分隔字符集合

        Log.i(TAG, "--------开始计算--------");

        //直接按等号
        if (str == null || str.equals("")) {
            return;
        }

        //遍历字符串
        for(int i = 0;i < str.length();i ++){

            char c = str.charAt(i);

            //判断正负数
            if(i == 0) {
                if (c == '-') {
                    plus_minus_flag = -1;
                }
            }else if( str.charAt(i - 1) == '(' && c == '-'){
                plus_minus_flag = -1;
            }

            //取得数字
            if(c >= '0' && c <= '9' || c == '.'){

                Log.i(TAG , "--------数字--------");

                //取得符号后的整个数字
                num = expToken.nextToken();
                Log.i(TAG ,"expToken:" + num);

                ch = c;
                Log.i(TAG ,c + "--->" + i);

                while(i < str.length() && (ch <= '9' && ch >= '0' || ch == '.')){
                    ch = str.charAt(i++);
                }
                Log.i(TAG , c + "--->" + i);
                if ( i >= str.length() ) {
                    i -= 1;
                }else {
                    i -= 2;
                }

                Log.i(TAG , c + "--->" + i);

                //为.
                if (num .compareTo(".") == 0) {
                    number[maxNum ++] = 0;
                }
                // 将正负符号转移给数字
                else {
                    //字符串转换为double类型
                    number[maxNum] = Double.parseDouble(num) * plus_minus_flag;
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
                    default:
                        break;
                }

                Log.i(TAG, "--------符号运算--------");

                if( maxOp == 0 || opRank[ maxOp - 1 ] < temp ){
                    opRank[maxOp] = temp;
                    Log.i(TAG , "opRank[maxOp]:" + opRank[maxOp]);
                    operator[maxOp] = c;
                    Log.i(TAG , "operator[maxOp]:" + operator[maxOp]);
                    maxOp++;
                }else{
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
                default:
                    break;
            }
            maxNum--;
            maxOp--;
        }

        Log.i(TAG, "--------INPUT--------");

        et_INPUT.setText(round(number[0]));
        et_OUTPUT.setText("");
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
