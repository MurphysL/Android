package com.example.lenovo.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * FamilyActivity
 *
 * @author: lenovo
 * @time: 2016/2/28 18:54
 */

public class FamilyActivity extends MainActivity /*implements View.OnClickListener*/{

    public final static String TAG = "Calculator";

    //16键
    private Button fbt_C;
    private Button fbt_DEL;
    private Button fbt_s;
    private Button fbt_equal;
    private Button bt_father;
    private Button bt_mather;
    private Button bt_husband;
    private Button bt_wife;
    private Button bt_elder_brother;
    private Button bt_younger_brother;
    private Button bt_elder_sisther;
    private Button bt_younger_sisther;
    private Button bt_son;
    private Button bt_daughter;
    private Button bt_elder;
    private Button bt_younger;

    private TextView fet_INPUT;
    private TextView fet_OUTPUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "--------onCreate FamilyActivity--------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        init();
    }

    /**
     * 初始化
     */
    public void init(){

        Log.i(TAG, "--------init FamilyActivity--------");

        //实例化
        fbt_C = (Button) findViewById(R.id.fbt_C);
        fbt_DEL = (Button) findViewById(R.id.fbt_DEL);
        fbt_equal = (Button) findViewById(R.id.fbt_equal);
        fbt_s = (Button) findViewById(R.id.fbt_s);
        bt_father = (Button) findViewById(R.id.bt_father);
        bt_mather = (Button) findViewById(R.id.bt_mather);
        bt_wife = (Button) findViewById(R.id.bt_wife);
        bt_husband = (Button) findViewById(R.id.bt_husband);
        bt_elder_brother = (Button) findViewById(R.id.bt_elder_brother);
        bt_younger_brother = (Button) findViewById(R.id.bt_younger_brother);
        bt_elder_sisther = (Button) findViewById(R.id.bt_elder_sisther);
        bt_younger_sisther = (Button) findViewById(R.id.bt_younger_sisther);
        bt_son = (Button) findViewById(R.id.bt_son);
        bt_daughter = (Button) findViewById(R.id.bt_daughter);
        bt_elder = (Button) findViewById(R.id.bt_elder);
        bt_younger = (Button) findViewById(R.id.bt_younger);

        fet_INPUT = (TextView) findViewById(R.id.fet_input);
        fet_OUTPUT = (TextView) findViewById(R.id.fet_output);

        //按钮监听事件
        bt_father.setOnClickListener(this);
        bt_mather.setOnClickListener(this);
        bt_husband.setOnClickListener(this);
        bt_wife.setOnClickListener(this);
        bt_elder_brother.setOnClickListener(this);
        bt_younger_brother.setOnClickListener(this);
        bt_elder_sisther.setOnClickListener(this);
        bt_younger_sisther.setOnClickListener(this);
        bt_son.setOnClickListener(this);
        bt_daughter.setOnClickListener(this);
        fbt_C.setOnClickListener(this);
        fbt_equal.setOnClickListener(this);
        fbt_DEL.setOnClickListener(this);
        fbt_s.setOnClickListener(this);
        bt_elder.setOnClickListener(this);
        bt_younger.setOnClickListener(this);
    }

    /**
     * 按键点击
     * @param v
     */
    @Override
    public void onClick(View v) {

        Log.i(TAG, "--------onClick--------");

        //把对象转换成String类型
        String str = fet_INPUT.getText().toString();

        char c = ' ';

        switch (v.getId()){
            case R.id.bt_father:
            case R.id.bt_mather:
            case R.id.bt_husband:
            case R.id.bt_wife:
            case R.id.bt_elder_brother:
            case R.id.bt_younger_brother:
            case R.id.bt_elder_sisther:
            case R.id.bt_younger_sisther:
            case R.id.bt_son:
            case R.id.bt_daughter:
                if(str.length() >= 2){
                    c = str.charAt(str.length() - 1);
                    if(c == '-' || c == '+' || c == '*' || c == '/'){
                        fet_INPUT.setText(str + ((Button) v).getText());
                        //AutoGetResult3();
                    }else{
                        fet_INPUT.setText(str + ((Button) v).getText());
                    }
                }else{
                    fet_INPUT.setText(str + ((Button) v).getText());
                }
                fet_INPUT.setText(str + ((Button) v).getText());
                break;
            case R.id.fbt_s:
            case R.id.bt_elder:
            case R.id.bt_younger:
                fet_INPUT.setText(str + ((Button) v).getText());
                break;
            case R.id.fbt_C:
                fet_INPUT.setText("");
                fet_OUTPUT.setText("");
                break;
            case R.id.bt_DEL:
                if(str != null && !str.equals("")){
                    Log.i(TAG, "--------lengthDEL--------" + str.length());
                    Log.i(TAG, "--------lengthDEL--------" + str);
                    fet_INPUT.setText(str.substring(0 , str.length() - 1));
                    Log.i(TAG, "--------lengthDEL--------" + str);
                    Log.i(TAG, "--------lengthDEL--------" + str.length());
                }
                break;
            case R.id.bt_eq:
                getResult3();
                break;
            default:
                break;
        }
    }

    /**
     * 运算结果
     */
    public void getResult3(){
        Log.i(TAG, "-----------------------------------------------------------------------");
        Log.i(TAG, "--------getResult3--------");
        Log.i(TAG, "-----------------------------------------------------------------------");

        String str3 = fet_INPUT.getText().toString();
        char temp_1 =' ' , temp_2 = ' ';
        String result = "";

        if(str3.length() == 3){

            for(int i = 0;i < str3.length();i ++){
                char c_f = str3.charAt(i);
                if(c_f == '的'){
                    continue;
                }else if(i == 0){
                    temp_1 = c_f;
                }else if (i == 2){
                    temp_2 = c_f;
                }
            }
        }

        if(temp_1 == '父'){
            if(temp_2 == '父'){
                result = "爷爷";
            }else if(temp_2 == '母'){
                result = "奶奶";
            }else if(temp_2 == '姐'){
                result = "奶奶";
            }else if(temp_2 == '妹'){

            }else if(temp_2 == '兄'){
                result = "大爷";
            }else if(temp_2 == '弟'){
                result = "叔叔";
            }else if(temp_2 == '子'){
                result = "我";

            }else if(temp_2 == '女'){

            }else if(temp_2 == '妻'){
                result = "母亲";
            }

        }else if(temp_1 == '母'){

        }else if(temp_1 == '姐'){

        }else if(temp_1 == '妹'){

        }else if(temp_1 == '兄'){

        }else if(temp_1 == '弟'){

        }else if(temp_1 == '子'){

        }else if(temp_1 == '女'){

        }else if(temp_1 == '妻'){

        }
    }

}
